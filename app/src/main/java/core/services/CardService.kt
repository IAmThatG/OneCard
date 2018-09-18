package core.services

import core.ICardService
import data.Card
import data.ICardRepository


class CardService(private val mCardRepo: ICardRepository) : ICardService {
    override fun findCardByIdAndType(cardId: String, cardType: String): Card?
            = mCardRepo.selectCardByIdAndType(cardId.toLowerCase().trim(), cardType.toLowerCase().trim())

    override fun findCardById(cardId: String): Card?
            = mCardRepo.selectCardById(cardId.trim().toLowerCase())
}