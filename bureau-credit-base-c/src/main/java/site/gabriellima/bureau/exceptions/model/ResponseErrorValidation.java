package site.gabriellima.bureau.exceptions.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class ResponseErrorValidation extends ResponseError {

    private List<CampoErro> campos = new ArrayList<>();

    public ResponseErrorValidation(String error, String message) {
        super(error, message);
    }

    public void adicionarCampo(String campo, String erro) {
        campos.add(new CampoErro(campo, erro));
    }
}