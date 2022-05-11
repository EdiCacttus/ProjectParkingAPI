package Controller;


import DTO.*;
import Model.Cities;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cities")
public class CityController {


    HashMap<UUID, CityRequest> cityrequestlist = new HashMap<>();
    private List citylist = new ArrayList();

    @PostMapping("/")
    public HttpResponseDTO<CityRequestResponse> newcityRequest(@RequestBody CityRequest cityRequest){

        CityRequestResponse cityRequestResponse = new CityRequestResponse();
        cityRequestResponse.setRequestId(UUID.randomUUID());
        cityrequestlist.put(cityRequestResponse.getRequestId(),cityRequest);
        return new HttpResponseDTO<>(true,cityRequestResponse);
    }
    @GetMapping("/cityrequestlist")
    public HttpResponseDTO<HashMap<UUID,CityRequest>> cityrequestlist(){

        return new HttpResponseDTO<>(true,cityrequestlist);

    }

    @GetMapping("{/uuid}")
    public  HttpResponseDTO<CityRequest> getCities(@PathVariable("uuid")UUID id){

        if (cityrequestlist.containsKey(id))
            return new HttpResponseDTO<>(true,cityrequestlist.get(id));
            return new HttpResponseDTO<>(false,null);
    }

    public HttpResponseDTO<List<CitiesDTO>> getCities(){

        return new HttpResponseDTO<>(true,citylist);

    }

    @Scheduled(fixedDelay = 5000)
    public void generatedCities(){

        for(char i=0;i<7;i++){
            UUID id = cityrequestlist.keySet().stream().iterator().hasNext() ? cityrequestlist.keySet().stream().iterator().next() : null;

            if(id!=null){

                CityRequest cityRequest = cityrequestlist.get(id);
                citylist.add(new CitiesDTO(id,cityRequest.getZone(),cityRequest.getNrmakinave(),cityRequest.getId()));
                cityrequestlist.remove(id);
            }

        }


    }





}
