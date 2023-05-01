package com.example.ordersapp.order_feature.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.ordersapp.order_feature.components.DelivererUiListItem
import com.example.ordersapp.ui.theme.gray
import com.example.ordersapp.ui.theme.orange
import com.example.ordersapp.ui.theme.white

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun OrderChooseDelivererScreen(
    navController: NavController,
    orderChooseDelivererViewModel: OrderChooseDelivererViewModel = hiltViewModel()
) {

    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Deliverer selection",
                        color = white
                    )
                },
                backgroundColor = orange
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(gray)
                .padding(15.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = orderChooseDelivererViewModel.delivererSearchQuery,
                onValueChange = {
                    orderChooseDelivererViewModel.onSearchQueryChange(it)
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = white,
                    textColor = gray,
                    cursorColor = orange,
                    focusedLabelColor = orange,
                    focusedIndicatorColor = orange
                ),
                label = {
                    Text(text = "Search deliverer")
                },
                maxLines = 1
            )
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier
                    .padding(top = 20.dp)
            ) {
                items(
                    orderChooseDelivererViewModel.delivererToShow,
                    key = { delivererListItem ->
                        delivererListItem.delivererId
                    }
                ) {
                    DelivererUiListItem(
                        it,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .border(1.dp, color = white, RoundedCornerShape(10.dp))
                            .clickable {
                                //
                            }
                            .padding(15.dp)
                    )
                }
            }
        }
    }

}