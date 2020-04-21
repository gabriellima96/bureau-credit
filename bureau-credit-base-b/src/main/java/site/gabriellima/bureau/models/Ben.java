package site.gabriellima.bureau.models;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import site.gabriellima.bureau.models.enums.TipoClassificacao;

@Accessors(chain = true)
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document
public class Ben {

    @EqualsAndHashCode.Include
    @Id
    private String id;

    @NotNull
    private String descricao;
    @NotNull
    private TipoClassificacao classificacao;

    @JsonIgnore
    private String pessoaId;

    private Double valor;

}