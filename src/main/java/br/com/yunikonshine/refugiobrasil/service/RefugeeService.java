package br.com.yunikonshine.refugiobrasil.service;

import br.com.yunikonshine.refugiobrasil.exception.CepNotFoundException;
import br.com.yunikonshine.refugiobrasil.exception.DocumentAlreadyExistsException;
import br.com.yunikonshine.refugiobrasil.exception.DocumentNotValidException;
import br.com.yunikonshine.refugiobrasil.exception.RefugeeNotFoundException;
import br.com.yunikonshine.refugiobrasil.exception.generic.GenericNotFoundException;
import br.com.yunikonshine.refugiobrasil.model.mapper.RefugeeMapper;
import br.com.yunikonshine.refugiobrasil.model.request.DocumentRequest;
import br.com.yunikonshine.refugiobrasil.model.request.RefugeeRequest;
import br.com.yunikonshine.refugiobrasil.model.response.RefugeeResponse;
import br.com.yunikonshine.refugiobrasil.model.response.RefugeeSimpleResponse;
import br.com.yunikonshine.refugiobrasil.repository.RefugeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RefugeeService {

    private final DocumentService documentService;

    private final CepService cepService;

    private final RefugeeRepository refugeeRepository;

    private final RefugeeMapper refugeeMapper;

    public void saveRefugee(RefugeeRequest refugeeRequest) throws DocumentAlreadyExistsException, DocumentNotValidException, CepNotFoundException {
        for (DocumentRequest document : refugeeRequest.getDocuments()) {
            documentService.validDocument(document);
        }

        cepService.getDataByCep(refugeeRequest.getAddress().getCep());

        refugeeRepository.save(refugeeMapper.fromRequest(refugeeRequest));

    }

    public List<RefugeeSimpleResponse> getAllRefugees() throws CepNotFoundException {
        return refugeeRepository.listRefugees().stream()
                .map(refugeeMapper::toRefugeeSimpleResponse).collect(Collectors.toList());
    }

    public RefugeeResponse findById(String id) throws GenericNotFoundException {
        return refugeeMapper.toRefugeeResponse(refugeeRepository.findById(id));
    }
}
