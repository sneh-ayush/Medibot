
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import medibot.composeapp.generated.resources.Res
import medibot.composeapp.generated.resources.medibot
import org.example.project.ChatUI
import org.jetbrains.compose.resources.painterResource

@Composable
fun App() {
    var showChat by remember { mutableStateOf(false) }
    MaterialTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            if (showChat) {

                ChatUI()
            } else {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    // Heading (at the top)
                    Text(
                        text = "Welcome to Medibot",
                        style = MaterialTheme.typography.h4,
                        modifier = Modifier.padding(top = 32.dp, bottom = 16.dp) // Add padding
                    )
                    Box(
                        modifier = Modifier
                            .weight(1f) // Take up most of the space
                            .fillMaxWidth(), // Fill the width
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(Res.drawable.medibot),
                            contentDescription = "Compose Multiplatform",
                            modifier = Modifier
                                .fillMaxWidth(0.4f) // Make image wide
                                .aspectRatio(0.5f)  // Maintain aspect ratio (square)
                        )
                    }
                    Button(
                        onClick = {
                            showChat = true
                        },
                        modifier = Modifier
                            .fillMaxWidth(0.3f) // Make the button wider (50% of the available width)
                            .padding(
                                horizontal = 16.dp,
                                vertical = 32.dp
                            ), // Add padding below the image
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.Blue, // Change button background color
                            contentColor = Color.White // Change text/icon color inside the button
                        ),
                        shape = RoundedCornerShape(10.dp), //rounded shape
                        enabled = true,

                        ) {
                        Text("Click Me", textAlign = TextAlign.Center)
                    }
                }

            }
            Text(
                text = "A Project by Sneha Shekhar",
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
                ,
                color = Color.Black,
                textAlign = TextAlign.End,
                style = MaterialTheme.typography.subtitle1
            )
        }
    }
}