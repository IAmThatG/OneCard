package core

import android.provider.ContactsContract
import java.io.Serializable
import java.util.*

data class Member(var id: Int, var memberId: String, var firstname: String,
                   var lastname: String, var middlename: String?,
                   var email: String, var phone: String, var DOB: String,
                  var nationality: String, var profilePicResourceId: Int): Serializable

data class Card(var id: Int, var cardId: String, var cardType: String,
                var barcodeResourceId: Int, var memberId: Int): Serializable