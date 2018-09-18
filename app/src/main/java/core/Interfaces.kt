package core

import data.Card
import data.Member

interface ICardService {
    fun findCardById(cardId: String): Card?
    fun findCardByIdAndType(cardId: String, cardType: String): Card?
}

interface IMemberService{
    fun getMembers(): MutableList<Member>
    fun getMemberById(memberId: Long): Member?
}