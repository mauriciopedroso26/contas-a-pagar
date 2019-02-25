package br.com.contasapagar.domain.out;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ContaDomainOut {

    private String nome;
    private Double valorOriginal;
    private Double valorCorrigido;
    private long quantidadeDiasAtraso;
    private LocalDate dataPagamento;
}
