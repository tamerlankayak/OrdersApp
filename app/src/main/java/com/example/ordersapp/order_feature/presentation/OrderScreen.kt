package com.example.ordersapp.order_feature.presentation

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.ordersapp.core.presentation.ScreenRoutes
import com.example.ordersapp.order_feature.components.OrderDetailDialog
import com.example.ordersapp.order_feature.components.OrderUiListItem
import com.example.ordersapp.ui.theme.gray
import com.example.ordersapp.ui.theme.orange
import com.example.ordersapp.ui.theme.white

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun OrderScreen(
    navController: NavController,
    orderViewModel: OrderViewModel = hiltViewModel()
) {

    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(ScreenRoutes.OrderChooseDelivererScreen.route)
                },
                backgroundColor = orange
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "fab_add_order",
                    tint = white
                )
            }
        },
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Order overview",
                        color = white
                    )
                },
                backgroundColor = orange
            )
        }
    ) {
        if (orderViewModel.orderList.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("There are no orders yet")
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(gray)
                    .padding(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(
                    orderViewModel.orderList,
                    key = { orderListItem ->
                        orderListItem.orderId
                    }
                ) {
                    OrderUiListItem(
                        it,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .border(1.dp, color = white, RoundedCornerShape(10.dp))
                            .clickable {
                                orderViewModel.onOrderClick(it.orderId)
                            }
                            .padding(15.dp)
                    )
                }
            }
        }
    }

    if (orderViewModel.isOrderDialogShown && orderViewModel.clickedOrderItem != null) {
        OrderDetailDialog(onDismiss = {
            orderViewModel.onDismissOrderDialog()
        }, orderDetailListItem = orderViewModel.clickedOrderItem!!)
    }
}