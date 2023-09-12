package com.dresen.agePers.poste;

import java.util.List;

public interface PosteIService {

    PosteDto createPoste(PosteDto posteDto);

    List<PosteDto> getAllPostes();

    PosteDto getPosteById(Long id);

    PosteDto updatePoste(Long id, PosteDto posteDto);

    void deletePoste(Long id);

}
