# <p align="center"> AndroidX-Jetpack-Practice </p>

<p align="center"> 仓库持续更新中，可以关注了解最新动态</p>
<p align="center"> 本仓库致力于建立最全、最新的的 AndroidX Jetpack 相关组件的实践项目 以及组件对应的分析文章 </p>

<p align="center">
<a href="https://github.com/hi-dhl"><img src="https://img.shields.io/badge/GitHub-HiDhl-4BC51D.svg?style=flat"></a>  <a href="https://opensource.org/licenses/Apache-2.0"><img src="https://img.shields.io/badge/license-Apache2.0-blue.svg?style=flat"></a> <img src="https://img.shields.io/badge/language-kotlin-orange.svg"/> <img src="https://img.shields.io/badge/Jetpack-AppStartup|Paging3-8633FF.svg"/> <img src="https://img.shields.io/badge/platform-android-lightgrey.svg"/>
</p>

![](media/15920418119729.jpg)

本仓库致力于建立最全、最新的的 AndroidX Jetpack 相关组件的实战项目 以及组件对应分析文章，后续会慢慢陆续增加 Jetpack 新成员，仓库持续更新，会持续不断的慢慢的去完善，可以关注了解最新动态，敬请期待

## Jetpack Jetpack 新成员

### App Startup

App Startup 提供了一个 ContentProvider 来运行所有依赖项的初始化，避免每个第三方库单独使用 ContentProvider 进行初始化，从而提高了 App 的启动速度。
 
* 项目 AppStartupSimple 结构如下：
    * 模块 ContentProvider：提供了运行 ContentProvider 示例项目
    * 模块 Startup-Library：提供了运行 App Startup 示例项目
* [App Startup 实践以及原理分析](https://juejin.im/post/5ee4bbe4f265da76b559bdfe)

### Paging3Simple

Paging 是一个分页库，它可以帮助您从本地存储或通过网络加载和显示数据。这种方法使你的 App 更有效地使用网络带宽和系统资源，而 Paging3 是使用 Kotlin 协程完全重写的库：

* 在内存中缓存分页数据，确保您的 App 在使用分页数据时有效地使用系统资源。
* 内置删除重复数据的请求，确保您的 App 有效地使用网络带宽和系统资源。
* 可配置 RecyclerView 的 adapters，当用户滚动到加载数据的末尾时自动请求数据。
* 支持 Kotlin 协程和 Flow, 以及 LiveData 和 RxJava。

[Jetpack 成员 Paging 3 实践以及原理分析（一）](https://juejin.im/post/5ee998e8e51d4573d65df02b)

**项目 Paging3Simple 结构如下：**

![](http://cdn.51git.cn/2020-06-17-159232877840722.jpg)
    
* bean: 存放上层需要的 model，会和 RecyclerView 的 Adapter 绑定在一起。
* loca: 存放和本地数据库相关的操作。
* mapper: 数据映射，主要将数据源的实体 转成上层的 model。
* repository：主要来处理和数据源相关的操作（本地、网络、内存中缓存等等）。
* di: 和依赖注入相关。
* ui：数据的展示。

### 其他成员

* versionPlugin：作为整个仓库的依赖库的版本管理。

其他组件成员陆续增加中......敬请期待

## 结语

另外我还在维护其他三个项目 [Android10-Source-Analysis](https://github.com/hi-dhl/Android10-Source-Analysis)、 
[Leetcode-Solutions-with-Java-And-Kotlin](https://github.com/hi-dhl/Leetcode-Solutions-with-Java-And-Kotlin) 和 [Technical-Article-Translation](https://github.com/hi-dhl/Technical-Article-Translation) 可以前去查看

### Android10-Source-Analysis

正在写一系列的 Android 10 源码分析的文章，了解系统源码，不仅有助于分析问题，在面试过程中，对我们也是非常有帮助的，如果你同我一样喜欢研究 Android 源码，可以关注我 GitHub 上的 [Android10-Source-Analysis](https://github.com/hi-dhl/Android10-Source-Analysis)。

### Leetcode-Solutions-with-Java-And-Kotlin

由于 LeetCode 的题库庞大，每个分类都能筛选出数百道题，由于每个人的精力有限，不可能刷完所有题目，因此我按照经典类型题目去分类、和题目的难易程度去排序。

* 数据结构： 数组、栈、队列、字符串、链表、树……
* 算法： 查找算法、搜索算法、位运算、排序、数学、……

每道题目都会用 Java 和 kotlin 去实现，并且每道题目都有解题思路，如果你同我一样喜欢算法、LeetCode，可以关注我 GitHub 上的 LeetCode 题解：[Leetcode-Solutions-with-Java-And-Kotlin](https://github.com/hi-dhl/Leetcode-Solutions-with-Java-And-Kotlin)。

### Technical-Article-Translation

目前正在整理和翻译一系列精选国外的技术文章，不仅仅是翻译，很多优秀的英文技术文章提供了很好思路和方法，每篇文章都会有**译者思考**部分，对原文的更加深入的解读，可以关注我 GitHub 上的 [Technical-Article-Translation](https://github.com/hi-dhl/Technical-Article-Translation)。


