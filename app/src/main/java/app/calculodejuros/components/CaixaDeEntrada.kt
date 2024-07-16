package app.calculodejuros.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun CaixaDeEntrada(
    label: String,
    placeHolder: String,
    value: String,
    keyboardType: KeyboardType,
    modifier: Modifier,
    //Estou dizendo que o atualizarvalor retorna uma função que retorna nada (Unit)
    atualizarValor: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = atualizarValor,
        //Esse modifier está recebendo o modifier do parametro
        modifier = modifier,
        label = {
            Text(text = label)
        },
        placeholder = {
            Text(text = placeHolder)
        },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType)
    )
}