package com.novatech.zmailclone.components

import androidx.compose.foundation.ScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

@Composable
fun ZmailFab(scrollState: ScrollState) {

    if(scrollState.value > 100){
        ExtendedFloatingActionButton(
            onClick = { /*TODO*/ },
            icon = { Icon(imageVector = Icons.Default.Edit, "")},
            text = { Text(text = "Compose", fontSize = 16.sp) },
        )
    } else{
        FloatingActionButton(onClick = { /*TODO*/ },
            containerColor = MaterialTheme.colorScheme.surface,
        ) {
            Icon(imageVector = Icons.Default.Edit, "")
        }
    }
}