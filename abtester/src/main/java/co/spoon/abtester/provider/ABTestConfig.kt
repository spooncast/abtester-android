package co.spoon.abtester.provider

import android.content.Context

interface ABTestConfig

class ApptimizeConfig(
    val appCtx: Context,
    val apptimizeKey: String
): ABTestConfig