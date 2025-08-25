package com.eazybytes.cards.mapper;

import com.eazybytes.cards.dto.CardDto;
import com.eazybytes.cards.entity.Card;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CardMapper {
    CardMapper INSTANCE = Mappers.getMapper( CardMapper.class );

    CardDto cardToCardDto(Card card);
    Card cardDtoToCard(CardDto cardDto);
    void updateCardDtoToCard(CardDto cardDto, @MappingTarget Card card);
}
