package com.example.dicerollerapp2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerApp()
        }
    }
}

@Composable
fun DiceRollerApp() {
    var diceNumber by remember { mutableStateOf(1) }

    // Function to roll the dice
    fun rollDice() {
        diceNumber = Random.nextInt(1, 7) // Generate a random number between 1 and 6
    }

    // Updated Layout for Dice Roller with UI improvements
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .padding(top = 32.dp),  // Add padding at the top
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Title
        Text(
            text = "Dice Roller App",
            style = TextStyle(
                fontSize = 32.sp,
                color = Color.Black,
                fontFamily = MaterialTheme.typography.bodyLarge.fontFamily
            ),
            modifier = Modifier.padding(bottom = 32.dp) // Add padding below the title
        )

        // Dice image display based on the roll
        val diceImage = when (diceNumber) {
            1 -> painterResource(id = R.drawable.dice_1)
            2 -> painterResource(id = R.drawable.dice_2)
            3 -> painterResource(id = R.drawable.dice_3)
            4 -> painterResource(id = R.drawable.dice_4)
            5 -> painterResource(id = R.drawable.dice_5)
            else -> painterResource(id = R.drawable.dice_6)
        }

        // Display the dice image dynamically
        Image(
            painter = diceImage,
            contentDescription = "Dice Image",
            modifier = Modifier.size(128.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))  // Add some space between dice and button

        // Roll Dice button with updated style
        Button(
            onClick = { rollDice() },
            shape = CircleShape,  // Round shape for the button
            modifier = Modifier.padding(top = 16.dp),  // Add some space on top of the button
            contentPadding = PaddingValues(16.dp)
        ) {
            Text("Roll Dice", style = MaterialTheme.typography.bodyLarge, color = Color.White)
        }
    }
}
