package co.spoon.abtester.provider.impl

import android.content.Context
import android.util.Log
import co.spoon.abtester.provider.ABTestProvider
import co.spoon.abtester.constants.ABTestVariant
import com.apptimize.Apptimize
import com.apptimize.ApptimizeOptions
import com.apptimize.ApptimizeTest
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class ApptimizeProvider @Inject constructor(
    @ApplicationContext
    private val appCtx: Context
): ABTestProvider {

    private val abTestMap: MutableMap<String, String> by lazy { mutableMapOf() }

    init {
        val apptimizeOptions = ApptimizeOptions().apply {
            isThirdPartyEventExportingEnabled = true
            isThirdPartyEventImportingEnabled = true
        }
        Apptimize.setup(appCtx, "BuildConfig.APPTIMIZE_KEY", apptimizeOptions)
    }

    override fun setupABTests(abTestNames: List<String>) {
        abTestNames.forEach { abTestName ->
            Apptimize.runTest(abTestName, object : ApptimizeTest() {
                override fun baseline() {
                    set(abTestName, ABTestVariant.A)
                }

                @SuppressWarnings("unused")
                fun variation1() {
                    set(abTestName, ABTestVariant.B)
                }

                @SuppressWarnings("unused")
                fun variation2() {
                    set(abTestName, ABTestVariant.C)
                }

                @SuppressWarnings("unused")
                fun variation3() {
                    set(abTestName, ABTestVariant.D)
                }

                @SuppressWarnings("unused")
                fun variation4() {
                    set(abTestName, ABTestVariant.E)
                }

                @SuppressWarnings("unused")
                fun variation5() {
                    set(abTestName, ABTestVariant.F)
                }
            })
        }
    }

    @ABTestVariant
    override fun get(abTestName: String): String {
        return abTestMap[abTestName] ?: ABTestVariant.A
    }

    override fun set(
        abTestName: String,
        @ABTestVariant variant: String
    ) {
        Log.d(TAG, "set - [$abTestName]: $variant")
        abTestMap[abTestName] = variant
    }

    companion object {
        private const val TAG = "ApptimizeProvider"
    }
}