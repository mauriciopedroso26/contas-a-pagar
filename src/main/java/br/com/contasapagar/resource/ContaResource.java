package br.com.contasapagar.resource;

import br.com.contasapagar.domain.in.ContaDomainIn;
import br.com.contasapagar.domain.out.ContaDomainOut;
import br.com.contasapagar.facade.ContaFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/admin/conta")
public class ContaResource {

    private final ContaFacade contaFacade;

    @Autowired
    public ContaResource(ContaFacade contaFacade) {
        this.contaFacade = contaFacade;
    }

    @PostMapping
    public ResponseEntity<ContaDomainOut> save(@Valid @RequestBody ContaDomainIn contaDomainIn) {
        return ResponseEntity.ok(contaFacade.save(contaDomainIn));
    }

    @GetMapping
    public ResponseEntity<List<ContaDomainOut>> findAll() {
        return ResponseEntity.ok(contaFacade.findAll());
    }
}
