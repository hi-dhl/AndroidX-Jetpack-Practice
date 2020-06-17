package com.hi.dhl.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/5/29
 *     desc  : 如果出现红色警告可以忽略，不会影响项目的编译和运行
 * </pre>
 */
class VersionPlugin : Plugin<Project> {
    override fun apply(project: Project) {
    }

    companion object {


    }
}
