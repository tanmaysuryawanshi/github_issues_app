package com.tanmaysuryawanshi.githubapp.featureIssues.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.tanmaysuryawanshi.githubapp.ui.theme.GithubappTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GithubappTheme {
                val viewmodel:IssueInfoViewModel= hiltViewModel()
                val state=viewmodel.state.value
                val snackbarHostState = remember { SnackbarHostState() }
                LaunchedEffect(key1 = true) {
                    viewmodel.eventFlow.collectLatest { event ->
                        when (event) {

                            is IssueInfoViewModel.UIEvent.ShowSnackbar -> {
                                snackbarHostState.showSnackbar(
                                    message = event.message
                                )
                            }
                        }
                    }
                }


                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {



                    LazyColumn(modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                        , horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        item {
                            Text(text = "Langchain Issues",
                                textAlign = TextAlign.Center,
                                fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight.Bold,
                                fontSize = 28.sp,
                                modifier = Modifier.fillMaxWidth(),
                                color = Color(0xFFFF6500)
                            )
                        }
                        item{ Spacer(modifier = Modifier.padding(0.dp, 8.dp)) }
                        item {
                            Text(text ="Discover Closed Issues",
                                fontFamily = FontFamily.SansSerif,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF444652)
                                ,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                        item{ Spacer(modifier = Modifier.padding(0.dp, 4.dp)) }
                        item {
                            Text(text ="Search all closed Issues in the repo without any issue",
                                fontFamily = FontFamily.SansSerif,
                                fontSize = 16.sp,
                                color = Color(0xFF74757f),
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth()


                            )
                        }
                        item{ Spacer(modifier = Modifier.padding(0.dp, 8.dp)) }
                        item {
                            TextField(
                                modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(16.dp)),
                                placeholder = { Text(text = "Search ... ")},
                                value = viewmodel.searchQuery.value,
                                onValueChange =  viewmodel::onSearch,
                                leadingIcon = {
                                  Icon(Icons.Default.Search,"", tint = Color.Black)
                                }
                            , colors = TextFieldDefaults.textFieldColors(
                                    textColor = Color(0xFF444652),
                                    placeholderColor = Color(0xFF2C2626),
                                    disabledTextColor = Color.Transparent,
                                    containerColor = Color(0xFFF1F1F8),
                                    focusedIndicatorColor = Color.Transparent,
                                    unfocusedIndicatorColor = Color.Transparent,
                                    disabledIndicatorColor = Color.Transparent
                            )
                            )

                        }

                        items(state.issueInfoItems.size){
                                i->
                            val issueInfo=state.issueInfoItems[i]
                            if (i>0){
                                Spacer(modifier = Modifier.height(16.dp))
                                IssueInfoItem(item=issueInfo)


                            }
                        }
                    }

                }
            }
        }
    }
}

