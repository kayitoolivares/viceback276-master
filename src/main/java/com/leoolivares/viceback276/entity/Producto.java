package com.leoolivares.viceback276.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "producto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Producto {
   /*    id int auto_increment primary key,
    nombbre varchar(100),
    cantidad float,
    precio float*/

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;

    @Column(name="nombbre")
    private String nombre;

    @Column(name="cantidad")
    private float cantidad;

    @Column(name="precio")
    private float precio;

    @Column(name="estatus")
    private Boolean estatus;
}
