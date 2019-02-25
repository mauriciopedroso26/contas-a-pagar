package br.com.contasapagar.strategy;

import br.com.contasapagar.entity.Conta;

public interface Multa {

    Conta calculaMulta(Conta conta, long diasEmAtraso);
}
