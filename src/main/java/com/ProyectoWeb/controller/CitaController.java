package com.ProyectoWeb.controller;

import com.ProyectoWeb.domain.Cita;
import com.ProyectoWeb.service.CitaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/cita")
public class CitaController {
   
    @Autowired
    private CitaService citaService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var citas = citaService.getCitas(false);
        model.addAttribute("citas", citas);
        model.addAttribute("totalCitas", citas.size());
        return "/cita/listado";
    }
    
    @GetMapping("/nuevo")
    public String citaNuevo (Cita cita) {
        return "/cita/modifica";
    }
       
    @PostMapping("/guardar")
    public String citaGuardar(Cita cita) {
    citaService.save(cita);
    return "redirect:/cita/listado";
    }
    
    @GetMapping("/eliminar/{idCita}")
    public String citaEliminar(Cita cita) {
        citaService.delete(cita);
        return "redirect:/cita/listado";
    }
    
    @GetMapping ("/modificar/{idCita}")
    public String citaModificar(Cita cita, Model model) {
        cita = citaService.getCita(cita);
        model.addAttribute("cita", cita);
        return "/cita/modifica";
    }
}
