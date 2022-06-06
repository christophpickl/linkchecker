package com.github.christophpickl.linkchecker

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.provider.Property
import org.gradle.kotlin.dsl.create

class LinkChecker : Plugin<Project> {
    override fun apply(project: Project) {
        val extension = project.extensions.create<LinkCheckerExtension>("linkChecker")
        project.afterEvaluate {
            println("link checker: after evaluate")
        }
        // val websiteUrl = extension.websiteUrl.get()
    }
}

interface LinkCheckerExtension {
    val websiteUrl: Property<String>
}
