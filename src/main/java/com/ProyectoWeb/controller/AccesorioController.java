package com.ProyectoWeb.controller;

import com.ProyectoWeb.domain.Accesorio;
import com.ProyectoWeb.service.AccesorioService;
import com.ProyectoWeb.service.impl.FirebaseStorageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Slf4j
@RequestMapping("/accesorio")
public class AccesorioController {
   
    @Autowired
    private AccesorioService accesorioService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var accesorios = accesorioService.getAccesorios(false);
        model.addAttribute("accesorios", accesorios);
        model.addAttribute("totalAccesorios", accesorios.size());
        return "/accesorio/listado";
    }
    
    @GetMapping("/nuevo")
    public String accesorioNuevo (Accesorio accesorio) {
        return "/accesorio/modifica";
    }
    
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    @PostMapping("/guardar")
    public String accesorioGuardar (Accesorio accesorio,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            accesorioService.save(accesorio);
            accesorio.setImagen(
            firebaseStorageService.cargaImagen(
                    imagenFile,
                    "accesorio",
                    accesorio.getIdAccesorio()));
        }
        accesorioService.save(accesorio);
        return "redirect:/accesorio/listado";
    }
    
    @GetMapping("/eliminar/{idAccesorio}")
    public String accesorioEliminar(Accesorio accesorio) {
        accesorioService.delete(accesorio);
        return "redirect:/accesorio/listado";
    }
    
    @GetMapping ("/modificar/{idAccesorio}")
    public String accesorioModificar(Accesorio accesorio, Model model) {
        accesorio = accesorioService.getAccesorio(accesorio);
        model.addAttribute("accesorio", accesorio);
        return "/accesorio/modifica";
    }
}