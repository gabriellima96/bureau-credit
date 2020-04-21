package site.gabriellima.bureau.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
    private String complemento;
    private String cep;
    private String numero;

}