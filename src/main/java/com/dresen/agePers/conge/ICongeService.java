package com.dresen.agePers.conge;

import java.util.List;

public interface ICongeService {

    CongeDto createConge(CongeDto congeDto);

    List<CongeDto> getAllConges();

    CongeDto getCongeById(Long id);

    CongeDto updateConge(Long id, CongeDto congeDto);

    void deleteConge(Long id);

}
