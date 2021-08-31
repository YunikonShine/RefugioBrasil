package br.com.yunikonshine.refugiobrasil.model.response;

import br.com.yunikonshine.refugiobrasil.model.enumerable.DocumentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DocumentResponse {

    private String id;

    private String number;

    private DocumentType type;

}
