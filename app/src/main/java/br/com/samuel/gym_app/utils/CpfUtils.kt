package br.com.samuel.gym_app.utils

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

/**
 * Uma [VisualTransformation] que formata o texto de entrada para corresponder ao padrão de CPF (XXX.XXX.XXX-XX).
 */
class CpfVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        //XXX.XXX.XXX-XX
        val maskCpf = text.text.mapIndexed { index, c ->
            when (index) {
                2 -> "$c."
                5 -> "$c."
                8 -> "$c-"
                else -> c
            }
        }.joinToString(separator = "")

        return TransformedText(
            AnnotatedString(maskCpf),
            CpfOffsetMapping
        )
    }

}
/**
 * Um [OffsetMapping] para lidar com as mudanças de offset introduzidas por [CpfVisualTransformation].
 */
object CpfOffsetMapping : OffsetMapping {
    override fun originalToTransformed(offset: Int): Int {
        return when {
            offset > 8 -> offset + 3
            offset > 5 -> offset + 2
            offset > 2 -> offset + 1

            else -> offset
        }

    }

    override fun transformedToOriginal(offset: Int): Int {
        return when {
            offset > 8 -> offset - 3
            offset > 5 -> offset - 2
            offset > 2 -> offset - 1
            else -> offset
        }
    }

}