package com.example.BS9.application.port;

import com.example.BS9.infrastructure.dto.output.ProfesorOutputDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "simpleFeign", url = "http://localhost:8081/")
public interface IFeignServer {

    @GetMapping("profesor/id/{id}")
    ResponseEntity<ProfesorOutputDTO> callServer(@PathVariable("id") int id);
}
