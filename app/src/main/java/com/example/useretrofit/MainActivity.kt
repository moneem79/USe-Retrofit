package com.example.useretrofit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.useretrofit.models.PostResponseItem
import com.example.useretrofit.ui.theme.USeRetrofitTheme




private val apiServices:ApiServices by lazy { RetrofitInstance.getApiService() }

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            USeRetrofitTheme {
                var posts by remember { mutableStateOf<List<PostResponseItem>>(emptyList()) }
                LaunchedEffect(Unit) {
                  posts=  apiServices.getPosts()

                }
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    LazyColumn (modifier = Modifier.fillMaxSize()
                        .padding(innerPadding)
                        .fillMaxSize()){
                        items (posts){
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp),
                                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
                            ) {
                                Column(modifier = Modifier.padding(16.dp)) {
                                 Text(it.userId.toString())
                                 Text(it.title.toString())
                                 Text(it.body.toString())


                                }
                            }
                        }

                        }
                    }

                }
            }
        }
    }

