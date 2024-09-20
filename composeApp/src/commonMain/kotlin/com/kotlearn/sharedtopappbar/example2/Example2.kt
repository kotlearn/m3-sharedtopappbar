package com.kotlearn.sharedtopappbar.example2

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.kotlearn.sharedtopappbar.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Example2() {

    val navController = rememberNavController()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    Scaffold(
        topBar = {
            ContentAwareTopAppBar(
                navController = navController,
                scrollBehavior = scrollBehavior,
            )
        },
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection)
    ) { innerPadding ->

        NavHost(
            startDestination = Screen.CatList,
            navController = navController,
        ) {

            composable<Screen.CatList> {
                CatListScreen(
                    goToDetail = { id ->
                        navController.navigate(Screen.CatDetail(id = id))
                    },
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                )
            }

            composable<Screen.CatDetail> {
                val args = it.toRoute<Screen.CatDetail>()
                CatDetailScreen(
                    id = args.id,
                    goBack = navController::popBackStack,
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                )
            }

        }

    }

}