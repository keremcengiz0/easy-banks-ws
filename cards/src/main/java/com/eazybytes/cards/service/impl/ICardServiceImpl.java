package com.eazybytes.cards.service.impl;

import com.eazybytes.cards.constant.CardConstant;
import com.eazybytes.cards.dto.CardDto;
import com.eazybytes.cards.entity.Card;
import com.eazybytes.cards.exception.CardAlreadyExistsException;
import com.eazybytes.cards.exception.ResourceNotFoundException;
import com.eazybytes.cards.mapper.CardMapper;
import com.eazybytes.cards.repository.CardRepository;
import com.eazybytes.cards.service.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class ICardServiceImpl implements ICardService {

    private final CardRepository cardRepository;
    private final CardMapper cardMapper;

    @Autowired
    public ICardServiceImpl(CardRepository cardRepository, CardMapper cardMapper) {
        this.cardRepository = cardRepository;
        this.cardMapper = cardMapper;
    }

    @Override
    public void createCard(String mobileNumber) {
        Optional<Card> optionalCard = cardRepository.findByMobileNumber(mobileNumber);

        if(optionalCard.isPresent()) {
            throw new CardAlreadyExistsException("Card already registered with given mobile number: " + mobileNumber);
        }

        cardRepository.save(createNewCard(mobileNumber));
    }

    private Card createNewCard(String mobileNumber) {

        long randomCardNumber = 100000000000L + new Random().nextInt(900000000);

        Card newCard = new Card();
        newCard.setCardNumber(Long.toString(randomCardNumber));
        newCard.setMobileNumber(mobileNumber);
        newCard.setCardType(CardConstant.CREDIT_CARD);
        newCard.setTotalLimit(CardConstant.NEW_CARD_LIMIT);
        newCard.setAmountUsed(0);
        newCard.setAvailableAmount(CardConstant.NEW_CARD_LIMIT);

        return newCard;

    }

    @Override
    public CardDto getCard(String mobileNumber) {
        Card card = cardRepository.findByMobileNumber(mobileNumber).orElseThrow(() -> new ResourceNotFoundException("Card", "mobileNumber", mobileNumber));
        return cardMapper.cardToCardDto(card);
    }

    @Override
    public boolean updateCard(CardDto cardsDto) {
        Card card = cardRepository.findByCardNumber(cardsDto.getCardNumber()).orElseThrow(() -> new ResourceNotFoundException("Card", "cardNumber", cardsDto.getCardNumber()));
        cardMapper.updateCardDtoToCard(cardsDto, card);
        return true;
    }

    @Override
    public boolean deleteCard(String mobileNumber) {
        Card card = cardRepository.findByMobileNumber(mobileNumber).orElseThrow(() -> new ResourceNotFoundException("Card", "mobileNumber", mobileNumber));
        cardRepository.deleteById(card.getCardId());
        return true;
    }


}
