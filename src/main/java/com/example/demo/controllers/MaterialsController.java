package com.example.demo.controllers;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.IMaterialsClient;
import com.example.demo.Material;
import com.example.demo.Request;

import org.apache.tomcat.util.http.HeaderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties.Infinispan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class MaterialsController {

    private final IMaterialsClient materialsClient;

    public MaterialsController(IMaterialsClient materialsClient)
    {
        this.materialsClient = materialsClient;
    }

    @GetMapping(path = "/materials/{form}")
    ResponseEntity<Request> getMaterial(@PathVariable String form) throws URISyntaxException {
        URI location = new URI("/materials");
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(location);
        responseHeaders.set("MyResponseHeader", "MyValue");
        return new ResponseEntity<Request>(
            materialsClient.getMaterial(form).getBody(),
            responseHeaders, HttpStatus.OK);      
    }

    @GetMapping(path = "/startAllMaterials")
    String startAllMaterials() {

        List<String[]> baseReaction = new ArrayList<String[]>();
        baseReaction.add(new String[] { "H2S", "", "SiO2", "97.00" });
        baseReaction.add(new String[] { "NO", "", "CuO", "48.00" });
        baseReaction.add(new String[] { "CH4", "NH3", "Si", "1.64" });
        baseReaction.add(new String[] { "H2S", "SO2", "C", "87.00" });
        baseReaction.add(new String[] { "CH4", "", "CeO2", "99.80" });
        baseReaction.add(new String[] { "SO2", "", "La2(SO7)3", "18.00" });
        baseReaction.add(new String[] { "ZnS", "NiS", "CuO", "25.00" });

        Map<Double[], Double> resultMap = new HashMap<>();        

        baseReaction.stream().forEach(t -> {
            
            Material infoFirstReagent = null;
            Material infoSecondReagent = null;
            
            if (t[0] != "")
                infoFirstReagent = materialsClient.getMaterial(t[0]).getBody().getResponse().stream().findFirst().orElse(null);
            
            if (t[1] != "")
                infoSecondReagent = materialsClient.getMaterial(t[1]).getBody().getResponse().stream().findFirst().orElse(null);
            
            if (infoFirstReagent != null) 
            {
                if (infoSecondReagent == null)
                {
                    resultMap.put(new Double[] { Sigmoid(infoFirstReagent.getDensity()),
                                                Sigmoid(infoFirstReagent.getE_above_hull()),
                                                Sigmoid(infoFirstReagent.getEnergy()),
                                                Sigmoid(infoFirstReagent.getEnergy_per_atom()),
                                                Sigmoid(infoFirstReagent.getFormation_energy_per_atom()),
                                                Sigmoid(infoFirstReagent.getNsites()),
                                                Sigmoid(infoFirstReagent.getTotal_magnetization()),
                                                Sigmoid(infoFirstReagent.getVolume())
                                            }, getForLastLayer(t[3]));
                }
                else 
                {

                    resultMap.put(new Double[] { Sigmoid(infoFirstReagent.getDensity()+infoSecondReagent.getDensity()),
                        Sigmoid(infoFirstReagent.getE_above_hull()+infoSecondReagent.getE_above_hull()),
                        Sigmoid(infoFirstReagent.getEnergy()+infoSecondReagent.getEnergy()),
                        Sigmoid(infoFirstReagent.getEnergy_per_atom()+infoSecondReagent.getEnergy_per_atom()),
                        Sigmoid(infoFirstReagent.getFormation_energy_per_atom()+infoSecondReagent.getFormation_energy_per_atom()),
                        Sigmoid(infoFirstReagent.getNsites()+infoSecondReagent.getNsites()),
                        Sigmoid(infoFirstReagent.getTotal_magnetization()+infoSecondReagent.getTotal_magnetization()),
                        Sigmoid(infoFirstReagent.getVolume()+infoSecondReagent.getVolume())
                    }, getForLastLayer(t[3]));
         
                }
            }            
                
        });     
        
        String info = "";

        for (Map.Entry<Double[], Double> entry : resultMap.entrySet()) {
            info += Arrays.toString(entry.getKey()) + " --- > " + entry.getValue() + "\n";
        }

        return "<pre>"+info+"</pre>";
        
    }

    public double Sigmoid(double x)
    {
        return 1/(Math.exp(-x)+1);
    }

    public double getForLastLayer(String str)
    {
        double percent = Double.parseDouble(str);
        if (percent <= 10.0d)
        {
            return 1.0d;
        } else if (percent > 10.0d && percent <= 40.0d)
        {
            return 2.0d;
        }
        else if (percent > 40.0d && percent <= 80.0d)
        {
            return 3.0d;
        } 
        else 
        {
            return 4.0d;
        }
    }

}

/*
@GetMapping(path = "/materials/{form}")
ResponseEntity<String> getMaterial(@PathVariable String form) throws URISyntaxException {
    URI location = new URI("/materials");
    HttpHeaders responseHeaders = new HttpHeaders();
    responseHeaders.setLocation(location);
    responseHeaders.set("MyResponseHeader", "MyValue");
    return new ResponseEntity<String>(
        String.valueOf(materialsClient.getMaterial(form).getBody().response.stream().findFirst().map(t -> t.getEnergy()).orElse(0.0)),
        responseHeaders, HttpStatus.OK);      
}*/
