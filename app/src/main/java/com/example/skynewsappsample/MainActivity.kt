package com.example.skynewsappsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.android.TextLayout
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.skynewsappsample.ui.theme.SkyNewsAppSampleTheme
import com.example.skynewsappsample.ui.theme.VideoList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SkyNewsAppSampleTheme {
                // A surface container using the 'background' color from the theme
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Greeting(
                        VideoList(
                            "57m ago",
                            "Nicola Bulley: Two watchdogs clear Lancashire Police of misconduct over case",
                            "01:16",
                            R.drawable.ca
                        )
                    )



//                    NewsView(
//                        VideoList(
//                            "57m ago",
//                            "Nicola Bulley: Two watchdogs clear Lancashire Police of misconduct over case",
//                            "01:16",
//                            R.drawable.backgr
//                        )
//                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(videoList: VideoList, modifier: Modifier = Modifier) {


    Card(
        modifier = Modifier.aspectRatio(16f / 9f),
        shape = RoundedCornerShape(15.dp),
    ) {
        Box(modifier = Modifier.height(200.dp)) {
            Image(
                painter = painterResource(id = videoList.picture),
                contentDescription = "",
                contentScale = ContentScale.Crop
            )

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.padding(bottom = 5.dp, start = 5.dp)
            ) {

                Column(
                    modifier = Modifier
                        .weight(0.85f)
                        .padding(end = 5.dp).align(Alignment.Bottom)
                ) {

                    Row() {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_play_circle_outline_24),
                            contentDescription = "",
                            modifier = Modifier
                                .padding(4.dp)
                                .size(70.dp)
                        )

                    }


                    Row() {

                        //  Box(modifier = Modifier.fillMaxSize(0.5f)) {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_access_time_24),
                            contentDescription = ""
                        )

                        Text(
                            text = videoList.timeHistory,
                            modifier = Modifier.padding(5.dp),
                            style = TextStyle(color = Color.Black, fontSize = 12.sp)
                        )

                        //       }


                    }

                    Row(
                    ) {
                        Text(

                            text = videoList.newsHeading,
                            textAlign = TextAlign.Left,
                            maxLines = 3,
                            modifier = Modifier
                                // .height(150.dp)
                                .wrapContentHeight(Alignment.Bottom),


                            overflow = TextOverflow.Ellipsis,
                            style = TextStyle(
                                fontStyle = FontStyle(3),
                            )
                        )

                    }
                }
                Column(
                    modifier = Modifier
                        .weight(0.20f)
                        .fillMaxHeight()
                        .padding(4.dp),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Text(

                        text = videoList.duration,
                        fontStyle = FontStyle.Normal,
                        textAlign = TextAlign.End,
                        color = Color.White,
                        modifier = Modifier
                            .background(Color.Black)


                    )
                }
            }
        }
    }
//    Row(
//        horizontalArrangement = Arrangement.Center,
//        verticalAlignment = Alignment.CenterVertically,
//    ) {
//        Box(modifier.background(Color.Black)) {
//        }
//
//    }
}


@Composable
fun NewsView(videoList: VideoList, modifier: Modifier = Modifier) {

    Card(modifier = Modifier.fillMaxWidth()) {
        Box(modifier = Modifier.height(200.dp)) {
            Image(
                painter = painterResource(id = videoList.picture),
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
            Image(
                painter = painterResource(id = R.drawable.baseline_play_circle_outline_24),
                contentDescription = "",
                alignment = Alignment.BottomStart
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SkyNewsAppSampleTheme {


        Greeting(
            VideoList(
                "57m ago",
                "Nicola Bulley: Two watchdogs clear Lancashire Police of misconduct over case",
                "01:16",
                R.drawable.ca
            )
        )
    }
}