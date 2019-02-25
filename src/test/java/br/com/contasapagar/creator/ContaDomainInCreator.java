package br.com.contasapagar.creator;

import br.com.contasapagar.domain.in.ContaDomainIn;
import br.com.contasapagar.entity.Conta;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ContaDomainInCreator {

    public ContaDomainIn contaDomainInCreate() {
        return ContaDomainIn.builder()
                .nome("Teste")
                .valorOriginal(100.0)
                .dataVencimento(LocalDate.now())
                .dataPagamento(LocalDate.now())
                .build();
    }

    public ContaDomainIn contaDomainInCreateAte3DiasDeAtraso() {
        return ContaDomainIn.builder()
                .nome("Teste")
                .valorOriginal(100.0)
                .dataVencimento(LocalDate.parse("2019-02-24"))
                .dataPagamento(LocalDate.parse("2019-02-27"))
                .build();
    }

    public ContaDomainIn contaDomainInCreateSuperiorA3DiasDeAtraso() {
        return ContaDomainIn.builder()
                .nome("Teste")
                .valorOriginal(100.0)
                .dataVencimento(LocalDate.parse("2019-02-24"))
                .dataPagamento(LocalDate.parse("2019-03-01"))
                .build();
    }

    public ContaDomainIn contaDomainInCreateSuperiorA5DiasDeAtraso() {
        return ContaDomainIn.builder()
                .nome("Teste")
                .valorOriginal(100.0)
                .dataVencimento(LocalDate.parse("2019-02-24"))
                .dataPagamento(LocalDate.parse("2019-03-02"))
                .build();
    }
}
