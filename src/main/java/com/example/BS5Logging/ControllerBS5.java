package com.example.BS5Logging;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j

@RestController
public class ControllerBS5 {

    @GetMapping("logging")
    public String index() {
        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");

        return "hi";
    }
}
