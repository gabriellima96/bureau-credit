package site.gabriellima.bureau.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Entity
public class Endereco implements Serializable {

    @EqualsAndHashCode.Include
    @Id
    @Column(name = "pessoa_id")
    private Long id;

    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
    private String complemento;
    private String cep;
    private String numero;

    @JsonIgnore
    @OneToOne
    @MapsId
    private Pessoa pessoa;
}
