package com.ProyectoWeb.service.impl;

import com.ProyectoWeb.dao.AccesorioDao;
import com.ProyectoWeb.dao.CarritoDao;
import com.ProyectoWeb.domain.Accesorio;
import com.ProyectoWeb.domain.Carrito;
import com.ProyectoWeb.domain.Factura2;
import com.ProyectoWeb.domain.Item;
import com.ProyectoWeb.domain.Usuario;
import com.ProyectoWeb.service.ItemService;
import com.ProyectoWeb.service.UsuarioService;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import com.ProyectoWeb.dao.Factura2Dao;

@Service
public class ItemServiceImpl implements ItemService {

    @Override
    public List<Item> gets() {
        return listaItems;
    }

    @Override
    public void save(Item item) {
        boolean existe = false;
        for (Item i : listaItems) {
            if (Objects.equals(i.getIdAccesorio(), item.getIdAccesorio())) {
                if (i.getCantidad() < 100) {
                    i.setCantidad(i.getCantidad() + 1);
                }
                existe = true;
                break;
            }
        }
        if (!existe) {            
            item.setCantidad(1);
            listaItems.add(item);
        }
    }

    @Override
    public void delete(Item item) {
        var posicion = -1;
        var existe = false;
        for (Item i : listaItems) {
            ++posicion;
            if (Objects.equals(i.getIdAccesorio(), item.getIdAccesorio())) {
                existe = true;
                break;
            }
        }
        if (existe) {
            listaItems.remove(posicion);
        }
    }

    @Override
    public Item get(Item item) {
        for (Item i : listaItems) {
            if (Objects.equals(i.getIdAccesorio(), item.getIdAccesorio())) {
                return i;
            }
        }
        return null;
    }

    @Override
    public void actualiza(Item item) {
        for (Item i : listaItems) {
            if (Objects.equals(i.getIdAccesorio(), item.getIdAccesorio())) {
                i.setCantidad(item.getCantidad());
                break;
            }
        }
    }

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private Factura2Dao facturaDao;
    @Autowired
    private CarritoDao carritoDao;
    @Autowired
    private AccesorioDao accesorioDao;

    @Override
    public void facturar() {
        System.out.println("Facturando");

        
        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails userDetails) {
            username = userDetails.getUsername();
        } else {
            username = principal.toString();
        }

        if (username.isBlank()) {
            return;
        }

        Usuario usuario = usuarioService.getUsuarioPorUsername(username);

        if (usuario == null) {
            return;
        }

        Factura2 factura2 = new Factura2();
        factura2 = facturaDao.save(factura2);

        double total = 0;
        for (Item i : listaItems) {
            System.out.println("Accesorio: " + i.getNombre()
                    + " Cantidad: " + i.getCantidad()
                    + " Total: " + i.getPrecio() * i.getCantidad());
            Carrito carrito = new Carrito(factura2.getIdFactura(), i.getIdAccesorio(), i.getPrecio(), i.getCantidad());
            carritoDao.save(carrito);
            Accesorio accesorio = accesorioDao.getReferenceById(i.getIdAccesorio());
            accesorioDao.save(accesorio);
            total += i.getPrecio() * i.getCantidad();
        }
        factura2.setTotal(total);
        facturaDao.save(factura2);
        listaItems.clear();
    }
}