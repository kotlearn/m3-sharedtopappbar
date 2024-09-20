package com.kotlearn.sharedtopappbar.example1

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kotlearn.sharedtopappbar.CatRepository

@Composable
fun CatListScreen(
    goToDetail: (id: Int) -> Unit,
    modifier: Modifier = Modifier,
) {

    val cats = remember { CatRepository.cats }

    LazyColumn(
        modifier = modifier,
    ) {
        items(cats) { cat ->
            Text(
                text = cat.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        goToDetail(cat.id)
                    }
                    .padding(16.dp)
            )
        }
    }

}