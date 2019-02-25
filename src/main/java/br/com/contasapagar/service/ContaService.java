package br.com.contasapagar.service;

import br.com.contasapagar.entity.Conta;
import br.com.contasapagar.enums.TipoRegraCalculoEnum;
import br.com.contasapagar.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class ContaService {

    private final ContaRepository contaRepository;

    @Autowired
    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public Conta save(Conta conta) {
        long diasEmAtraso = verificaSeEstaEmAtraso(conta);

        if (diasEmAtraso > 0 && diasEmAtraso <= 3) {
            conta.setValorCorrigido(conta.getValorOriginal() * TipoRegraCalculoEnum.ATE_3_DIAS.getMulta());

            for (int i = 1; i <= diasEmAtraso; i++) {
                conta.setValorCorrigido(conta.getValorCorrigido() * TipoRegraCalculoEnum.ATE_3_DIAS.getJurosDia());
            }

            conta.setQuantidadeDiasAtraso(diasEmAtraso);
            conta.setTipoRegraCalculo(TipoRegraCalculoEnum.ATE_3_DIAS);
        } else if (diasEmAtraso > 3 && diasEmAtraso <= 5) {
            conta.setValorCorrigido(conta.getValorOriginal() * TipoRegraCalculoEnum.SUPERIOR_A_3_DIAS.getMulta());

            for (int i = 1; i <= diasEmAtraso; i++) {
                conta.setValorCorrigido(conta.getValorCorrigido() * TipoRegraCalculoEnum.SUPERIOR_A_3_DIAS.getJurosDia());
            }

            conta.setQuantidadeDiasAtraso(diasEmAtraso);
            conta.setTipoRegraCalculo(TipoRegraCalculoEnum.SUPERIOR_A_3_DIAS);
        } else if (diasEmAtraso > 5) {
            conta.setValorCorrigido(conta.getValorOriginal() * TipoRegraCalculoEnum.SUPERIOR_A_5_DIAS.getMulta());

            for (int i = 1; i <= diasEmAtraso; i++) {
                conta.setValorCorrigido(conta.getValorCorrigido() * TipoRegraCalculoEnum.SUPERIOR_A_5_DIAS.getJurosDia());
            }

            conta.setQuantidadeDiasAtraso(diasEmAtraso);
            conta.setTipoRegraCalculo(TipoRegraCalculoEnum.SUPERIOR_A_5_DIAS);
        } else {
            conta.setQuantidadeDiasAtraso(0);
            conta.setValorCorrigido(0.0);
            conta.setTipoRegraCalculo(TipoRegraCalculoEnum.NAO_ESTA_EM_ATRASO);
        }

        return contaRepository.save(conta);
    }

    public List<Conta> findAll() {
        return contaRepository.findAll();
    }

    private long verificaSeEstaEmAtraso(Conta conta) {
        return conta.getDataVencimento().until(conta.getDataPagamento(), ChronoUnit.DAYS);
    }
}
