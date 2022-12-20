package com.leoolivares.viceback276.service.Implementation;

import com.leoolivares.viceback276.entity.Factura;
import com.leoolivares.viceback276.entity.Facturadetalle;
import com.leoolivares.viceback276.entity.Producto;
import com.leoolivares.viceback276.repository.IFacturaRepository;
import com.leoolivares.viceback276.repository.IFacturadetalleRepository;
import com.leoolivares.viceback276.repository.IProductoRepository;
import com.leoolivares.viceback276.service.IFacturaService;
import com.leoolivares.viceback276.service.IFacturadetalleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FacturadetalleImplementation implements IFacturadetalleService {
    @Autowired
    IFacturadetalleRepository repository;

    //@Autowired
    //IFacturaService iFacturaService;
    @Autowired
    IFacturaRepository iFacturaRepository;

    @Autowired
    IProductoRepository iProductoRepository;

    @Override
    public List<Facturadetalle> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Facturadetalle> getAllByIdFactura(Long aLong) {
        return repository.findAllByIdfactura(aLong);
    }

    @Override
    public Optional<Facturadetalle> getById(Long aLong) {
        return repository.findById(aLong);
    }

    @Override
    public Facturadetalle save(Facturadetalle facturadetalle) {
        Producto producto=iProductoRepository.findById(facturadetalle.getIdproducto()).get();
        facturadetalle.setPrecio(producto.getPrecio());
        try {
            facturadetalle=repository.save(facturadetalle);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return facturadetalle;
    }

    @Override
    public Boolean delete(Long aLong) {
        Optional<Facturadetalle> facturadetalle=repository.findById(aLong);
        if (facturadetalle.isPresent()){
            Optional<Factura> factura=iFacturaRepository.findById(facturadetalle.get().getIdfactura());
            if (factura.isPresent()){
                if (factura.get().getEstatus().equals("0")){
                    repository.deleteById(aLong);
                    return true;
                }
            }
        }
        return false;
    }
}
