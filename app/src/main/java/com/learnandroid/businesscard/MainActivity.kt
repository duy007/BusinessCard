package com.learnandroid.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.learnandroid.businesscard.ui.theme.BusinessCardTheme
import com.learnandroid.businesscard.ui.theme.backgroundColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = backgroundColor
                ) {
                    BusinessCard("Duy Nguyen", "Local Fat Man")
                }
            }
        }
    }
}

@Composable
fun InfoWithImage(name: String, title: String) {
    val image = painterResource(id = R.drawable.quaxly_pfp)
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(image, contentDescription = "profile picture",
            modifier = Modifier
                .height(128.dp)
                .padding(0.dp, 16.dp, 0.dp, 8.dp))
        InfoText(name, title)
    }
}

@Composable
fun InfoText(name: String, title: String) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
            ) {
        Text(name,
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 16.dp))
        Text(title, textAlign = TextAlign.Justify)
    }
}

@Composable
fun ContactInfo() {
    Column (
        modifier = Modifier.padding(bottom = 16.dp)
            ){
        for (contact in Contacts.contactList) {
            ContactInfoRow(contact)
            Spacer(modifier = Modifier.padding(4.dp))
        }
    }

}



@Composable
fun ContactInfoRow(info: ContactInfo, modifier: Modifier = Modifier) {
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
            )
    {
        Icon(imageVector = info.icon, contentDescription = "${info.desc} Icon",
        modifier = Modifier.padding(32.dp, 0.dp, 8.dp, 0.dp))
        Text(info.info, modifier = Modifier.padding(end = 64.dp), textAlign = TextAlign.Center)
    }
}

@Composable
fun BusinessCard(name: String, title: String) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxSize()
    ) {
        InfoWithImage(name, title)
        Spacer(modifier = Modifier.padding(64.dp))
        ContactInfo()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = backgroundColor
        ) {
            BusinessCard("Duy Nguyen", "Local Fat Man")
        }
    }
}