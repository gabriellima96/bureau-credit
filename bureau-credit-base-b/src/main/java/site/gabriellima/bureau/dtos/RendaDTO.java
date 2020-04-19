package site.gabriellima.bureau.dtos;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import site.gabriellima.bureau.models.Renda;
import site.gabriellima.bureau.models.enums.TipoRenda;

@AllArgsConstructor
@Getter
public class RendaDTO {

    @NotNull
    private TipoRenda tipo;
    @NotNull
    private Double rendimento;
    @NotNull
    private String descricao;

    public Renda getRenda() {
        return new Renda(tipo, rendimento, descricao);
    }
}