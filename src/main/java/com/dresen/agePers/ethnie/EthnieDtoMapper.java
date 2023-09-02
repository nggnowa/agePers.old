package com.dresen.agePers.ethnie;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class EthnieDtoMapper implements Function<Ethnie, EthnieDto> {

    @Override
    public EthnieDto apply(Ethnie ethnie) {

        return new EthnieDto(
                ethnie.getId(),
                ethnie.getNom()
        );
    }

}
