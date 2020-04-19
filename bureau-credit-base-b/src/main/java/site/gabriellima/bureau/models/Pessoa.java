package site.gabriellima.bureau.models;

import java.time.LocalDate;

import javax.validation.constraints.Max;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document
public class Pessoa {

    @Id
    @EqualsAndHashCode.Include
    private String id;

    @EqualsAndHashCode.Include
    @Indexed(unique = true)
    private Long pessoaId;

    @Max(9)
    @Indexed(unique = true)
    private String cpf;
    private LocalDate dataNascimento;
    private Endereco endereco;
}