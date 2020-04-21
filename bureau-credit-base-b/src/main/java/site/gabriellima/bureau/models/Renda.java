package site.gabriellima.bureau.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import site.gabriellima.bureau.models.enums.TipoRenda;

@Accessors(chain = true)
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Renda {

    private TipoRenda tipo;
    private Double rendimento;
    private String descricao;
}