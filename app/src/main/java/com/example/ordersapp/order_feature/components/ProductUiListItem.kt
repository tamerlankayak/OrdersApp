package com.example.ordersapp.order_feature.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.RemoveModerator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ordersapp.order_feature.presentation.state.ProductListItem
import com.example.ordersapp.ui.theme.white

@Composable
fun ProductUiListItem(
    productListItem: ProductListItem,
    isExpanded: Boolean,
    onPlusClick: () -> Unit,
    onMinusClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(5.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = productListItem.name,
                    color = white,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "%.2f".format(productListItem.pricePerAmount) + " $",
                    color = white,
                    fontSize = 14.sp
                )
            }
            AnimatedVisibility(productListItem.selectedAmount > 0) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "checkmark",
                        tint = white
                    )
                    Text(text = "${productListItem.selectedAmount} x", color = white)
                }
            }
        }
        AnimatedVisibility(isExpanded) {
            Divider(color = white)
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(25.dp)
            ) {
                IconButton(onClick = {
                    onMinusClick()
                }) {
                    Icon(
                        imageVector = Icons.Default.Remove,
                        contentDescription = "minus",
                        tint = white
                    )
                }

                IconButton(onClick = {
                    onPlusClick()
                }) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "plus",
                        tint = white
                    )
                }
            }
        }
    }
}