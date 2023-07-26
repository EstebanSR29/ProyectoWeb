package com.ProyectoWeb.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FirebaseStorageService {

    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

    final String BucketName = "proyectoweb-965fa.appspot.com";

    final String rutaSuperiorStorage = "proyectoweb";

    final String rutaJsonFile = "firebase";

    final String archivoJsonFile = "proyectoweb-965fa-firebase-adminsdk-lswa2-b46f90a990.json";

}