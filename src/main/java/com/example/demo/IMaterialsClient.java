package com.example.demo;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "data", url = "https://materialsproject.org/rest/v2/")
public interface IMaterialsClient {
 
    @RequestMapping(method = RequestMethod.GET, value = "/materials/{form}/vasp?API_KEY=el9G7oBgSUMOqwm3")
    ResponseEntity<Request> getMaterial(@PathVariable String form);
 
}  