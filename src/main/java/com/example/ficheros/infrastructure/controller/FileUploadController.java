package com.example.ficheros.infrastructure.controller;

import com.example.ficheros.application.port.StorageService;
import com.example.ficheros.domain.Fichero;
import com.example.ficheros.infrastructure.dto.output.FicheroOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

@RestController
@RequestMapping("/ficheros")
public class FileUploadController {

    @Autowired
    StorageService storageService;




    @GetMapping("/setPath/{var}")
    public ResponseEntity<Resource> getFile(@PathVariable String var, @RequestParam("path") String directorioAGuardar) throws IOException {

        Resource resource = storageService.load(var, directorioAGuardar);
        return ResponseEntity.ok().body(resource);
    }

    @PostMapping(value = "/upload", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<FicheroOutputDTO> uploadFiles(@RequestParam("file") MultipartFile file, @RequestParam("categoria") String categoria,
                                                        @RequestParam("nombre") String nombre, @RequestParam("fechaSubida") Date fechaSubida,
                                                        @RequestParam("id") Integer id) {
        try {
            Fichero fichero = storageService.guardar(file, categoria, nombre, fechaSubida, id);
            FicheroOutputDTO ficheroOutputDTO = new FicheroOutputDTO(fichero);
            return ResponseEntity.ok().body(ficheroOutputDTO);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
