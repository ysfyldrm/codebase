package com.yy.codebasecase.ui.screens.propertylist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.yy.codebasecase.ui.components.PropertyList
import com.yy.codebasecase.ui.components.SearchBarWithButton
import com.yy.codebasecase.ui.navigation.Screen
import com.yy.codebasecase.ui.screens.PropertySharedViewModel

@Composable
fun PropertyListScreen(
    navController: NavHostController,
    propertyListViewModel: PropertyListViewModel = hiltViewModel(),
    sharedViewModel: PropertySharedViewModel
) {
    val propertiesState by propertyListViewModel.state.collectAsState()

    Scaffold(modifier = Modifier,
        topBar = {
            SearchBarWithButton(
                searchQuery = propertiesState.searchQuery,
                onSearchQueryChanged = propertyListViewModel::onSearchQueryChanged
            )
        },
        containerColor = MaterialTheme.colorScheme.primary,
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .background(
                        color = MaterialTheme.colorScheme.background,
                        shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
                    )
                    .fillMaxSize()
            ) {
                when {
                    propertiesState.isLoading -> {
                        Box(
                            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator()
                        }
                    }

                    propertiesState.error.isNotEmpty() -> {
                        Column {
                            Text(
                                modifier = Modifier
                                    .padding(24.dp)
                                    .align(Alignment.CenterHorizontally),
                                text = propertiesState.error,
                                fontSize = 20.sp,
                                lineHeight = 30.sp,
                                fontWeight = FontWeight(700),
                                color = MaterialTheme.colorScheme.primary,
                                textAlign = TextAlign.Center
                            )
                            Button(modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.CenterHorizontally)
                                .padding(horizontal = 24.dp),
                                onClick = { propertyListViewModel.getProperties() }) {
                                Text(
                                    text = "Tekrar Dene",
                                    fontSize = 20.sp,
                                    lineHeight = 30.sp,
                                    fontWeight = FontWeight(700),
                                    textAlign = TextAlign.Center
                                )
                            }
                        }

                    }

                    else -> {
                        PropertyList(properties = propertiesState.filteredProperties,
                            onPropertyClick = { property ->
                                sharedViewModel.setNavProp(property = property)
                                navController.navigate(
                                    Screen.PropertyDetail.route
                                )
                            })
                    }
                }

            }
        }
    )
}