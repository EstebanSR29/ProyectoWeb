package com.ProyectoWeb.service.impl;

import com.ProyectoWeb.dao.FacturaDao;
import com.ProyectoWeb.domain.Factura;
import com.ProyectoWeb.service.FacturaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FacturaServiceImpl implements FacturaService {
    
    @Autowired
    private FacturaDao facturaDao;
    
    @Override
    @Transactional (readOnly = true)
    public List<Factura> getFacturas(boolean activos) {
        var lista = facturaDao.findAll();
        if(activos){
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;        
    }
    
    @Override
    @Transactional(readOnly = true)
    public Factura getFactura (Factura factura) {
        return facturaDao.findById(factura.getIdFactura()).orElse(null);
    }
    
    @Override
    @Transactional
    public void save(Factura factura) {
        facturaDao.save(factura);
    }

    @Override
    @Transactional
    public void delete(Factura factura) {
        facturaDao.delete(factura);
    }
}