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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PriceCheck
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.ordersapp.order_feature.components.ProductUiListItem
import com.example.ordersapp.ui.theme.gray
import com.example.ordersapp.ui.theme.orange
import com.example.ordersapp.ui.theme.white

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun OrderChooseProductScreen(
    navController: NavController,
    delivererId: String?,
    orderChooseProductsViewModel: OrderChooseProductsViewModel = hiltViewModel()
) {

    LaunchedEffect(key1 = true) {
        if (delivererId != null) {
            orderChooseProductsViewModel.initProductList(delivererId)
        }
    }

    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Product Section", color = white)
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    orderChooseProductsViewModel.onCheckoutClick()
                },
                backgroundColor = orange
            ) {
                Icon(
                    imageVector = Icons.Default.PriceCheck,
                    contentDescription = "fab_money",
                    tint = white,
                    modifier = Modifier
                        .size(32.dp)
                )
            }
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
                value = orderChooseProductsViewModel.productSearchQuery,
                onValueChange = {
                    orderChooseProductsViewModel.onProductSearchQueryChange(it)
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = white,
                    textColor = gray,
                    cursorColor = orange,
                    focusedLabelColor = orange,
                    focusedIndicatorColor = orange
                ),
                label = {
                    Text(text = "Search Product")
                },
                maxLines = 1
            )
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier
                    .padding(top = 20.dp)
            ) {
                items(
                    orderChooseProductsViewModel.productsToShow,
                    key = { productListItem ->
                        productListItem.id
                    }
                ) {
                    ProductUiListItem(
                        productListItem = it,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .border(1.dp, color = white, RoundedCornerShape(10.dp))
                            .clickable {
                                orderChooseProductsViewModel.onListItemClick(it.id)
                            }
                            .padding(10.dp),
                        isExpanded = it.isExpanded,
                        onMinusClick = {
                            orderChooseProductsViewModel.onMinusClick(it.id)
                        },
                        onPlusClick = {
                            orderChooseProductsViewModel.onPlusClick(it.id)
                        }
                    )
                }
            }
        }
    }
}