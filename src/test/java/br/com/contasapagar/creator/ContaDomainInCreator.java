package br.com.contasapagar.creator;

import br.com.contasapagar.domain.in.ContaDomainIn;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ContaDomainInCreator {

    public ContaDomainIn contaDomainInCreate() {
        return new ContaDomainIn("Teste", 100.0, LocalDate.now(), LocalDate.now());
    }

    public ContaDomainIn contaDomainInCreateAte3DiasDeAtraso() {
        return new ContaDomainIn("Teste", 100.0, LocalDate.parse("2019-02-24"),
                LocalDate.parse("2019-02-27"));
    }

    public ContaDomainIn contaDomainInCreateSuperiorA3DiasDeAtraso() {
        return new ContaDomainIn("Teste", 100.0, LocalDate.parse("2019-02-24"),
                LocalDate.parse("2019-03-01"));
    }

    public ContaDomainIn contaDomainInCreateSuperiorA5DiasDeAtraso() {
        return new ContaDomainIn("Teste", 100.0, LocalDate.parse("2019-02-24"),
                LocalDate.parse("2019-03-02"));
    }
}
