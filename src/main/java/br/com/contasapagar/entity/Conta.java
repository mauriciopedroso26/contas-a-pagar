package br.com.contasapagar.entity;

import br.com.contasapagar.converter.TipoRegraCalculoEnumConverter;
import br.com.contasapagar.enums.TipoRegraCalculoEnum;
import br.com.contasapagar.util.serializer.LocalDateDeserializer;
import br.com.contasapagar.util.serializer.LocalDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
}
