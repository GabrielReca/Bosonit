package com.example.ficheros.application.port;

import com.example.ficheros.domain.Fichero;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

public interface StorageService {

    Fichero guardar(MultipartFile file, String categoria, String nombre, Date fechaSubida, Integer id) throws IOException;

    public Resource load(String name, String directorioAGuardar) throws RuntimeException, IOException;

}
