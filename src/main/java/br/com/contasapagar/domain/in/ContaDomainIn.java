package br.com.contasapagar.domain.in;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class ContaDomainIn {

    @NotBlank(message = "{field} Nome {required}")
    private String nome;

    @NotNull(message = "{field} Valor Original {required}")
    private Double valorOriginal;

    @NotNull(message = "{field} Data de Vencimento {required}")
    private LocalDate dataVencimento;

    @NotNull(message = "{field} Data de Pagamento {required}")
    private LocalDate dataPagamento;

    public ContaDomainIn(String nome, Double valorOriginal, LocalDate dataVencimento, LocalDate dataPagamento) {
        this.nome = nome;
        this.valorOriginal = valorOriginal;
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValorOriginal() {
        return valorOriginal;
    }

    public void setValorOriginal(Double valorOriginal) {
        this.valorOriginal = valorOriginal;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}
