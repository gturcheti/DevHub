package br.gturcheti.devhub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.gturcheti.devhub.ui.theme.DevHubTheme

lateinit var user: User
lateinit var fontFamily: FontFamily

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        user = User(
            name = "Gabriel Turcheti",
            userName = "gturcheti",
            bio = "Android Developer",
            profilePicture = R.drawable.profile_devhub
        )

        fontFamily = FontFamily(
            Font(R.font.prompt_thin, FontWeight.Thin),
            Font(R.font.prompt_light, FontWeight.Light),
            Font(R.font.prompt_regular, FontWeight.Normal),
            Font(R.font.prompt_medium, FontWeight.Medium),
            Font(R.font.prompt_semi_bold, FontWeight.SemiBold),
            Font(R.font.prompt_bold, FontWeight.Bold),
            Font(R.font.prompt_extra_bold, FontWeight.ExtraBold),
        )

        setContent {
            DevHubTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DevHubProfile(user)
                }
            }
        }
    }
}

@Composable
fun DevHubProfile(user: User) {

    Box {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(175.dp)
                .clip(
                    RoundedCornerShape(
                        bottomEnd = 50.dp,
                        bottomStart = 50.dp
                    )
                )
                .background(Color.DarkGray)

        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 75.dp),
            Arrangement.Center,
            Alignment.CenterHorizontally
        ) {
            Image(
                painterResource(user.profilePicture),
                "profile_picture",
                modifier = Modifier
                    .size(200.dp)
                    .border(2.dp, Color.DarkGray, CircleShape)
                    .clip(CircleShape),
            )
            Text(
                text = user.name,
                fontSize = 30.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Text(
                text = user.userName,
                fontSize = 20.sp,
                fontFamily = fontFamily,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = user.bio,
                fontSize = 20.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight.Light,
                textAlign = TextAlign.Center
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDevHubProile() {
    DevHubProfile(user)
}
