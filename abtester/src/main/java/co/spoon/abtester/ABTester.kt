package co.spoon.abtester

import co.spoon.abtester.constants.ABTestVariant

interface ABTester {

    fun setupABTests(abTestNames: List<String>)

    @ABTestVariant
    fun get(abTestName: String): String

    fun set(
        abTestName: String,
        @ABTestVariant variant: String
    )

}