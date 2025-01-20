package com.nikhilproject.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar(
    userQuery: String,
    onSearchTextInput: (String) -> Unit
) {
    val keyboardManager = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    val textColor = MaterialTheme.colorScheme.onSurface
    val iconTint = MaterialTheme.colorScheme.primary.copy(alpha = 0.7f)
    val placeholderColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 4.dp, end = 4.dp, top = 2.dp, bottom = 2.dp)
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    focusManager.clearFocus()
                    keyboardManager?.hide()
                })
            }
    ) {
        OutlinedTextField(
            value = userQuery,
            textStyle = MaterialTheme.typography.titleMedium.copy(color = textColor),
            onValueChange = { text ->
                onSearchTextInput(text)
            },
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(25.dp),
            placeholder = {
                Text(
                    text = "Search...",
                    style = MaterialTheme.typography.labelLarge.copy(
                        fontWeight = FontWeight.Normal,
                        color = placeholderColor,
                    ),
                    maxLines = 1
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon",
                    tint = iconTint
                )
            },
            trailingIcon = {
                if (userQuery.isNotEmpty()) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = "Clear Input",
                        modifier = Modifier
                            .clickable {
                                onSearchTextInput("")
                                keyboardManager?.hide()
                                focusManager.clearFocus()

                            },
                        tint = iconTint
                    )
                }
            },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(
                onSearch = {
                    keyboardManager?.hide()
                    onSearchTextInput(userQuery.lowercase().trim())
                    focusManager.clearFocus()
                }
            ),
            maxLines = 1,
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color.LightGray,
                focusedBorderColor = Color.LightGray,
                cursorColor = if (isSystemInDarkTheme()) Color.White else Color.DarkGray
            )
        )
    }
}


@Preview
@Composable
fun PreviewSearchBar() {
    SearchBar(
        userQuery = "Search...",
        onSearchTextInput = {}
    )
}