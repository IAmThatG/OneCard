package data

class CardRepository : ICardRepository {
    override fun selectCardByIdAndType(cardId: String, cardType: String): Card? {
        var foundCard: Card? = null
        InMemoryData.cards.forEach{
            foundCard = if(cardId == it.cardNumber && cardType == it.cardType) it else null
        }
        return foundCard
    }

    override fun selectCards(): MutableList<Card> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun selectCardById(cardId: String): Card? {
        var foundCard: Card? = null
        InMemoryData.cards.forEach{
            foundCard = if(cardId == it.cardNumber) it else null
        }
        return foundCard
    }
}