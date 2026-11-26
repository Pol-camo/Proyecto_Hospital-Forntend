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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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

@Composable
fun HomeScreen(
    onGoLogin: () -> Unit,
    onGoList: () -> Unit,
    onGoSearch: () -> Unit,
    modifier: Modifier = Modifier
) {
    var clicks by remember { mutableStateOf(0) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.background))
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_home),
                contentDescription = stringResource(id = R.string.common_icon_description),
                tint = colorResource(id = R.color.icon_tint),
                modifier = Modifier.size(36.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = stringResource(id = R.string.home_title),
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.text_primary)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = stringResource(id = R.string.home_subtitle),
            fontSize = 16.sp,
            color = colorResource(id = R.color.text_secondary)
        )

        Spacer(modifier = Modifier.height(28.dp))

        Button(
            onClick = onGoLogin,
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.primary),
                contentColor = colorResource(id = R.color.text_on_primary)
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(id = R.string.home_btn_login))
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = onGoList,
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.primary),
                contentColor = colorResource(id = R.color.text_on_primary)
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_person),
                contentDescription = stringResource(id = R.string.common_icon_description),
                tint = colorResource(id = R.color.text_on_primary),
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = stringResource(id = R.string.home_btn_list))
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = onGoSearch,
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.secondary),
                contentColor = colorResource(id = R.color.text_on_primary)
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = stringResource(id = R.string.common_icon_description),
                tint = colorResource(id = R.color.text_on_primary),
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = stringResource(id = R.string.home_btn_search))
        }

        Spacer(modifier = Modifier.height(24.dp))

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
    }
}

@Preview(showBackground = true, name = "Home Preview")
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        onGoLogin = {},
        onGoList = {},
        onGoSearch = {}
    )
}