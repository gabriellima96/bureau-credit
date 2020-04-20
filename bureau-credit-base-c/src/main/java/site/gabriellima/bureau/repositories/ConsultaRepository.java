package site.gabriellima.bureau.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import site.gabriellima.bureau.models.Consulta;

public interface ConsultaRepository extends CrudRepository<Consulta, Long> {

    List<Consulta> findAllByCpf(String cpf);
}