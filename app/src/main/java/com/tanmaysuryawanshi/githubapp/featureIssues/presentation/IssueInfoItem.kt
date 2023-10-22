package com.tanmaysuryawanshi.githubapp.featureIssues.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.tanmaysuryawanshi.githubapp.featureIssues.data.util.convertDateString
import com.tanmaysuryawanshi.githubapp.featureIssues.data.util.convertHexColor
import com.tanmaysuryawanshi.githubapp.featureIssues.domain.model.githubItem

@Composable
fun IssueInfoItem(item: githubItem) {

    Card(modifier = Modifier

        .fillMaxWidth()
        .border(
            1.dp,
            color = Color(0xFFE9E9E9),
            shape = RoundedCornerShape(16.dp)
        )
        .clip(RoundedCornerShape(16.dp))


  ,
colors = CardDefaults.cardColors(containerColor = Color.White),
elevation = CardDefaults.elevatedCardElevation(100.dp)) {

    Column(
        Modifier
            .padding(16.dp)
            .fillMaxWidth()) {
        Text(text =item.title,
            fontFamily = FontFamily.SansSerif,
            fontSize = 22.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF444652)
            ,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .fillMaxWidth()

        )
Spacer(modifier = Modifier.height(8.dp))
Row(modifier = Modifier
    .fillMaxWidth()
    .padding(horizontal = 8.dp),
verticalAlignment = Alignment.CenterVertically) {
    AsyncImage(
        model = item.user.avatar_url,
        contentDescription = null,
        modifier = Modifier
            .border(BorderStroke(width = 2.dp, color = Color.LightGray), shape = CircleShape)
            .padding(2.dp)
            .size(40.dp)
            .clip(CircleShape)
    )
    Spacer(modifier = Modifier.width(8.dp))
    Column(verticalArrangement = Arrangement.Center) {
        Text(text =item.user.login,
            fontFamily = FontFamily.SansSerif,
            fontSize = 16.sp,
            color = Color(0xFF74757f),
            textAlign = TextAlign.Start,
            modifier = Modifier.fillMaxWidth()
        )
        Text(text = convertDateString(item.closed_at) ,
            fontFamily = FontFamily.SansSerif,
            fontSize = 12.sp,
            color = Color(0xFF74757f),
            textAlign = TextAlign.Start,
            modifier = Modifier.fillMaxWidth(),
            fontWeight = FontWeight.Light


        )
    }
}
        Spacer(modifier = Modifier.height(8.dp))

        LazyRow(modifier = Modifier.fillMaxWidth()){
            items(item.labels){
                Box(modifier = Modifier
                    .clip(shape = RoundedCornerShape(8.dp))
                    .background(Color(convertHexColor(it.color)))){
                    Text(text = it.name,
                        modifier = Modifier
                            .padding(4.dp),
                    color = Color.White)
                }
                Spacer(modifier = Modifier.width(8.dp))
            }

        }
    }

}
}

