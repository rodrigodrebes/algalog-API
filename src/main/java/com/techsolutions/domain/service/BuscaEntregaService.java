package com.techsolutions.domain.service;

import com.techsolutions.domain.Model.Entrega;
import com.techsolutions.domain.exception.EntidadeNaoEncontradaException;
import com.techsolutions.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BuscaEntregaService {

    private EntregaRepository entregaRepository;
    public Entrega buscar(Long entregaId){
       return entregaRepository.findById(entregaId)
                .orElseThrow(()-> new EntidadeNaoEncontradaException("Entrega não encontrada"));

    }
}
