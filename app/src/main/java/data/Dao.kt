package data

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

@Dao
interface MemberDao {
    @Query("SELECT * FROM tbl_Members WHERE member_id = :memberId")
    fun getMemberById(memberId: Long): LiveData<Member?>
}

@Dao
interface CardDao{
    @Query("SELECT * FROM tbl_Cards WHERE card_number = :cardNumber")
    fun getCardByNumber(cardNumber: String): LiveData<Card?>

    @Query("SELECT * FROM tbl_Cards WHERE card_number = :cardNumber AND card_type = :cardType")
    fun getCardByNumberAndType(cardNumber: String, cardType: String): LiveData<Card?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveCard(card: Card): Int

    @Query("SELECT * FROM tbl_Cards")
    fun getAllCards(): LiveData<MutableList<Card>>
}