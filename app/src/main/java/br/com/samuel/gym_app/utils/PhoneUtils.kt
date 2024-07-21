package br.com.samuel.gym_app.utils

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

/**
 * Uma [VisualTransformation] que formata o texto de entrada para corresponder ao padrão de telefone (XX) XXXXX-XXXX).
 */
class PhoneVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        //(XX) XXXXX-XXXX
        val maskCpf = text.text.mapIndexed { index, c ->
            when (index) {
                0 -> "($c"
                1 -> "$c) "
                6 -> "$c-"
                else -> c
            }
        }.joinToString(separator = "")

        return TransformedText(
            AnnotatedString(maskCpf),
            PhoneOffsetMapping
        )
    }

}
/**
 * Um [OffsetMapping] para lidar com as mudanças de offset introduzidas por [PhoneVisualTransformation].
 */
object PhoneOffsetMapping : OffsetMapping {
    override fun originalToTransformed(offset: Int): Int {
        return when {
            offset > 6 -> offset + 4
            offset > 1 -> offset + 3
            offset > 0 -> offset + 1

            else -> offset
        }

    }

    override fun transformedToOriginal(offset: Int): Int {
        return when {
            offset >= 11 -> offset - 4
            offset >= 5 -> offset - 3
            offset == 4 -> offset - 2
            offset >= 2 -> offset - 1
            else -> offset
        }
    }

}