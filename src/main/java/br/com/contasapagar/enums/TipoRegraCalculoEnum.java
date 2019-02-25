package br.com.contasapagar.enums;

import java.util.stream.Stream;

public enum TipoRegraCalculoEnum {

    ATE_3_DIAS(1, "Até 3 dias", 1.02, 1.001),
    SUPERIOR_A_3_DIAS(2, "Superior a 3 dias", 1.03, 1.002),
    SUPERIOR_A_5_DIAS(3, "Superior a 5 dias", 1.05, 1.003),
    NAO_ESTA_EM_ATRASO(4, "Não está em atraso", null, null);

    private final Integer code;
    private final String descricao;
    private final Double multa;
    private final Double jurosDia;

    TipoRegraCalculoEnum(Integer code, String descricao, Double multa, Double jurosDia) {
        this.descricao = descricao;
        this.code = code;
        this.multa = multa;
        this.jurosDia = jurosDia;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public Double getMulta() {
        return multa;
    }

    public Double getJurosDia() {
        return jurosDia;
    }

    public static TipoRegraCalculoEnum getValue(String name) {
        return Stream.of(values()).filter(e -> name.equals(e.name())).findFirst().orElseThrow(() ->
                new IllegalArgumentException("Nome não existe no TipoRegraCalculoEnum: nome=" + name));
    }
}
