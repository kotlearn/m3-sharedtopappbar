package com.kotlearn.sharedtopappbar.example1

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.kotlearn.sharedtopappbar.CatRepository
import com.kotlearn.sharedtopappbar.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Example1() {

    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    Scaffold(
        topBar = {
            LargeTopAppBar(
                title = {
                    Text(
                        text = getTopAppBarTitle(backStackEntry)
                    )
                },
                navigationIcon = {
                    if (backStackEntry?.destination?.hasRoute<Screen.CatList>() != true) {
                        IconButton(
                            onClick = {
                                navController.popBackStack()
                            }
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    }
                },
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
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                )
            }

        }

    }

}

private fun getTopAppBarTitle(entry: NavBackStackEntry?): String {
    val destination = entry?.destination
    return when {
        destination == null -> ""
        destination.hasRoute<Screen.CatList>() -> "Cats"
        destination.hasRoute<Screen.CatDetail>() -> {
            val args = entry.toRoute<Screen.CatDetail>()
            val cat = CatRepository.getById(args.id)
            cat.name
        }
        else -> ""
    }
}




