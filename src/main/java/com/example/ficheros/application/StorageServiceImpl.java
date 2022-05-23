package com.example.ficheros.application;

import com.example.ficheros.application.port.StorageService;
import com.example.ficheros.domain.Fichero;
import com.example.ficheros.infrastructure.dto.input.FicheroInputDTO;
import com.example.ficheros.infrastructure.repository.FicheroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    FicheroRepository ficheroRepository;

    @Value("${direccionAGuardar}")
    String direccionAGuardar;

    private Path upload_folder = Paths.get("C://Users//gabriel.reca//IdeaProjects//ficheros//src//main//resources//static//");

    @Override
    public Fichero guardar(MultipartFile file, String categoria, String  nombre, Date fechaSubida, Integer id) throws IOException {
        Files.copy(file.getInputStream(), this.upload_folder.resolve(file.getOriginalFilename()));
        FicheroInputDTO ficheroInputDTO = new FicheroInputDTO(id, categoria, nombre, fechaSubida);
        Fichero fichero = new Fichero(ficheroInputDTO);
        System.out.println(fichero.toString());
        ficheroRepository.save(fichero);
        return fichero;
    }

    @Override
    public Resource load(String name, String direccionAAlmacenar) throws RuntimeException, IOException {
        if(direccionAGuardar.equals(null)) {
            Path pathDireccionAGuardar = Paths.get(direccionAAlmacenar);
            Path file = upload_folder.resolve(name);
            Resource resource = new UrlResource(file.toUri());
            Files.copy(resource.getInputStream(), pathDireccionAGuardar.resolve(resource.getFilename()));
            return resource;
        }else {
            Path pathDireccionAGuardar = Paths.get(direccionAGuardar);
            Path file = upload_folder.resolve(name);
            Resource resource = new UrlResource(file.toUri());
            Files.copy(resource.getInputStream(), pathDireccionAGuardar.resolve(resource.getFilename()));
            return resource;
        }
    }
}
