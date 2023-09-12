package com.dresen.agePers.ethnie;

import java.util.List;

public interface EthnieIService {

    EthnieDto createEthnie(EthnieDto ethnieDto);

    List<EthnieDto> getAllEthnies();

    EthnieDto getEthnieById(Long id);

    EthnieDto updateEthnie(Long id, EthnieDto ethnieDto);

    void deleteEthnie(Long id);

}
