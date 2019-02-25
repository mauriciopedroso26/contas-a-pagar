package br.com.contasapagar.enums;

import br.com.contasapagar.entity.Conta;
import br.com.contasapagar.strategy.Multa;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.stream.Stream;

public enum TipoRegraCalculoEnum implements
        Multa {

    ATE_3_DIAS{
        @Override
        public Conta calculaMulta(Conta conta, long diasEmAtraso) {
            conta.setValorCorrigido(conta.getValorOriginal() * 1.02);

            for (int i = 1; i <= diasEmAtraso; i++) {
                conta.setValorCorrigido(Double.parseDouble(numberFormat(conta.getValorCorrigido() * 1.001)));
            }

            conta.setQuantidadeDiasAtraso(diasEmAtraso);
            conta.setTipoRegraCalculo(ATE_3_DIAS);

            return conta;
        }
    },
    SUPERIOR_A_3_DIAS{
        @Override
        public Conta calculaMulta(Conta conta, long diasEmAtraso) {
            conta.setValorCorrigido(conta.getValorOriginal() * 1.03);

            for (int i = 1; i <= diasEmAtraso; i++) {
                conta.setValorCorrigido(Double.parseDouble(numberFormat(conta.getValorCorrigido() * 1.002)));
            }

            conta.setQuantidadeDiasAtraso(diasEmAtraso);
            conta.setTipoRegraCalculo(SUPERIOR_A_3_DIAS);

            return conta;
        }
    },
    SUPERIOR_A_5_DIAS{
        @Override
        public Conta calculaMulta(Conta conta, long diasEmAtraso) {
            conta.setValorCorrigido(conta.getValorOriginal() * 1.05);

            for (int i = 1; i <= diasEmAtraso; i++) {
                conta.setValorCorrigido(Double.parseDouble(numberFormat(conta.getValorCorrigido() * 1.003)));
            }

            conta.setQuantidadeDiasAtraso(diasEmAtraso);
            conta.setTipoRegraCalculo(SUPERIOR_A_5_DIAS);

            return conta;
        }
    },
    NAO_ESTA_EM_ATRASO() {
        @Override
        public Conta calculaMulta(Conta conta, long diasEmAtraso) {
            conta.setQuantidadeDiasAtraso(0);
            conta.setValorCorrigido(0.0);
            conta.setTipoRegraCalculo(NAO_ESTA_EM_ATRASO);

            return conta;
        }
    };


    public static TipoRegraCalculoEnum getNome(String name) {
        return Stream.of(values()).filter(e -> name.equals(e.name())).findFirst().orElseThrow(() ->
                new IllegalArgumentException("Nome não existe no TipoRegraCalculoEnum: nome=" + name));
    }

    public String numberFormat(double valor) {
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("0.00", dfs);
        return df.format(valor);
    }
}
