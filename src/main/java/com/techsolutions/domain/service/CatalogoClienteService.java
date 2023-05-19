package com.techsolutions.domain.service;
import com.techsolutions.domain.Model.Cliente;
import com.techsolutions.domain.exception.NegocioException;
import com.techsolutions.domain.repository.ClienteRepository;
import com.techsolutions.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// regras de negócio
@AllArgsConstructor
@Service
public class CatalogoClienteService {
    private ClienteRepository clienteRepository;
    public Cliente buscar(Long clienteId){
        return clienteRepository.findById(clienteId)
                .orElseThrow(()-> new NegocioException("Cliente não encontrado"));


    }

    @Transactional
    public Cliente salvar(Cliente cliente){

       boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
               .stream()
               .anyMatch(clienteExistente -> !clienteExistente.equals(cliente));

       if(emailEmUso){
           throw new RuntimeException("Já existe um cliente cadastrado com esse e-mail.");
       }

        return clienteRepository.save(cliente);
    }

    @Transactional
    public void excluir(Long clienteId){
        clienteRepository.deleteById(clienteId);
    }

}
