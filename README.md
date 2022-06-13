# ABTester
Simple ABTest

# Download
### Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:
```
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```
### Step 2. Add the dependency
```
dependencies {
  implementation 'com.github.spooncast:abtester-android:release-0.0.1'
}
```

# How to use
## 1. get ABTester object
```kotlin
val abTestConfig = ApptimizeConfig(applicationContext, APPTIMIZE_KEY)
val abTester = ABTester.Builder(abTestConfig).build()
```

## 2. setup AB Tests
```kotlin
abTester.setupABTests(
  listOf(
    "TEST_1",
    "TEST_2",
    "TEST_3",
    ,
    ...
  )
)
```

## 3. get variant
```kotlin
val variant = abTester.get("TEST_1")
when (abTester.get("")) {
  ABTestVariant.B -> {}
  ABTestVariant.C -> {}
  ABTestVariant.D -> {}
  else -> {}
}
```
