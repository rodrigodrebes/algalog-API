package com.techsolutions.domain.service;

import com.techsolutions.domain.Model.Cliente;
import com.techsolutions.domain.Model.Entrega;
import com.techsolutions.domain.Model.StatusEntrega;
import com.techsolutions.domain.exception.NegocioException;
import com.techsolutions.domain.repository.ClienteRepository;
import com.techsolutions.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {

private CatalogoClienteService catalogoClienteService;
    private EntregaRepository entregaRepository;

    @Transactional
    public Entrega solicitar(Entrega entrega){
        Cliente cliente = catalogoClienteService.buscar(entrega.getCliente().getId());

        entrega.setCliente(cliente);
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(LocalDateTime.now());
        return entregaRepository.save(entrega);

    }
}