package site.gabriellima.bureau.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import site.gabriellima.bureau.models.Divida;

public interface DividaRepository extends JpaRepository<Divida, Long> {

    Page<Divida> findAllByPessoa_id(Long pessoaId, Pageable pageable);
}
