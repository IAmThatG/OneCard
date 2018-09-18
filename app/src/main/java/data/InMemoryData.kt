package data

import com.example.hello.onecard.R

class InMemoryData {

    companion object {
        /*fun create(): InMemoryData = InMemoryData()*/

        var cards: MutableList<Card> = mutableListOf(
                Card(1, "1234", "voters card", R.drawable.card1262662, 1),
                Card(2, "1235", "national id card", R.drawable.card1262662, 2)
        )
        var members: MutableList<Member> = mutableListOf(
                Member(1, "AB1234", "Abass", "Solude", null,
                        "sabass@chams.com", "08181117777",
                        "21 May 1990", "Nigeria", R.drawable.user1),
                Member(2, "AB1235", "Dorcas", "Adeyemi", null,
                        "dorcas@gmail.com", "08080466574",
                        "21 May 1990", "Nigeria", R.drawable.user2)
        )
    }
}