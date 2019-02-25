package br.com.contasapagar.domain.in;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class ContaDomainIn {

    @NotBlank(message = "{field} Nome {required}")
    private String nome;

    @NotNull(message = "{field} Valor Original {required}")
    private Double valorOriginal;

    @NotNull(message = "{field} Data de Vencimento {required}")
    private LocalDate dataVencimento;

    @NotNull(message = "{field} Data de Pagamento {required}")
    private LocalDate dataPagamento;
}
