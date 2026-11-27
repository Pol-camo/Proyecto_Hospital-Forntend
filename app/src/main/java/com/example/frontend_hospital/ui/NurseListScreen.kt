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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.frontend_hospital.R

private data class Nurse(val name: String, val email: String)

@Composable
fun NurseListScreen(
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val nurses = remember {
        listOf(
            Nurse("Laura Martínez", "laura.martinez@hospital.com"),
            Nurse("Carlos Pérez", "carlos.perez@hospital.com"),
            Nurse("Ana García", "ana.garcia@hospital.com"),
            Nurse("Marta López", "marta.lopez@hospital.com"),
            Nurse("Jordi Serra", "jordi.serra@hospital.com"),
            Nurse("Elena Ruiz", "elena.ruiz@hospital.com")
        )
    }
    var clicks by remember { mutableStateOf(0) }
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
                painter = painterResource(id = R.drawable.ic_person),
                contentDescription = stringResource(id = R.string.common_icon_description),
                tint = colorResource(id = R.color.icon_tint),
                modifier = Modifier.size(36.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = stringResource(id = R.string.list_title),
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.text_primary)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(nurses) { nurse ->
                NurseCard(nurse = nurse)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(id = R.string.home_clicks, clicks),
            fontSize = 16.sp,
            color = colorResource(id = R.color.text_primary)
        )

        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = { clicks = clicks + 1 },
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.primary_dark),
                contentColor = colorResource(id = R.color.text_on_primary)
            )
        ) {
            Text(text = stringResource(id = R.string.home_btn_click))
        }
        Spacer(modifier = Modifier.height(12.dp))
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
private fun NurseCard(nurse: Nurse) {
    var expanded by remember { mutableStateOf(false) }

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
                Text(
                    text = stringResource(id = R.string.list_nurse_name, nurse.name),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.text_primary)
                )
            }

            if (expanded) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = stringResource(id = R.string.list_nurse_email, nurse.email),
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.text_secondary)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = { expanded = !expanded },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.primary),
                    contentColor = colorResource(id = R.color.text_on_primary)
                )
            ) {
                Text(
                    text = stringResource(
                        id = if (expanded) R.string.list_btn_collapse else R.string.list_btn_expand
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true, name = "Nurse List Preview")
@Composable
fun NurseListScreenPreview() {
    NurseListScreen(onBack = {})
}
