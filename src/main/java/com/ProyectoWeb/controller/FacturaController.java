package com.ProyectoWeb.controller;

import com.ProyectoWeb.domain.Factura;
import com.ProyectoWeb.service.FacturaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/factura")
public class FacturaController {
   
    @Autowired
    private FacturaService facturaService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var facturas = facturaService.getFacturas(false);
        model.addAttribute("facturas", facturas);
        model.addAttribute("totalFacturas", facturas.size());
        return "/factura/listado";
    }
    
    @GetMapping("/nuevo")
    public String facturaNuevo (Factura factura) {
        return "/factura/modifica";
    }
       
    @PostMapping("/guardar")
    public String facturaGuardar(Factura factura) {
    facturaService.save(factura);
    return "redirect:/factura/listado";
    }
    
    @GetMapping("/eliminar/{idFactura}")
    public String facturaEliminar(Factura factura) {
        facturaService.delete(factura);
        return "redirect:/factura/listado";
    }
    
    @GetMapping ("/modificar/{idFactura}")
    public String facturaModificar(Factura factura, Model model) {
        factura = facturaService.getFactura(factura);
        model.addAttribute("factura", factura);
        return "/factura/modifica";
    }
}
