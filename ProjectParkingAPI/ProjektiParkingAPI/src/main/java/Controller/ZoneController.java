package Controller;

import DTO.HttpResponseDTO;
import DTO.Zone;
import DTO.ZoneRequest;
import DTO.ZoneRequestResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.*;

@RestController
@RequestMapping("/zone")
public class ZoneController {

    //krijohet HashMap qe fut vlerat e ZoneRequestit
    private HashMap<UUID, ZoneRequest> zonerequestlist = new HashMap<>();
    private List zonelist = new ArrayList();

    @PostMapping("/")
    public HttpResponseDTO<ZoneRequestResponse> requestnewzone (@RequestBody ZoneRequest zoneRequest){

        ZoneRequestResponse zoneRequestResponse = new ZoneRequestResponse();
        zoneRequestResponse.setRequestId(UUID.randomUUID());
        zonerequestlist.put(zoneRequestResponse.getRequestId(),zoneRequest);

        return new HttpResponseDTO<>(true,zoneRequestResponse);
    }

    @GetMapping("/zonereqeustlist")
    public HttpResponseDTO<HashMap<UUID,ZoneRequest>> zonerequestlist(){

        return new HttpResponseDTO<>(true,zonerequestlist);

    }

    @GetMapping("/{uuid}")
    public HttpResponseDTO<ZoneRequest> getItem(@PathVariable("uuid")UUID id){

        if(zonerequestlist.containsKey(id))
            return new HttpResponseDTO<>(true,zonerequestlist.get(id));
            return new HttpResponseDTO<>(false,null);
    }

    @GetMapping("/zones")
    public HttpResponseDTO<List<Zone>> getZones(){

        return new HttpResponseDTO<>(true,zonelist);
    }

    @Scheduled(fixedDelay = 5000)
    public void generatedZones() {

        for(char i='A';i<'G';i++){
            UUID id = zonerequestlist.keySet().stream().iterator().hasNext() ? zonerequestlist.keySet().stream().iterator().next() : null;

            if(id!=null){

                ZoneRequest zoneRequest = zonerequestlist.get(id);
                zonelist.add(new Zone(id,zoneRequest.getName(),zoneRequest.getZones()));
                zonerequestlist.remove(id);

            }
        }
    }
}
