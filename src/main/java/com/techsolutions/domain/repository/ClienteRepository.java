// repository isola a lógica de acesso a dados do resto da aplicação, gerenciando as entidades

package com.techsolutions.domain.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.techsolutions.domain.Model.Cliente;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long>{

    List<Cliente> findByNome(String nome);
    List<Cliente> findByNomeContaining(String nome);

}
