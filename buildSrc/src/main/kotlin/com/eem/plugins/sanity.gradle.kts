package com.eem.plugins

val sanityTask = "sanityProject"

/**
 * Custom task "sanityProject" that performs static code formatting and analysis on Kotlin source files.
 * Note: This task needs to be executed manually as it's not included in the standard build lifecycle.
 */
tasks.register<SourceTask>(sanityTask) {
    group = "formatting"
    /**
     * Dependencies for the "sanityProject" task.
     * It will be executed after the "ktlintFormat", "ktlintCheck" and "detekt" tasks have completed.
     */
    dependsOn(tasks.named("ktlintFormat"))
    dependsOn(tasks.named("ktlintCheck"))
    dependsOn(tasks.named("detekt"))
}

/**
 * Sets the order in which the "ktlintFormat", "detekt" and "ktlintCheck" tasks are executed.
 */
tasks.named("detekt") {
    mustRunAfter(tasks.named("ktlintCheck"))
}

tasks.named("ktlintCheck") {
    mustRunAfter(tasks.named("ktlintFormat"))
}
