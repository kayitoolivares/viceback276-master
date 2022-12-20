package com.leoolivares.viceback276.entity;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "factura")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Factura {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;

    @Column(name = "id_cliente")
    private Long idcliente;
    @Column(name = "id_usuario")
    private Long idusuario;


    @Column(name="estatus")
    private String estatus;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSZ")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSZ")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha")
    private Date fecha;

    //Relaciones
    @ManyToOne
    @JoinColumn(name = "id_cliente", updatable = false,insertable = false)
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "id_usuario", updatable = false,insertable = false)
    private Usuario usuario;

}
