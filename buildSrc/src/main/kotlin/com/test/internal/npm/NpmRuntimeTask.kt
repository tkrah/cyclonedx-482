package com.test.internal.npm

import com.github.gradle.node.npm.task.NpmInstallTask

abstract class NpmRuntimeTask : NpmAbstractTask() {
    init {
        val heapsize = project.findProperty("node_heapsize_runtime")
        environment.put("NODE_OPTIONS", "--max-old-space-size=$heapsize")
        dependsOn(NpmInstallTask.NAME)
    }

}
