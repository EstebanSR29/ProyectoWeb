package com.ProyectoWeb.service.impl;

import com.ProyectoWeb.dao.VentaDao;
import com.ProyectoWeb.domain.Venta;
import com.ProyectoWeb.service.VentaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VentaServiceImpl implements VentaService {
    
    @Autowired
    private VentaDao ventaDao;
    
    @Override
    @Transactional (readOnly = true)
    public List<Venta> getVentas(boolean activos) {
        var lista = ventaDao.findAll();
        if(activos){
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;        
    }
    
    @Override
    @Transactional(readOnly = true)
    public Venta getVenta (Venta venta) {
        return ventaDao.findById(venta.getIdVenta()).orElse(null);
    }
    
    @Override
    @Transactional
    public void save(Venta venta) {
        ventaDao.save(venta);
    }

    @Override
    @Transactional
    public void delete(Venta venta) {
        ventaDao.delete(venta);
    }
}
