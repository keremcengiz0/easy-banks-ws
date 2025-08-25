package com.eazybytes.cards.service;

import com.eazybytes.cards.dto.CardDto;
import jakarta.validation.Valid;

public interface ICardService {
    void createCard(String mobileNumber);

    CardDto getCard(String mobileNumber);

    boolean updateCard(@Valid CardDto cardsDto);

    boolean deleteCard(String mobileNumber);
}
