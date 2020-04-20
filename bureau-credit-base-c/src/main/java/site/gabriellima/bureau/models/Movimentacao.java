package site.gabriellima.bureau.models;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import lombok.AllArgsConstructor;
import lombok.Data;
import site.gabriellima.bureau.models.enums.TipoOperacao;
import site.gabriellima.bureau.models.enums.TipoPagamento;

@AllArgsConstructor
@Data
@RedisHash
public class Movimentacao {

    @Id
    @Indexed
    private Long id;
    @JsonIgnore
    @Indexed
    private String cpf;
    @NotNull
    private Double valor;
    @NotNull
    private String descricao;
    @NotNull
    private TipoPagamento pagamento;
    @NotNull
    private TipoOperacao operacao;
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dataMovimentacao;
}