package com.kotlearn.sharedtopappbar.example2

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kotlearn.sharedtopappbar.CatRepository

@Composable
fun CatDetailScreen(
    id: Int,
    goBack: () -> Unit,
    modifier: Modifier = Modifier,
) {

    val cat = remember { CatRepository.getById(id) }
    var counter by remember { mutableStateOf(0) }

    ProvideAppBarTitle {
        Text(
            text = cat.name
        )
    }

    ProvideAppBarNavigationIcon {
        IconButton(
            onClick = {
                goBack()
            }
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                contentDescription = "Back"
            )
        }
    }

    ProvideAppBarActions {
        IconButton(
            onClick = {
                counter++
            }
        ) {
            Icon(
                imageVector = Icons.Outlined.Add,
                contentDescription = "Add"
            )
        }
    }

    Column(
        modifier = modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = cat.description,
            modifier = Modifier.fillMaxWidth(),
        )
        Text(
            text = "Counter: $counter",
            modifier = Modifier.fillMaxWidth(),
        )
    }

}