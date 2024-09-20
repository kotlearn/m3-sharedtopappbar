package com.kotlearn.sharedtopappbar.example1

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kotlearn.sharedtopappbar.CatRepository

@Composable
fun CatDetailScreen(
    id: Int,
    modifier: Modifier = Modifier,
) {

    val cat = remember { CatRepository.getById(id) }

    Column(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = cat.description,
            modifier = Modifier.fillMaxWidth(),
        )
    }

}