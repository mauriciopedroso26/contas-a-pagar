package br.com.contasapagar.creator;

import br.com.contasapagar.entity.Conta;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ContaCreator {

    public Conta contaCreate() {
        return Conta.builder()
                .nome("Teste")
                .valorOriginal(100.0)
                .dataVencimento(LocalDate.now())
                .dataPagamento(LocalDate.now())
                .build();
    }
}
