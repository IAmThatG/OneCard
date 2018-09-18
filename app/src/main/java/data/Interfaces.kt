package data

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query

interface ICardRepository{
    fun selectCards(): MutableList<Card>
    fun selectCardById(cardId: String): Card?
    fun selectCardByIdAndType(cardId: String, cardType: String): Card?
}

interface IMemberRepository{
    fun selectMembers(): MutableList<Member>
    fun selectMemberById(memberId: Long): Member?
}