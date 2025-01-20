package com.nikhilproject.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nikhilproject.presentation.R
import com.nikhilproject.presentation.utils.BottomSheetFormatter.formatBottomSheetItem
import com.nikhilproject.presentation.utils.BottomSheetDetails

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(
    bottomSheetDetails: BottomSheetDetails,
    onDismiss: () -> Unit,
    modalBottomSheetState: SheetState,
) {

    val characters by remember {
        mutableStateOf(bottomSheetDetails.characterOccurrences.entries.toList())
    }

    ModalBottomSheet(
        modifier = Modifier.fillMaxSize(),
        onDismissRequest = { onDismiss() },
        sheetState = modalBottomSheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() },
        containerColor = Color.White
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(id = R.string.rewards_count),
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Text(
                    text = bottomSheetDetails.itemCount.toString(),
                    fontSize = 18.sp,
                    color = Color.Black
                )
            }

            Text(
                modifier = Modifier
                    .padding(top = 8.dp),
                text = stringResource(id = R.string.top_three_characters),
                fontSize = 18.sp,
                color = Color.Black
            )

            Column(modifier = Modifier) {
                repeat(characters.size) { index ->
                    Row(Modifier) {
                        Text(
                            text = characters[index].key.formatBottomSheetItem(),
                            fontSize = 16.sp,
                            color = Color.Black
                        )
                        Text(
                            text = characters[index].value.toString(),
                            fontSize = 16.sp,
                            color = Color.Black
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PreviewBottomSheet() {
    BottomSheet(
        bottomSheetDetails = BottomSheetDetails(
            2,
            characterOccurrences = mapOf('k' to 10, 'r' to 4)
        ),
        onDismiss = { },
        modalBottomSheetState = rememberModalBottomSheetState()
    )
}
