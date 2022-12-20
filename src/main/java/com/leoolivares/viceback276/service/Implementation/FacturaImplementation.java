package com.leoolivares.viceback276.service.Implementation;

import com.leoolivares.viceback276.entity.Factura;
import com.leoolivares.viceback276.entity.Facturadetalle;
import com.leoolivares.viceback276.entity.Producto;
import com.leoolivares.viceback276.repository.IFacturaRepository;
import com.leoolivares.viceback276.service.IFacturaService;
import com.leoolivares.viceback276.service.IFacturadetalleService;
import com.leoolivares.viceback276.service.IProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class FacturaImplementation implements IFacturaService {
    @Autowired
    IFacturaRepository repository;

    @Autowired
    IFacturadetalleService iFacturadetalleService;

    @Autowired
    IProductoService iProductoService;

    @Override
    public List<Factura> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Factura> getById(Long aLong) {
        return repository.findById(aLong);
    }

    @Override
    public Factura save(Factura factura) {
        factura.setFecha(new Date());
        try {
            factura=repository.save(factura);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        factura=repository.findById(factura.getId()).get();
        return factura;
    }

    @Override
    public Boolean delete(Long aLong) {
        Optional<Factura> factura=getById(aLong);
        if (factura.isPresent()){
            if (factura.get().getEstatus().equals("0")){
                repository.deleteById(aLong);
                return  true;

            }
        }
        return false;
    }

    @Override
    public String Afectar(Long aLong) {
        Optional<Factura> factura=getById(aLong);
        if (factura.isPresent()){
            if (factura.get().getEstatus().equals("0")){
                Factura factura1=factura.get();
                factura1.setEstatus("Afectando");
                repository.save(factura1);
                List<Facturadetalle> facturadetalles=iFacturadetalleService
                        .getAllByIdFactura(aLong);
                for (Facturadetalle item:facturadetalles) {
                    Producto producto=iProductoService.getById(item.getIdproducto()).get();
                    producto.setCantidad(producto.getCantidad()- item.getCantidad());
                    iProductoService.save(producto);
                }
                factura1.setEstatus("Finalizada");
                repository.save(factura1);
                return "Afectada";
            }else{
                return "no Editable";
            }
        }

        return "no Existe";
    }

    @Override
    public List<Factura> getAllByCliente(Long aLong) {
        return repository.findAllByIdcliente(aLong);
    }

    @Override
    public List<Factura> getAllByUsuario(Long aLong) {
        return repository.findAllByIdusuario(aLong);
    }
}
