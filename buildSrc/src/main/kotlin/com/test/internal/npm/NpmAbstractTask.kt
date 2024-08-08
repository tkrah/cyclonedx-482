package com.test.internal.npm

import com.github.gradle.node.npm.task.NpmTask
import org.gradle.api.provider.Provider
import java.io.File

abstract class NpmAbstractTask : NpmTask() {

    init {
        environment.put("TMPDIR", project.layout.buildDirectory.asFile.get().absolutePath)
        inputs.file("package.json")
        inputs.dir("node_modules")
        val packageLockJson = projectFileIfExists("package-lock.json")
        if (packageLockJson.isPresent) {
            inputs.file(packageLockJson.get())
        }
    }

    protected fun projectFileIfExists(name: String): Provider<File> {
        return nodeExtension.nodeProjectDir.map { it.file(name).asFile }
            .flatMap { if (it.exists()) providers.provider { it } else providers.provider { null } }
    }
}
