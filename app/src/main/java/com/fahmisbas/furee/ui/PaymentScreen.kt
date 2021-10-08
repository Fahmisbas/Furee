package com.fahmisbas.furee.ui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.elevation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fahmisbas.furee.R
import com.fahmisbas.furee.ui.data.model.DoctorProfile
import com.fahmisbas.furee.ui.theme.*


@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(HomeColor)
            .padding(start = 18.dp, end = 18.dp, top = 36.dp, bottom = 16.dp)
    ) {
        Column() {
            val doctorProfile = DoctorProfile(
                name = "Dr. Corrie Anderson",
                speciality = "Cardiovascular",
                consultationDuration = 1
            )
            AppBar()
            DoctorProfileCard(
                doctorProfile
            )
            PaymentDetails(doctorProfile)
        }

    }
}

@Composable
fun PaymentDetails(doctorProfile: DoctorProfile) {
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
            .fillMaxWidth()
            .padding(vertical= 26.dp)
    ) {
        PaymentDetailText("Appointment Cost", 20)
        Text(
            "Consultation Fee for ${doctorProfile.consultationDuration} hour",
            fontSize = 16.sp,
            color = SupportTextCOlor,
            modifier = Modifier
                .padding(horizontal = 15.dp)
        )
        PaymentDetailText("Admin Fee", 50)
        PaymentDetailText(detail = "To Pay", cost = 70 )


        Button(onClick = {

        },modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp, vertical = 13.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFfdf8f5)),
            elevation = elevation(0.dp, 0.dp),
            shape = RoundedCornerShape(25.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
            ) {
                Image(painter = painterResource(id = R.drawable.ic_coupon) , contentDescription = "" )
                Text(text = "Use Promo Code", color = Color(0xFF575d69), fontSize = 20.sp)
                Image(painter = painterResource(id = R.drawable.ic_arrow_right_24dp), contentDescription = "")
            }

        }
    }
}

@Composable
fun PaymentDetailText(detail: String, cost: Int) {
    Row(
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 13.dp)
    ) {
        Text(text = detail, fontWeight = FontWeight.Bold, color = SecondTextColor, fontSize = 18.sp)
        Text(text = "$${cost}", fontWeight = FontWeight.Bold, color = SecondTextColor, fontSize = 18.sp)
    }
}

@Composable
fun DoctorProfileCard(doctorProfile: DoctorProfile) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .padding(vertical = 28.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(CardColor)
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()
    ) {
        Card(
            modifier = Modifier.size(80.dp),
            shape = CircleShape,
            elevation = 2.dp,
        ) {
            Image(
                painterResource(R.drawable.male_doctor),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize(),
            )
        }
        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.padding(horizontal = 24.dp)
        ) {
            doctorProfile.let {
                Text(
                    text = it.name!!,
                    color = HomeColor,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp
                )

                Text(
                    text = it.speciality!!,
                    color = idk,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
                Text(
                    text = "${it.consultationDuration} hour consultation",
                    color = HomeColor,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(vertical = 6.dp)
                )
            }
        }
    }

}

@Composable
fun AppBar() {
    Box() {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(
                onClick = { Log.i("test", "Clicked") },
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(BackgroundIconColor),
            ) {
                Icon(
                    modifier = Modifier.size(30.dp),
                    painter = painterResource(id = R.drawable.ic_menu_24),
                    contentDescription = "Navigation Menu",
                    tint = IconColor
                )
            }
            Text(
                text = "Appointment",
                color = MainTextColor,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
            )
            IconButton(
                onClick = { Log.i("test", "Clicked") },
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(BackgroundIconColor)
            ) {
                Icon(
                    modifier = Modifier.size(30.dp),
                    painter = painterResource(id = R.drawable.ic_notification_24),
                    contentDescription = "Navigation Menu",
                    tint = IconColor
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FureeTheme {
        // A surface container using the 'background' color from the theme
        HomeScreen()

    }
}
