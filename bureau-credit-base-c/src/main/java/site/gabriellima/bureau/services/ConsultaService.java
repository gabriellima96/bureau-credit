package site.gabriellima.bureau.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import site.gabriellima.bureau.models.Consulta;
import site.gabriellima.bureau.repositories.ConsultaRepository;

@Service
@Slf4j
public class ConsultaService {

    private final ConsultaRepository consultaRepository;

    @Autowired
    public ConsultaService(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    public Consulta salvar(Consulta consulta) {
        log.info("Salvando a consulta: '{}'", consulta);
        consulta.setDataConsulta(LocalDate.now());
        return consultaRepository.save(consulta);
    }

    public Iterable<Consulta> buscarTudo() {
        log.info("Buscando todas as consultas");
        return consultaRepository.findAll();
    }

    public Iterable<Consulta> buscarPorCpf(String cpf) {
        log.info("Buscando consultas do cpf '{}'", cpf);
        return consultaRepository.findAllByCpf(cpf);
    }
}