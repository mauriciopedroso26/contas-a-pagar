package br.com.contasapagar.creator;

import br.com.contasapagar.entity.Conta;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ContaCreator {

    public Conta contaCreate() {
        return new Conta("Teste", 100.0, LocalDate.now(), LocalDate.now());
    }
}
