# <p align="center"> AndroidX-Jetpack-Practice </p>

<p align="center"> 仓库持续更新中，如果对你有帮助，请在右上角 star 一下</p>
<p align="center"> 本仓库致力于建立最全、最新的的 AndroidX Jetpack 相关组件的实践项目 以及组件对应的分析文章 </p>

<p align="center">
<a href="https://github.com/hi-dhl"><img src="https://img.shields.io/badge/GitHub-HiDhl-4BC51D.svg?style=flat"></a>  <a href="https://opensource.org/licenses/Apache-2.0"><img src="https://img.shields.io/badge/license-Apache2.0-blue.svg?style=flat"></a> <img src="https://img.shields.io/badge/language-kotlin-orange.svg"/> <img src="https://img.shields.io/badge/Jetpack-AppStartup | Paging3 | Hilt -8633FF.svg"/> <img src="https://img.shields.io/badge/platform-android-lightgrey.svg"/>
</p>

![](http://cdn.51git.cn/2020-06-19-3551539-2cae0f5a80bce069.png)

本仓库致力于建立最全、最新的的 AndroidX Jetpack 相关组件的实战项目 以及组件对应分析文章，后续会慢慢陆续增加 Jetpack 新成员，仓库持续更新，会持续不断的慢慢的去完善，可以关注了解最新动态，敬请期待。

最新 Jetpack 实战项目 [PokemonGo](https://github.com/hi-dhl/PokemonGo)（神奇宝贝）基于 MVVM 架构和 Repository 设计模式，这是一个小型的 App 项目，涉及到技术：Paging3（network + db），Dagger-Hilt，App Startup，DataBinding，Room，Motionlayout，Kotlin Flow，Coil，JProgressView 等等。

[PokemonGo 仓库地址：https://github.com/hi-dhl/PokemonGo](https://github.com/hi-dhl/PokemonGo)

PokemonGo 效果图如下所示，如果图片无法查看，请点击这里查看 [动态效果图](http://cdn.51git.cn/2020-07-14-15946978385391.gif) | [静态图](http://cdn.51git.cn/2020-07-14-PokemonGo2.png)

<p align="center">
<img src="http://cdn.51git.cn/2020-07-14-PokemonGo2.png"/> 
</p>

## 仓库 Jetpack Jetpack 项目介绍

### AppStartupSimple

`AppStartupSimple` 是基于 Jetpack 成员 `App Startup` 开发的一个示例应用，`App Startup` 提供了一个 `ContentProvider` 来运行所有依赖项的初始化，避免每个第三方库单独使用 `ContentProvider` 进行初始化，从而提高了 App 的启动速度。
 
* 项目 `AppStartupSimple` 结构如下：
    * 模块 `ContentProvider`：提供了运行 `ContentProvider` 示例项目
    * 模块 `Startup-Library`：提供了运行 `App Startup` 示例项目

关于 `AppStartupSimple` 分析的文章请看 [App Startup 实践以及原理分析](https://juejin.im/post/5ee4bbe4f265da76b559bdfe)

### Paging3Simple

`Paging3Simple` 是基于 Jetpack 成员 `Paging 3` 开发的加载本地数据库的示例应用，`Paging 3` 是一个分页库，它可以帮助您从本地存储或通过网络加载和显示数据。这种方法使你的 App 更有效地使用网络带宽和系统资源，而 `Paging3` 是使用 `Kotlin` 协程完全重写的库：

* 在内存中缓存分页数据，确保您的 App 在使用分页数据时有效地使用系统资源。
* 内置删除重复数据的请求，确保您的 App 有效地使用网络带宽和系统资源。
* 可配置 `RecyclerView` 的 `Adapter`，当用户滚动到加载数据的末尾时自动请求数据。
* 支持 `Kotlin` 协程和 `Flow`, 以及 `LiveData` 和 `RxJava`。

关于 `Paging3Simple` 加载本地数据分析的文章请看 [Jetpack 成员 Paging 3 实践以及原理分析（一）](https://juejin.im/post/5ee998e8e51d4573d65df02b)

**Paging3Simple 涉及的技术栈：**

* 基于 kotlin 和 协程
* 使用 koin 作为依赖注入库
* JetPack
    * LiveData
    * Lifecycle
    * ViewModel
    * Room
    * Paging3
* 架构
    * MVVM 架构
    * Repository 设计模式
    * Data Mapper 数据映射
* 使用 Composing builds 作为依赖库的版本管理
* JDataBinding 是基于 DataBinding 封装的库

### Paging3SimpleWithNetWork

`Paging3SimpleWithNetWork` 是基于 Jetpack 成员 `Paging 3` 开发的加载网络数据的示例应用。

关于 `Paging3SimpleWithNetWork` 加载网络数据分析的文章请看 [Jetpack 新成员 Paging3 网络实践及原理分析（二）](https://juejin.im/post/5eeefbf4e51d45742c53ddce)

**Paging3SimpleWithNetWork 涉及的技术栈：**

* 基于 kotlin 和 协程
* 使用 koin 作为依赖注入库
* JetPack
    * LiveData
    * Lifecycle
    * ViewModel
    * Paging3
* Retrofit 作为网络框架
* 架构
    * MVVM 架构
    * Repository 设计模式
    * Data Mapper 数据映射
* 使用 Composing builds 作为依赖库的版本管理
* JDataBinding 是基于 DataBinding 封装的库

### HiltSimple

`HiltSimple` 是基于 Jetpack 成员 Hilt 开发的示例应用。

* 项目包含了 Hilt 常用注解 `@HiltAndroidApp`、`@AndroidEntryPoint`、`@Inject`、`@Module`、`@InstallIn`、`@Provides`、`@EntryPoint` 等等的使用。
* 还包含了 Hilt 如何和第三方库、Jetpack 其他成员的使用。

关于 `HiltSimple` 项目分析的文章请查看 [Jetpack 新成员 Hilt 实践（一）启程过坑记](https://juejin.im/post/5ef2f31951882565a94e06a5)

### HiltWithAppStartupSimple

`HiltWithAppStartupSimple` 是基于 Jetpack 成员 Hilt 开发的示例应用，结合了 `App Startup`、`ViewModel` 等等。

`HiltWithAppStartupSimple` 包含了 Hilt 全部注解的使用案例，也包含了项目 `HiltSimple` 中用到案例，可以先去了解 `HiltSimple` 之后在来了解 `HiltWithAppStartupSimple` 会更加的清楚。

关于 `HiltWithAppStartupSimple` 项目分析的文章请查看 [Jetpack 新成员 Hilt 实践之 App Startup（二）进阶篇](https://juejin.im/post/5ef7638c5188252e6a532db3)

### HiltWithMultiModuleSimple

`HiltWithAppStartupSimple` 是基于 Jetpack 成员 Hilt 在多模块中应用的示例，项目中使用的注解都是前两篇文章介绍的内容。

* [Jetpack 新成员 Hilt 实践（一）启程过坑记](https://juejin.im/post/5ef2f31951882565a94e06a5)
* [Jetpack 新成员 Hilt 实践之 App Startup（二）进阶篇](https://juejin.im/post/5ef7638c5188252e6a532db3)

关于 `HiltWithMultiModuleSimple` 项目分析的文章请查看 [Jetpack 新成员 Hilt 与 Dagger 大不同（三）落地篇](https://juejin.im/post/5efca0c1e51d4534a40d972f)

> HiltSimple、HiltWithAppStartupSimple 和 HiltWithMultiModuleSimple 包含了 Hilt 所有注解的含义以及项目示例、以及和 Jetpack 组件的使用，Hilt 与 Dagger 不同之处，以及在多模块中局限性以及使用，在代码中都有详细的注释。

### VersionPlugin

`VersionPlugin` 是基于 `Composing builds` 开发的自定义插件，作为整个仓库的依赖库的版本管理，使用 `Composing builds` 作为依赖库的版本管理，它有以下好处：

* 编译速度快，升级单个依赖库，不需要更新整个项目
* 支持 AndroidStudio 自动补全和单击跳转
* ......

关于 `VersionPlugin` 的分析的文章请看 [再见吧 buildSrc, 拥抱 Composing builds 提升 Android 编译速度](https://juejin.im/post/5ed3ef906fb9a047bf7070b6)。

这是关于 buildSrc 和 Composing builds 详细使用案例的代码仓库的地址 [ComposingBuilds-vs-buildSrc](https://github.com/hi-dhl/ComposingBuilds-vs-buildSrc)，在代码中都要详细的注释。

### 其他成员

其他组件成员陆续增加中......敬请期待

## 结语

致力于分享一系列 Android 系统源码、逆向分析、算法、翻译、Jetpack 源码相关的文章，正在努力写出更好的文章，如果这篇文章对你有帮助给个 star，文章中有什么没有写明白的地方，或者有什么更好的建议欢迎留言，欢迎一起来学习，在技术的道路上一起前进。

> 计划建立一个最全、最新的 AndroidX Jetpack 相关组件的实战项目 以及 相关组件原理分析文章，正在逐渐增加 Jetpack 新成员，仓库持续更新，可以前去查看：[AndroidX-Jetpack-Practice](https://github.com/hi-dhl/AndroidX-Jetpack-Practice), 如果这个仓库对你有帮助，请帮我点个赞，我会陆续完成更多 Jetpack 新成员的项目实践。

### Android10 源码分析

正在写一系列的 Android 10 源码分析的文章，了解系统源码，不仅有助于分析问题，在面试过程中，对我们也是非常有帮助的，如果你同我一样喜欢研究 Android 源码，可以关注我 GitHub 上的 [Android10-Source-Analysis](https://github.com/hi-dhl/Android10-Source-Analysis)。

### 算法题库的归纳和总结

由于 LeetCode 的题库庞大，每个分类都能筛选出数百道题，由于每个人的精力有限，不可能刷完所有题目，因此我按照经典类型题目去分类、和题目的难易程度去排序。

* 数据结构： 数组、栈、队列、字符串、链表、树……
* 算法： 查找算法、搜索算法、位运算、排序、数学、……

每道题目都会用 Java 和 kotlin 去实现，并且每道题目都有解题思路，如果你同我一样喜欢算法、LeetCode，可以关注我 GitHub 上的 LeetCode 题解：[Leetcode-Solutions-with-Java-And-Kotlin](https://github.com/hi-dhl/Leetcode-Solutions-with-Java-And-Kotlin)。

### 精选国外的技术文章

目前正在整理和翻译一系列精选国外的技术文章，不仅仅是翻译，很多优秀的英文技术文章提供了很好思路和方法，每篇文章都会有**译者思考**部分，对原文的更加深入的解读，可以关注我 GitHub 上的 [Technical-Article-Translation](https://github.com/hi-dhl/Technical-Article-Translation)。

## License

```
Copyright 2020 hi-dhl (Jack Deng)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```


