package co.spoon.abtester.provider

import co.spoon.abtester.constants.ABTestVariant

internal interface ABTestProvider {

    fun setupABTests(abTestNames: List<String>)

    @ABTestVariant
    fun get(abTestName: String): String

    fun set(
        abTestName: String,
        @ABTestVariant variant: String
    )
}