package com.example.frontend_hospital.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.frontend_hospital.R

private data class NurseResult(val name: String, val email: String)

@Composable
fun SearchScreen(
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    var query by remember { mutableStateOf("") }
    var searched by remember { mutableStateOf(false) }
    var selected by remember { mutableStateOf("") }

    // Simulación: el resultado siempre muestra 3 enfermeros (sin conexión al BackEnd)
    val results = remember {
        listOf(
            NurseResult("Laura Martínez", "laura.martinez@hospital.com"),
            NurseResult("Laura Gómez", "laura.gomez@hospital.com"),
            NurseResult("Laura Sánchez", "laura.sanchez@hospital.com")
        )
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.background))
            .padding(20.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = stringResource(id = R.string.common_icon_description),
                tint = colorResource(id = R.color.icon_tint),
                modifier = Modifier.size(36.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = stringResource(id = R.string.search_title),
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.text_primary)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = query,
            onValueChange = { query = it },
            label = { Text(text = stringResource(id = R.string.search_label)) },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = stringResource(id = R.string.common_icon_description),
                    tint = colorResource(id = R.color.icon_tint)
                )
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {
                searched = true
                selected = ""
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.primary),
                contentColor = colorResource(id = R.color.text_on_primary)
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(id = R.string.search_btn))
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (searched) {
            Text(
                text = stringResource(id = R.string.search_results_title, results.size),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.text_primary)
            )

            Spacer(modifier = Modifier.height(8.dp))

            LazyColumn(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(results) { nurse ->
                    NurseResultCard(
                        nurse = nurse,
                        onSelect = { selected = nurse.name }
                    )
                }
            }
        } else {
            Spacer(modifier = Modifier.weight(1f))
        }

        if (selected.isNotEmpty()) {
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = stringResource(id = R.string.search_selected, selected),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.success)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onBack,
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.secondary),
                contentColor = colorResource(id = R.color.text_on_primary)
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(id = R.string.common_back_home))
        }
    }
}

@Composable
private fun NurseResultCard(
    nurse: NurseResult,
    onSelect: () -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.card_background)
        ),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_person),
                    contentDescription = stringResource(id = R.string.common_icon_description),
                    tint = colorResource(id = R.color.icon_tint),
                    modifier = Modifier.size(28.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(
                        text = stringResource(id = R.string.list_nurse_name, nurse.name),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.text_primary)
                    )
                    Text(
                        text = stringResource(id = R.string.list_nurse_email, nurse.email),
                        fontSize = 14.sp,
                        color = colorResource(id = R.color.text_secondary)
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = onSelect,
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.primary),
                    contentColor = colorResource(id = R.color.text_on_primary)
                )
            ) {
                Text(text = stringResource(id = R.string.search_btn_select))
            }
        }
    }
}

@Preview(showBackground = true, name = "Search Preview")
@Composable
fun SearchScreenPreview() {
    SearchScreen(onBack = {})
}