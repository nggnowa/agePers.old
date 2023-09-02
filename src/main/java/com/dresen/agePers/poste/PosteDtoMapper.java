package com.dresen.agePers.poste;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class PosteDtoMapper implements Function<Poste, PosteDto> {

    @Override
    public PosteDto apply(Poste poste) {

        return new PosteDto(
                poste.getId(),
                poste.getTitre(),
                poste.getRang()
        );
    }

}
