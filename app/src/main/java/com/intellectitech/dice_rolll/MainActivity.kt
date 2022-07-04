package com.intellectitech.dice_rolll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton =findViewById<Button>(R.id.button)
        //val rollButton :Button =findViewById(R.id.button)
       //set a click listner on the button to roll when the user taps it
        rollButton.setOnClickListener { rollDice() }
        //Do a dice roll when the app starts
        rollDice()
    }

    private fun rollDice() {
        //create new dice objects with 6 sides and roll it
        val dice =Dice(6)
        val diceRoll = dice.roll()
        //Find the imageview in the layout
        val diceimage= findViewById<ImageView>(R.id.imageview)
        //Determine which drawable resource idto use based on the dice roll use when else statement
        val drawableResource = when (diceRoll){
            1 -> R.drawable.dice_1
            2-> R.drawable.dice_2
            3-> R.drawable.dice_3
            4-> R.drawable.dice_4
            5-> R.drawable.dice_5
            else->R.drawable.dice_6
        }
        //Updatethe image view withe correct drawable resource ID

        diceimage.setImageResource(drawableResource)
        //update the content description
        diceimage.contentDescription=diceRoll.toString()

    }

}

