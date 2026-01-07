package com.apolodevsystem.todoperformance

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.clearText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleSearchBar(
    textFieldState: TextFieldState,
    onSearch: (String) -> Unit,
    searchResults: List<TaskModel>,
    modifier: Modifier = Modifier
) {
    // Controls expansion state of the search bar
    var expanded by rememberSaveable { mutableStateOf(false) }

    Box(
        modifier
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(start = 16.dp, end = 16.dp, bottom = 8.dp, top = 0.dp)
            .fillMaxWidth()
            .semantics { isTraversalGroup = true }
    ) {
        SearchBar(
            modifier = Modifier
                .fillMaxWidth()
                // define altura fixa para evitar espaçamento imprevisível em runtime
                .height(56.dp),
            inputField = {
                SearchBarDefaults.InputField(
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = MaterialTheme.colorScheme.onPrimary,
                        unfocusedContainerColor = MaterialTheme.colorScheme.onPrimary,
                        focusedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
                        unfocusedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
                        cursorColor = MaterialTheme.colorScheme.scrim,
                        focusedPlaceholderColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.6f),
                        unfocusedPlaceholderColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.6f),
                    ),
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Search, "")
                    },
                    trailingIcon = {
                        Icon(imageVector = Icons.Default.Clear, "", modifier = Modifier.clickable {
                            textFieldState.clearText()
                        })
                    },
                    query = textFieldState.text.toString(),
                    onQueryChange = { textFieldState.edit { replace(0, length, it) } },
                    onSearch = {
                        onSearch(textFieldState.text.toString())
                    },
                    expanded = false,
                    onExpandedChange = { expanded = false },
                    placeholder = { Text("Search", color = MaterialTheme.colorScheme.onSurfaceVariant) }
                )
            },
            expanded = expanded,
            onExpandedChange = { expanded = it },
        ) {
            // Display search results in a scrollable column
            /* Column(Modifier.verticalScroll(rememberScrollState())) {
                 searchResults.forEach { result ->
                     ListItem(
                         headlineContent = { Text(result.title) },
                         modifier = Modifier
                             .clickable {
                                 textFieldState.edit { replace(0, length, result.title) }
                                 expanded = false
                             }
                             .fillMaxWidth()
                     )
                 }
             }*/
        }
    }
}