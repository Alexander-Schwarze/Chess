import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview
fun App() {

    val buttonModifier = Modifier
        .fillMaxWidth()
        .padding(top = 30.dp)
        .size(130.dp)
    MaterialTheme {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 15.dp, top = 15.dp, end = 50.dp, start = 50.dp)
        ) {
            Column {
                Text(
                    text = MetaData.menuHeadlineText,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .height(60.dp),
                    fontFamily = FontFamily.Monospace,
                    fontSize = 50.sp
                )

                Button(
                    onClick = {
                        
                    },
                    modifier = buttonModifier,
                    contentPadding = PaddingValues(all = 0.dp)
                ) {
                    Box {
                        MenuButtonImage(
                            pictureName = MetaData.menuButtonImagePvp,
                            pictureDescription = "Image for Player vs Player button"
                        )
                        MenuButtonText(text = MetaData.menuButtonTextPvp)
                    }
                }

                Button(
                    onClick = {

                    },
                    modifier = buttonModifier,
                    contentPadding = PaddingValues(all = 0.dp)
                ) {
                    Box {
                        MenuButtonImage(
                            pictureName = MetaData.menuButtonImagePvb,
                            pictureDescription = "Image for Player vs Bot button"
                        )
                        MenuButtonText(text = MetaData.menuButtonTextPvb)
                    }
                }
            }
        }
    }
}

@Composable
fun MenuButtonText(text: String){
    Text(
        text = text,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 10.dp, start = 10.dp),
        textAlign = TextAlign.Start,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 25.sp
    )
}

@Composable
fun MenuButtonImage(pictureName: String, pictureDescription: String){
    Image(
        painter = painterResource(resourcePath = pictureName),
        contentDescription = pictureDescription,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop,
        alpha = 0.7f
    )
}

val colors = arrayOf(Color.Blue, Color.Cyan, Color.Green, Color.Magenta, Color.Red, Color.Yellow)


/*@Composable
fun MessageCard(msg: Message){
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Text(
            text = msg.author.substring(0, 2).uppercase(),
            modifier = Modifier
                .size(40.dp)
                .background(
                    color = colors[msg.author.chars().sum() % colors.size],
                    shape = CircleShape
                )
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape),
            color = Color.White
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(
                text = msg.author,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2
            )

            Spacer(modifier = Modifier.height(4.dp))

            Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp) {
                Text(
                    text = msg.message,
                    modifier = Modifier.padding(all = 4.dp),
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}*/