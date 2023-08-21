package com.ProyectoWeb.service.impl;

import com.ProyectoWeb.dao.ComentarioDao;
import com.ProyectoWeb.domain.Comentario;
import com.ProyectoWeb.service.ComentarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ComentarioServiceImpl implements ComentarioService {
    
    @Autowired
    private ComentarioDao comentarioDao;
    
    @Override
    @Transactional (readOnly = true)
    public List<Comentario> getComentarios(boolean activos) {
        var lista = comentarioDao.findAll();
        if(activos){
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;        
    }
    
    @Override
    @Transactional(readOnly = true)
    public Comentario getComentario (Comentario comentario) {
        return comentarioDao.findById(comentario.getIdComentario()).orElse(null);
    }
    
    @Override
    @Transactional
    public void save(Comentario comentario) {
        comentarioDao.save(comentario);
    }

    @Override
    @Transactional
    public void delete(Comentario comentario) {
        comentarioDao.delete(comentario);
    }
}