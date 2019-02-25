package br.com.contasapagar.domain.out;


import java.time.LocalDate;

public class ContaDomainOut {

    private String nome;
    private Double valorOriginal;
    private Double valorCorrigido;
    private long quantidadeDiasAtraso;
    private LocalDate dataPagamento;

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

    public Double getValorCorrigido() {
        return valorCorrigido;
    }

    public void setValorCorrigido(Double valorCorrigido) {
        this.valorCorrigido = valorCorrigido;
    }

    public long getQuantidadeDiasAtraso() {
        return quantidadeDiasAtraso;
    }

    public void setQuantidadeDiasAtraso(long quantidadeDiasAtraso) {
        this.quantidadeDiasAtraso = quantidadeDiasAtraso;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}
