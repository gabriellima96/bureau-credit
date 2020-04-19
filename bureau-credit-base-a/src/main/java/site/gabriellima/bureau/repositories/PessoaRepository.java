package site.gabriellima.bureau.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import site.gabriellima.bureau.models.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
