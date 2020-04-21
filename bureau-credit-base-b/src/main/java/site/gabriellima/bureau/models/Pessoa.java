package site.gabriellima.bureau.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Max;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document
public class Pessoa {

    @JsonIgnore
    @Id
    @EqualsAndHashCode.Include
    private String id;

    @EqualsAndHashCode.Include
    private Long pessoaId;

    @Max(9)
    private String cpf;
    private LocalDate dataNascimento;
    private Endereco endereco;

    @DBRef(lazy = true)
    private List<Ben> bens = new ArrayList<>();

    private Renda renda;

    public void adicionarBen(Ben ben) {
        bens.add(ben);
    }
}