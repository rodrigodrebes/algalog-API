package com.techsolutions.api.Controller;

import java.util.List;
import java.util.Optional;

import com.techsolutions.domain.Model.Cliente;
import com.techsolutions.domain.repository.ClienteRepository;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> listar() {
        return clienteRepository.findAll();

    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId) {
        return clienteRepository.findById(clienteId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionar(@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @PutMapping("/{clienteId}")
    @ResponseStatus
    public ResponseEntity<Cliente> atualizar(@PathVariable Long clienteId, @RequestBody Cliente cliente){
        if (!clienteRepository.existsById(clienteId)){
            return ResponseEntity.notFound().build();
        }
        cliente.setId(clienteId);
        cliente=clienteRepository.save(cliente);
        return ResponseEntity.ok(cliente);
    }
    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> remover(@PathVariable Long clienteId){
        if (!clienteRepository.existsById(clienteId)){
            return ResponseEntity.notFound().build();
        }
        clienteRepository.deleteById(clienteId);
        return ResponseEntity.noContent().build();
    }
}
