package com.ProyectoWeb.service;

import com.ProyectoWeb.domain.Usuario;
import java.util.List;

public interface UsuarioService {
        
    public List<Usuario> getUsuarios();
    
    public Usuario getUsuario(Usuario usuario);
    
    public Usuario getUsuarioPorUsername(String username);

    public Usuario getUsuarioPorUsernameYPassword(String username, String password);
    
    public void save(Usuario usuario,boolean crearRolUser);
    
    public void delete(Usuario usuario);
    
}