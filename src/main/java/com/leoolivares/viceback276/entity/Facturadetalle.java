package com.leoolivares.viceback276.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "facturadetalle")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Facturadetalle {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;


    @Column(name = "id_factura")
    private Long idfactura;
    @Column(name = "id_producto")
    private Long idproducto;
    @Column(name = "cantidad")
    private float cantidad;
    @Column(name = "precio")
    private float precio;


    //Relaciones

    @ManyToOne
    @JoinColumn(name = "id_factura", updatable = false,insertable = false)
    private Factura factura;
    @ManyToOne
    @JoinColumn(name = "id_producto", updatable = false,insertable = false)
    private Producto producto;

}
