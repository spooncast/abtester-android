package co.spoon.abtester

import co.spoon.abtester.constants.ABTestVariant
import co.spoon.abtester.provider.ABTestConfig
import co.spoon.abtester.provider.ABTestProvider
import co.spoon.abtester.provider.ApptimizeConfig
import co.spoon.abtester.provider.impl.ApptimizeProvider

class ABTester private constructor(
    private val provider: ABTestProvider,
) {

    fun setupABTests(abTestNames: List<String>) {
        provider.setupABTests(abTestNames)
    }

    @ABTestVariant
    fun get(abTestName: String): String {
        return provider.get(abTestName)
    }

    /**
     * Only for Manual test
     */
    fun set(
        abTestName: String,
        @ABTestVariant variant: String,
    ) {
        provider.set(abTestName, variant)
    }

    class Builder(
        private val config: ABTestConfig,
    ) {

        fun build(): ABTester {
            return if (config is ApptimizeConfig) {
                ABTester(ApptimizeProvider(config))
            } else {
                throw IllegalArgumentException("invalid config")
            }
        }
    }
}