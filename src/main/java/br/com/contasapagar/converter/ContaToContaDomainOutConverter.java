package br.com.contasapagar.converter;

import br.com.contasapagar.domain.out.ContaDomainOut;
import br.com.contasapagar.entity.Conta;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ContaToContaDomainOutConverter implements Converter<Conta, ContaDomainOut> {

    private final ModelMapper modelMapper;

    public ContaToContaDomainOutConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ContaDomainOut convert(Conta conta) {
        ContaDomainOut contaDomainOut = modelMapper.map(conta, ContaDomainOut.class);

        if (Objects.isNull(contaDomainOut)) {
            throw new IllegalArgumentException("Objeto Conta não pode ser convertido em ContaDomainOut");
        }

        return contaDomainOut;
    }
}
