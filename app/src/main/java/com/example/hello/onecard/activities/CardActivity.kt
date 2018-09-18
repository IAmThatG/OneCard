package com.example.hello.onecard.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.hello.onecard.R
import core.IMemberService
import data.Card
import data.Member
import org.koin.android.ext.android.inject

class CardActivity : AppCompatActivity() {
    private lateinit var mCardIdTextView: TextView
    private lateinit var mMemberIdTextView: TextView
    private lateinit var mMemberNameTextView: TextView
    private lateinit var mEmailTextView: TextView
    private lateinit var mProfilePic: ImageView
    private lateinit var mBarCodeImg: ImageView
    private lateinit var mCardTypeTextView: TextView
    private lateinit var mIdLabelTextView: TextView

    private lateinit var card: Card
    private val CARD_DATA_PLACEHOLDER = "cardData"
    private val mMemberService: IMemberService by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card)

        //find and assign views
        initView()
        //populate view
        populateViewData()
    }

    private fun initView() {
        mCardIdTextView = findViewById(R.id.tv_cardID)
        mMemberIdTextView = findViewById(R.id.tv_memberID)
        mMemberNameTextView = findViewById(R.id.tv_memberName)
        mEmailTextView = findViewById(R.id.tv_email)
        mProfilePic = findViewById(R.id.img_user)
        mBarCodeImg = findViewById(R.id.img_barcode)
        mCardTypeTextView = findViewById(R.id.tv_cardType)
        mIdLabelTextView = findViewById(R.id.tv_IdLabel)
    }

    private fun populateViewData(){
        //get the card obj passed via intent
        card = intent.getSerializableExtra(CARD_DATA_PLACEHOLDER) as Card
        //get associated member
        val member: Member? = mMemberService.getMemberById(card.memberId)
        //assign data to respective view controls
        mEmailTextView.text = member?.email ?: ""
        mMemberNameTextView.text = member?.firstname + " " + member?.lastname ?: ""
        mCardIdTextView.text = card.cardNumber
        mMemberIdTextView.text = member?.memberId ?: ""
        mProfilePic.setImageResource(member?.profilePicResourceId ?: R.drawable.default_user)
        mBarCodeImg.setImageResource(card.barcodeResourceId)
        mCardTypeTextView.text = card.cardType.toUpperCase()

        //decide label texts

    }

    private fun decideLabel(cardType: String)
    {
        when (cardType.toLowerCase()){

        }
    }
}
