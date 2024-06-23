package com.novatech.zmailclone.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.novatech.zmailclone.model.BottomMenuData

@Composable
fun HomeBottomMenu() {
    val items = listOf(BottomMenuData.Mail, BottomMenuData.Meet)

    NavigationBar(
        containerColor = Color.Gray,
        contentColor = Color.Black
    ) {
        items.forEach {
            NavigationBarItem(
                label = {Text(text = it.title)},
                alwaysShowLabel = true,
                selected = false,
                onClick = {

                },
                icon = { Icon(imageVector = it.icon, contentDescription = it.title) })
        }
    }

}