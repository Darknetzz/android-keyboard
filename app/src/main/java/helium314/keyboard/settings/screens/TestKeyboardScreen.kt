// SPDX-License-Identifier: GPL-3.0-only
package helium314.keyboard.settings.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import helium314.keyboard.latin.R
import helium314.keyboard.latin.utils.Theme
import helium314.keyboard.latin.utils.previewDark
import helium314.keyboard.settings.SearchSettingsScreen
import helium314.keyboard.settings.initPreview

/** Scratch pad with a few field types to try the keyboard without leaving the settings. */
@Composable
fun TestKeyboardScreen(onClickBack: () -> Unit) {
    SearchSettingsScreen(
        onClickBack = onClickBack,
        title = stringResource(R.string.settings_screen_test_keyboard),
        settings = emptyList(),
    ) {
        var text by rememberSaveable { mutableStateOf("") }
        var email by rememberSaveable { mutableStateOf("") }
        var number by rememberSaveable { mutableStateOf("") }
        var password by rememberSaveable { mutableStateOf("") }
        val fieldModifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp)
        Column(Modifier.verticalScroll(rememberScrollState())) {
            Text(stringResource(R.string.test_keyboard_hint), Modifier.padding(16.dp))
            OutlinedTextField(
                value = text, onValueChange = { text = it }, modifier = fieldModifier, minLines = 3,
                label = { Text(stringResource(R.string.test_keyboard_text)) },
            )
            OutlinedTextField(
                value = email, onValueChange = { email = it }, modifier = fieldModifier, singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                label = { Text(stringResource(R.string.test_keyboard_email)) },
            )
            OutlinedTextField(
                value = number, onValueChange = { number = it }, modifier = fieldModifier, singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                label = { Text(stringResource(R.string.test_keyboard_number)) },
            )
            OutlinedTextField(
                value = password, onValueChange = { password = it }, modifier = fieldModifier, singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                label = { Text(stringResource(R.string.test_keyboard_password)) },
            )
        }
    }
}

@Preview
@Composable
private fun PreviewScreen() {
    initPreview(LocalContext.current)
    Theme(previewDark) {
        Surface {
            TestKeyboardScreen { }
        }
    }
}
