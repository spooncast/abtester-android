package co.spoon.abtesterdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import co.spoon.abtester.ABTester
import co.spoon.abtester.constants.ABTestVariant
import co.spoon.abtester.provider.ApptimizeConfig
import co.spoon.abtesterdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupABTest()
    }

    private fun setupABTest() {
        val abTester = ABTester.Builder(ApptimizeConfig(this, "")).build()
        abTester.setupABTests(listOf())
        when (abTester.get("")) {
            ABTestVariant.B -> {}
            ABTestVariant.C -> {}
            ABTestVariant.D -> {}
            else -> {}
        }
    }

}