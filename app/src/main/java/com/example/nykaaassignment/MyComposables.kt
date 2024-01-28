package com.example.nykaaassignment

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest


@Composable
fun MyCustomImageCard(
    catImage: CatImageResponse,
    modifier: Modifier = Modifier
) {
    Column(modifier) {

        LoadImageFromUrl(catImage.url, modifier = Modifier
            .fillMaxWidth()
            .height(200.dp))


        Spacer(modifier = Modifier.height(12.dp))

        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.White)) {
                    append("The original height and width of image is ")
                }

                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.White)) {
                    append("${catImage.height}x${catImage.width}px")
                }
            })


    }
}

@Composable
fun CatImageList(list: ArrayList<CatImageResponse>){

    LazyColumn (){

        items(list){

            Card (shape = RoundedCornerShape(4.dp),
                modifier = Modifier.padding(16.dp),
                elevation = CardDefaults.cardElevation(4.dp)
            ){
                MyCustomImageCard(catImage = it, modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Gray)
                    .padding(16.dp)
                )
            }

        }
    }
}

@Composable
fun LoadImageFromUrl(imageUrl: String, modifier: Modifier){
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .crossfade(true)
            .build(),
        placeholder = painterResource(R.drawable.ic_launcher_foreground),
        contentDescription = stringResource(R.string.random_cat_image),
        contentScale = ContentScale.Crop,
        modifier = modifier
    )
}

@Composable
fun LoadingProgressBar(){

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(30.dp, 30.dp),
            strokeWidth = 3.dp

        )
    }
}

@Composable
fun ErrorMessegeWithRetry(errorText: String, retry: () -> Unit){

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = errorText, modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.height(16.dp))
        Button(retry) {
            Text(text = "Retry")
        }
    }
}