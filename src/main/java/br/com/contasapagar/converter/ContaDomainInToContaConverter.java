package br.com.contasapagar.converter;

import br.com.contasapagar.domain.in.ContaDomainIn;
import br.com.contasapagar.entity.Conta;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ContaDomainInToContaConverter implements Converter<ContaDomainIn, Conta> {

    private final ModelMapper modelMapper;

    public ContaDomainInToContaConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public Conta convert(ContaDomainIn contaDomainIn) {
        Conta conta = modelMapper.map(contaDomainIn, Conta.class);

        if (Objects.isNull(conta)) {
            throw new IllegalArgumentException("Objeto ContaDomainIn não pode ser convertido em Conta");
        }

        return conta;
    }
}
