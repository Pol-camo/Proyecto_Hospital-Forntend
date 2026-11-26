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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.frontend_hospital.R

@Composable
fun LoginScreen(
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    var usuario by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var mensajeValidacion by remember { mutableStateOf("") }
    var esValido by remember { mutableStateOf(false) }

    val textoOk = stringResource(id = R.string.login_message_ok)
    val textoVacio = stringResource(id = R.string.login_message_empty)

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
                painter = painterResource(id = R.drawable.ic_person),
                contentDescription = stringResource(id = R.string.common_icon_description),
                tint = colorResource(id = R.color.icon_tint),
                modifier = Modifier.size(36.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = stringResource(id = R.string.login_title),
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.text_primary)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        TextField(
            value = usuario,
            onValueChange = { usuario = it },
            label = { Text(text = stringResource(id = R.string.login_user_label)) },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_person),
                    contentDescription = stringResource(id = R.string.common_icon_description),
                    tint = colorResource(id = R.color.icon_tint)
                )
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = stringResource(id = R.string.login_password_label)) },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_lock),
                    contentDescription = stringResource(id = R.string.common_icon_description),
                    tint = colorResource(id = R.color.icon_tint)
                )
            },
            visualTransformation = PasswordVisualTransformation(),
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                if (usuario.isNotBlank() && password.isNotBlank()) {
                    esValido = true
                    mensajeValidacion = textoOk
                } else {
                    esValido = false
                    mensajeValidacion = textoVacio
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.primary),
                contentColor = colorResource(id = R.color.text_on_primary)
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(id = R.string.login_btn_validate))
        }

        if (mensajeValidacion.isNotEmpty()) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = mensajeValidacion,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = if (esValido) {
                    colorResource(id = R.color.success)
                } else {
                    colorResource(id = R.color.error)
                }
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

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

@Preview(showBackground = true, name = "Login Preview")
@Composable
fun LoginScreenPreview() {
    LoginScreen(onBack = {})
}