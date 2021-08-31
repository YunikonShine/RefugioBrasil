package br.com.yunikonshine.refugiobrasil.controller;

import br.com.yunikonshine.refugiobrasil.exception.CepNotFoundException;
import br.com.yunikonshine.refugiobrasil.exception.DocumentAlreadyExistsException;
import br.com.yunikonshine.refugiobrasil.exception.DocumentNotValidException;
import br.com.yunikonshine.refugiobrasil.exception.generic.GenericNotFoundException;
import br.com.yunikonshine.refugiobrasil.model.request.RefugeeBaseRequest;
import br.com.yunikonshine.refugiobrasil.model.request.RefugeeRequest;
import br.com.yunikonshine.refugiobrasil.model.response.RefugeeResponse;
import br.com.yunikonshine.refugiobrasil.model.response.RefugeeSimpleResponse;
import br.com.yunikonshine.refugiobrasil.service.RefugeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/refugee")
@RequiredArgsConstructor
public class RefugeeController {

    private final RefugeeService refugeeService;

    @PostMapping
    public ResponseEntity saveRefugee(@RequestBody @Valid RefugeeRequest refugeeRequest) throws DocumentAlreadyExistsException, DocumentNotValidException, CepNotFoundException {
        refugeeService.saveRefugee(refugeeRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{refugeeId}")
    public RefugeeResponse findById(@PathVariable String refugeeId) throws GenericNotFoundException {
        return refugeeService.findById(refugeeId);
    }

    @GetMapping
    public List<RefugeeSimpleResponse> getAllRefugees() throws CepNotFoundException {
        return refugeeService.getAllRefugees();
    }

    @PutMapping("/{refugeeId}")
    public ResponseEntity updateRefugee(@PathVariable String refugeeId, @RequestBody @Valid RefugeeBaseRequest refugeeRequest) throws GenericNotFoundException {
        refugeeService.update(refugeeId, refugeeRequest);
        return ResponseEntity.ok().build();
    }

}
