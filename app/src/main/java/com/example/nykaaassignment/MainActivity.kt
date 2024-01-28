package com.example.nykaaassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nykaaassignment.ui.theme.NykaaAssignmentTheme
import org.koin.androidx.compose.koinViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

//    val viewwModel: CatImageViewModel by viewModel<CatImageViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NykaaAssignmentTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NewScreen()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NykaaAssignmentTheme {
        Greeting("Android")
    }
}

@Composable
fun NewScreen(
    viewsModel: CatImageViewModel = koinViewModel()
) {

    val state = viewsModel.catImageDataState.observeAsState()

    var initialApiCalled by rememberSaveable { mutableStateOf(false) }

    if(!initialApiCalled) {
        LaunchedEffect(key1 = Unit, block = {

            viewsModel.getCatImages()
            initialApiCalled = true
        })
    }


    when (state.value) {
        is CatResponseState.Loading -> {
            LoadingProgressBar()

        }
        is CatResponseState.Success -> {
            CatImageList((state.value as CatResponseState.Success).catImages)
        }
        is CatResponseState.Error -> {
            Text(text = (state.value as CatResponseState.Error).errorDetails)
        }

        else -> {
            LoadingProgressBar()
        }
    }

}

