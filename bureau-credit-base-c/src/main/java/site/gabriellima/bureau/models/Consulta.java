package site.gabriellima.bureau.models;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@RedisHash
public class Consulta {

    @Id
    private Long id;
    @NotBlank
    private String descricao;
    @Indexed
    @NotBlank
    private String cpf;
    @Indexed
    @NotBlank
    private String bureau;
    private LocalDate dataConsulta;
}