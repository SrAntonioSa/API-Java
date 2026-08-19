package com.baozistore.baozi_store.controller;

import com.baozistore.baozi_store.model.Pedido;
import com.baozistore.baozi_store.repository.PedidoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoRepository pedidoRepository;

    public PedidoController(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @PostMapping
    public Pedido criar(@RequestBody Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @GetMapping
    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Pedido buscarPorId(@PathVariable Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        pedidoRepository.deleteById(id);
    }
}