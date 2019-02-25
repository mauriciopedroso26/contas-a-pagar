package br.com.contasapagar.entity;

import br.com.contasapagar.converter.TipoRegraCalculoEnumConverter;
import br.com.contasapagar.enums.TipoRegraCalculoEnum;
import br.com.contasapagar.util.serializer.LocalDateDeserializer;
import br.com.contasapagar.util.serializer.LocalDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "TA_CONTA")
public class Conta implements Serializable {

    private static final long serialVersionUID = -8304718941711278126L;

    @Id
    @GeneratedValue
    @Column(name = "ID_CONTA", nullable = false)
    private Long idConta;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "VALOR_ORIGINAL", nullable = false)
    private Double valorOriginal;

    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @Column(name = "DATA_VENCIMENTO", nullable = false)
    private LocalDate dataVencimento;

    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @Column(name = "DATA_PAGAMENTO", nullable = false)
    private LocalDate dataPagamento;

    @Column(name = "VALOR_CORRIGIDO", nullable = false)
    private Double valorCorrigido;

    @Column(name = "QUANTIDADE_DIAS_ATRASO", nullable = false)
    private long quantidadeDiasAtraso;

    @Convert(converter = TipoRegraCalculoEnumConverter.class)
    @Column(name = "TIPO_REGRA_CALCULO", nullable = false)
    private TipoRegraCalculoEnum tipoRegraCalculo;

    public Conta() {
    }

    public Conta(String nome, Double valorOriginal, LocalDate dataVencimento, LocalDate dataPagamento) {
        this.nome = nome;
        this.valorOriginal = valorOriginal;
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }

    public Long getIdConta() {
        return idConta;
    }

    public void setIdConta(Long idConta) {
        this.idConta = idConta;
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

    public TipoRegraCalculoEnum getTipoRegraCalculo() {
        return tipoRegraCalculo;
    }

    public void setTipoRegraCalculo(TipoRegraCalculoEnum tipoRegraCalculo) {
        this.tipoRegraCalculo = tipoRegraCalculo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Conta conta = (Conta) o;
        return quantidadeDiasAtraso == conta.quantidadeDiasAtraso &&
                Objects.equals(idConta, conta.idConta) &&
                Objects.equals(nome, conta.nome) &&
                Objects.equals(valorOriginal, conta.valorOriginal) &&
                Objects.equals(dataVencimento, conta.dataVencimento) &&
                Objects.equals(dataPagamento, conta.dataPagamento) &&
                Objects.equals(valorCorrigido, conta.valorCorrigido) &&
                tipoRegraCalculo == conta.tipoRegraCalculo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idConta, nome, valorOriginal, dataVencimento, dataPagamento, valorCorrigido,
                quantidadeDiasAtraso, tipoRegraCalculo);
    }

    @Override
    public String toString() {
        return "Conta{" +
                "idConta=" + idConta +
                ", nome='" + nome + '\'' +
                ", valorOriginal=" + valorOriginal +
                ", dataVencimento=" + dataVencimento +
                ", dataPagamento=" + dataPagamento +
                ", valorCorrigido=" + valorCorrigido +
                ", quantidadeDiasAtraso=" + quantidadeDiasAtraso +
                ", tipoRegraCalculo=" + tipoRegraCalculo +
                '}';
    }
}
