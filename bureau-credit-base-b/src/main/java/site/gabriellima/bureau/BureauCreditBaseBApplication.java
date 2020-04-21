package site.gabriellima.bureau;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import lombok.extern.slf4j.Slf4j;
import site.gabriellima.bureau.models.Endereco;
import site.gabriellima.bureau.models.Pessoa;
import site.gabriellima.bureau.models.Renda;
import site.gabriellima.bureau.models.enums.TipoRenda;
import site.gabriellima.bureau.repositories.PessoaRepository;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class BureauCreditBaseBApplication implements CommandLineRunner {

	@Autowired
	private PessoaRepository pessoaRepository;

	public static void main(String[] args) {
		SpringApplication.run(BureauCreditBaseBApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (!pessoaRepository.findByPessoaId(1L).isPresent()) {
			Pessoa pessoa = new Pessoa()
								.setPessoaId(1L)
								.setCpf("66234060956")
								.setDataNascimento(LocalDate.of(16, 9, 9))
								.setEndereco(new Endereco()
													.setLogradouro("904 Cras Street")
													.setBairro("Camaçari")
													.setCep("45310-592")
													.setUf("BA")
													.setLocalidade("Itabuna"))
								.setRenda(new Renda()
											.setDescricao("Tests")
											.setRendimento(2000.00)
											.setTipo(TipoRenda.CLT));

											log.info("pessoa: '{}'", pessoa);
			pessoaRepository.save(pessoa);
		}
	}

}
