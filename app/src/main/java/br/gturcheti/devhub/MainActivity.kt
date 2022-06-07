package br.gturcheti.devhub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import br.gturcheti.devhub.ui.theme.DevHubTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DevHubTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val user = User(
                        name = "Gabriel Turcheti",
                        userName = "gturcheti",
                        bio = "Android Developer",
                        profilePicture = R.drawable.profile_devhub
                    )

                    DevHubProfile(user)

                }
            }
        }
    }
}

@Composable
fun DevHubProfile(user: User) {
    Column {
        Image(
            painterResource(user.profilePicture),
            user.name,
        )
        Text(user.name)
        Text(user.userName)
        Text(user.bio)
    }
}

