package com.ProyectoWeb.controller;

import com.ProyectoWeb.domain.Auto;
import com.ProyectoWeb.service.AutoService;
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
@RequestMapping("/auto")
public class AutoController {
   
    @Autowired
    private AutoService autoService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var autos = autoService.getAutos(false);
        model.addAttribute("autos", autos);
        model.addAttribute("totalAutos", autos.size());
        return "/auto/listado";
    }
    
    @GetMapping("/nuevo")
    public String autoNuevo (Auto auto) {
        return "/auto/modifica";
    }
    
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    @PostMapping("/guardar")
    public String autoGuardar (Auto auto,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            autoService.save(auto);
            auto.setImagen(
            firebaseStorageService.cargaImagen(
                    imagenFile,
                    "auto",
                    auto.getIdAuto()));
        }
        autoService.save(auto);
        return "redirect:/auto/listado";
    }
    
    @GetMapping("/eliminar/{idAuto}")
    public String autoEliminar(Auto auto) {
        autoService.delete(auto);
        return "redirect:/auto/listado";
    }
    
    @GetMapping ("/modificar/{idAuto}")
    public String autoModificar(Auto auto, Model model) {
        auto = autoService.getAuto(auto);
        model.addAttribute("auto", auto);
        return "/auto/modifica";
    }
}
