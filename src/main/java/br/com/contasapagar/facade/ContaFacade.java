package br.com.contasapagar.facade;

import br.com.contasapagar.converter.ContaDomainInToContaConverter;
import br.com.contasapagar.converter.ContaToContaDomainOutConverter;
import br.com.contasapagar.domain.in.ContaDomainIn;
import br.com.contasapagar.domain.out.ContaDomainOut;
import br.com.contasapagar.entity.Conta;
import br.com.contasapagar.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContaFacade {

    private final ContaService contaService;
    private final ContaDomainInToContaConverter contaDomainInToContaConverter;
    private final ContaToContaDomainOutConverter contaToContaDomainOutConverter;

    @Autowired
    public ContaFacade(ContaService contaService, ContaDomainInToContaConverter contaDomainInToContaConverter,
                       ContaToContaDomainOutConverter contaToContaDomainOutConverter) {
        this.contaService = contaService;
        this.contaDomainInToContaConverter = contaDomainInToContaConverter;
        this.contaToContaDomainOutConverter = contaToContaDomainOutConverter;
    }

    public ContaDomainOut save(ContaDomainIn contaDomainIn) {
        Conta conta = contaService.save(contaDomainInToContaConverter.convert(contaDomainIn));
        return contaToContaDomainOutConverter.convert(conta);
    }

    public List<ContaDomainOut> findAll() {
        List<Conta> contaList = contaService.findAll();
        List<ContaDomainOut> contaDomainOutList = new ArrayList<>();

        contaList.forEach(conta -> contaDomainOutList.add(contaToContaDomainOutConverter.convert(conta)));

        return contaDomainOutList;
    }
}
