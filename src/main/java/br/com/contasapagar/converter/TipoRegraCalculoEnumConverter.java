package br.com.contasapagar.converter;

import br.com.contasapagar.enums.TipoRegraCalculoEnum;

import javax.persistence.AttributeConverter;
import java.util.Objects;

public class TipoRegraCalculoEnumConverter implements AttributeConverter<TipoRegraCalculoEnum, String> {

    @Override
    public String convertToDatabaseColumn(TipoRegraCalculoEnum tipoRegraCalculoEnum) {
        return Objects.nonNull(tipoRegraCalculoEnum) ? tipoRegraCalculoEnum.name() : null;
    }

    @Override
    public TipoRegraCalculoEnum convertToEntityAttribute(String name) {
        return TipoRegraCalculoEnum.getValue(name);
    }
}
