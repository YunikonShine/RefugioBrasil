package br.com.yunikonshine.refugiobrasil.model.request;

import br.com.yunikonshine.refugiobrasil.model.enumerable.DocumentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DocumentRequest {

    @NotEmpty
    private String number;

    @NotNull
    private DocumentType type;

}
