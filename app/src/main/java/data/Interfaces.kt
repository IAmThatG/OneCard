package data

import core.Card
import core.Member

interface ICardRepository{
    fun selectCards(): MutableList<Card>
    fun selectCardById(cardId: String): Card?
    fun selectCardByIdAndType(cardId: String, cardType: String): Card?
}

interface IMemberRepository{
    fun selectMembers(): MutableList<Member>
    fun selectMemberById(memberId: Int): Member?
}