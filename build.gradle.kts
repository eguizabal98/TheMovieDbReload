// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.hilt) apply false
    // linter
    alias(libs.plugins.detekt)
    alias(libs.plugins.gradleKtlint)
}

subprojects {
    apply {
        plugin("io.gitlab.arturbosch.detekt")
        plugin("org.jlleitschuh.gradle.ktlint") // Version should be inherited from parent
    }
    detekt {
        config.setFrom(rootProject.files("detekt.yml"))
    }
    tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
        reports {
            parallel = true
            xml.required.set(false)
            txt.required.set(false)
            sarif.required.set(false)
            md.required.set(false)
            html.required.set(true) // observe findings in your browser with structure and code snippets
        }
    }

    configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
        android.set(false)
        debug.set(false)
        ignoreFailures.set(false)
        outputToConsole.set(true)
        verbose.set(true)
        version.set(rootProject.libs.versions.ktlint.get())
        filter {
            exclude("**/generated/**")
            include("**/kotlin/**")
        }
    }
}