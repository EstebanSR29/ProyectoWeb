package com.ProyectoWeb.controller;

import com.ProyectoWeb.domain.Comentario;
import com.ProyectoWeb.service.ComentarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/comentario")
public class ComentarioController {
   
    @Autowired
    private ComentarioService comentarioService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var comentarios = comentarioService.getComentarios(false);
        model.addAttribute("comentarios", comentarios);
        model.addAttribute("totalComentarios", comentarios.size());
        return "/comentario/listado";
    }
    
    @GetMapping("/nuevo")
    public String comentarioNuevo (Comentario comentario) {
        return "/comentario/modifica";
    }
    
    @PostMapping("/guardar")
    public String comentarioGuardar(Comentario comentario) {
    comentarioService.save(comentario);
    return "redirect:/comentario/listado";
    }
    
    @GetMapping("/eliminar/{idComentario}")
    public String comentarioEliminar(Comentario comentario) {
        comentarioService.delete(comentario);
        return "redirect:/comentario/listado";
    }
    
    @GetMapping ("/modificar/{idComentario}")
    public String comentarioModificar(Comentario comentario, Model model) {
        comentario = comentarioService.getComentario(comentario);
        model.addAttribute("comentario", comentario);
        return "/comentario/modifica";
    }
}
