package com.techsolutions.api.Controller;
import java.util.Arrays;
import java.util.List;
import com.techsolutions.domain.Model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
    @GetMapping("/clientes")
    public List<Cliente> listar(){
        var cliente1 = new Cliente();
        cliente1.setId(1L);
        cliente1.setNome("João");
        cliente1.setTelefone("51 99999-99999");
        cliente1.setEmail("joao@gmail.com");

        var cliente2 = new Cliente();
        cliente2.setId(2L);
        cliente2.setNome("Pedro");
        cliente2.setTelefone("51 88888-99999");
        cliente2.setEmail("pedro@gmail.com");

        return Arrays.asList(cliente1,cliente2);
    }
}
