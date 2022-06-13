package co.spoon.abtester.impl

import co.spoon.abtester.ABTester
import co.spoon.abtester.constants.ABTestVariant
import co.spoon.abtester.provider.ABTestProvider
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class ABTesterImpl @Inject constructor(
    private val provider: ABTestProvider
): ABTester {

    override fun setupABTests(abTestNames: List<String>) {
        provider.setupABTests(abTestNames)
    }

    @ABTestVariant
    override fun get(abTestName: String): String {
        return provider.get(abTestName)
    }

    override fun set(
        abTestName: String,
        @ABTestVariant variant: String
    ) {
        provider.set(abTestName, variant)
    }

}