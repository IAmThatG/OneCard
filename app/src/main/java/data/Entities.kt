package data

import android.arch.persistence.room.*
import java.io.Serializable

@Entity(tableName = "tbl_Members",
        indices = [(Index(value = ["email", "phone_number"],unique = true))],
        primaryKeys = ["id"]
)
data class Member(@PrimaryKey(autoGenerate = true) var id: Long,
                  @ColumnInfo(name = "member_id") var memberId: String,
                  @ColumnInfo(name = "first_name") var firstname: String,
                  @ColumnInfo(name = "last_name") var lastname: String,
                  @ColumnInfo(name = "middle_name") var middlename: String?,
                  @ColumnInfo(name = "email") var email: String,
                  @ColumnInfo(name = "phone_number") var phone: String,
                  @ColumnInfo(name = "dob") var DOB: String,
                  @ColumnInfo(name = "nationality") var nationality: String,
                  @ColumnInfo(name = "profile_res_id") var profilePicResourceId: Int): Serializable

@Entity(tableName = "tbl_Cards",
        foreignKeys = [(ForeignKey(entity = Member::class,
        parentColumns = ["member_id"], childColumns = ["member_id"],
                onDelete = ForeignKey.CASCADE))],
        indices = [(Index(value = ["card_number"], unique = true))]
)
data class Card(@PrimaryKey(autoGenerate = true) var id: Long,
                @ColumnInfo(name = "card_number") var cardNumber: String,
                @ColumnInfo(name = "card_type") var cardType: String,
                @ColumnInfo(name = "barcode_res_id") var barcodeResourceId: Int,
                @ColumnInfo(name = "member_id") var memberId: Long): Serializable