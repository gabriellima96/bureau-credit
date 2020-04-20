package site.gabriellima.bureau.exceptions.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CampoErro {

    private String campo;
    private String erro;
}