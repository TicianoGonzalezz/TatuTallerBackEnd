package com.example.tatu.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tatu.entidades.Pedido;
import com.example.tatu.repositorios.PedidoRepositorio;

@Service
public class PedidoServicio {

    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    @Transactional
    public void crearPedido(Pedido pedido) {
        pedidoRepositorio.save(pedido);
    }

    @Transactional(readOnly = true)
    public List<Pedido> listarPedidos() {
        return pedidoRepositorio.findAll();
    }

    @Transactional
    public void modificarPedido(Long id, Pedido datosActualizados) {
        Optional<Pedido> respuesta = pedidoRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Pedido pedido = respuesta.get();
            // Actualiza los campos necesarios aquí, por ejemplo:
            pedido.setFecha(datosActualizados.getFecha());
            pedido.setUsuario(datosActualizados.getUsuario());
            pedido.setEstado(datosActualizados.getEstado());
            // Agrega más campos según tu entidad Pedido
            pedidoRepositorio.save(pedido);
        }
    }

    public Pedido buscarPorId(Long id) {
        return pedidoRepositorio.findById(id).orElse(null);
    }
}
