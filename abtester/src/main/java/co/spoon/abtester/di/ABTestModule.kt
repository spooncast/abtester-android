package co.spoon.abtester.di

import co.spoon.abtester.provider.ABTestProvider
import co.spoon.abtester.provider.impl.ApptimizeProvider
import co.spoon.abtester.ABTester
import co.spoon.abtester.impl.ABTesterImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class ABTestModule {
    @Singleton
    @Binds
    internal abstract fun bindABTester(manager: ABTesterImpl): ABTester

    @Singleton
    @Binds
    internal abstract fun bindABTestProvider(abTester: ApptimizeProvider): ABTestProvider
}