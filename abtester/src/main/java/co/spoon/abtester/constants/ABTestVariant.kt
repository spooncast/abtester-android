package co.spoon.abtester.constants

import androidx.annotation.StringDef

@Retention(AnnotationRetention.SOURCE)
@StringDef(
    ABTestVariant.A,
    ABTestVariant.B,
    ABTestVariant.C,
    ABTestVariant.D,
    ABTestVariant.E,
    ABTestVariant.F
)
annotation class ABTestVariant {
    companion object {
        const val A = "A"
        const val B = "B"
        const val C = "C"
        const val D = "D"
        const val E = "E"
        const val F = "F"

        val values: List<String> by lazy { listOf(A, B, C, D, E, F) }
    }
}