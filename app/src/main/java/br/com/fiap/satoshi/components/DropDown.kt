package br.com.fiap.satoshi.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import br.com.fiap.satoshi.R

class DropDown {

    companion object {

        @OptIn(ExperimentalMaterial3Api::class)
        @Composable
        fun DropDownList(modifier: Modifier = Modifier) {
            val options = listOf("Opção 1", "Opção 2", "Opção 3")
            var expanded by remember { mutableStateOf(false) }
            var selectedOption by remember { mutableStateOf(options[0]) }

            ExposedDropdownMenuBox (
                expanded = expanded,
                onExpandedChange = { expanded = !expanded }
            ) {
                TextField(
                    value = selectedOption,
                    onValueChange = {},
                    readOnly = true,
                    modifier = Modifier.menuAnchor(),
                    label = { Text("Selecione uma opção") },
                    trailingIcon = {
                        Image(
                            painter = painterResource(R.drawable.down_arrow),
                            contentDescription = "Search Icon",
                            modifier = Modifier.clickable { }
                        )
                    }
                )

                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    options.forEach { option ->
                        DropdownMenuItem(
                            text = { Text(option) },
                            onClick = {
                                selectedOption = option
                                expanded = false
                            }
                        )
                    }
                }
            }
        }
    }
}