package com.example.hello.onecard.activities

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.hello.onecard.R
import core.ICardService
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private lateinit var mCardTypeRadioGroup: RadioGroup
    private lateinit var mSelectedRadioButton: RadioButton
    private lateinit var mSearchEditText: EditText
    private lateinit var mSearchButton: Button

    private val mCardService: ICardService by inject()
    private val CARD_DATA_PLACEHOLDER = "cardData"
    private var mCheckedRadioId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //generate in-memory data

        //find and assign views
        initView()
        //add view events
//        handleRadioGroupClick()
        handleSearchButtonClick()
    }

    private fun handleRadioGroupClick(): Boolean {
        //if a radio button isn't clicked show dialog
        mCheckedRadioId = mCardTypeRadioGroup.checkedRadioButtonId

        if (mCheckedRadioId > -1) {
            mSelectedRadioButton = findViewById(mCheckedRadioId)
            return true
        }
        return false
    }

    private fun initView(){
        mCardTypeRadioGroup = findViewById(R.id.rg_card_type)
        mSearchEditText = findViewById(R.id.et_search)
        mSearchButton = findViewById(R.id.btn_search)
    }

    private fun handleSearchButtonClick(){
        mSearchButton.setOnClickListener {
            if (handleRadioGroupClick()) {
                val cardType: String = mSelectedRadioButton.text.toString()
                val foundCard = mCardService.findCardByIdAndType(
                        mSearchEditText.text.toString(), cardType)
                if (foundCard != null) {
                    val intent = Intent(this, CardActivity::class.java).apply {
                        putExtra(CARD_DATA_PLACEHOLDER, foundCard)
                    }
                    startActivity(intent)
                } else {
                    //show dialog stating card not ready
                    showCustomDialog("Card Not Ready")
                }
            }
            else{
                showCustomDialog("Please select card type")
            }
        }
    }

    private fun showCustomDialog(msg: String) {
        var dialog: Dialog = Dialog(this)
        dialog.setTitle(msg)
        dialog.setCancelable(true)
        dialog.show()
    }


}
