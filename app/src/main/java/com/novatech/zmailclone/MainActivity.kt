package com.novatech.zmailclone

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.novatech.zmailclone.components.HomeAppBar
import com.novatech.zmailclone.components.HomeBottomMenu
import com.novatech.zmailclone.components.MailList
import com.novatech.zmailclone.components.ZmailDrawerMenu
import com.novatech.zmailclone.ui.theme.ZmailCloneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ZmailCloneTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ZmailApp()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ZmailApp() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    val scrollState = rememberScrollState()
    val bottomBarState = rememberSaveable { (mutableStateOf(true)) }
//    val navController = rememberNavController()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ZmailDrawerMenu(scrollState)
        },
    ) {
        Scaffold(
            topBar = { HomeAppBar(drawerState, coroutineScope) },
            bottomBar = {
                HomeBottomMenu(
//                    navController = navController,
//                    bottomBarState = bottomBarState
                )
            }
            ) {
            MailList(paddingValues = it)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ZmailCloneTheme {
        ZmailApp()
    }
}

