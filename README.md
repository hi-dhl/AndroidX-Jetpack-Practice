# <p align="center"> AndroidX-Jetpack-Practice </p>

<p align="center"> 仓库持续更新中，如果对你有帮助，请在右上角 star 一下，感谢！！！</p>
<p align="center"> 本仓库致力于建立最全、最新的 <b>AndroidX Jetpack 组件实践项目</b> 以及<b>组件对应的分析文章</b> </p>

<p align="center">
<a href="https://github.com/hi-dhl"><img src="https://img.shields.io/badge/GitHub-HiDhl-4BC51D.svg?style=flat"></a>  <a href="https://opensource.org/licenses/Apache-2.0"><img src="https://img.shields.io/badge/license-Apache2.0-blue.svg?style=flat"></a> <img src="https://img.shields.io/badge/language-kotlin-orange.svg"/>  <img src="https://img.shields.io/badge/platform-android-lightgrey.svg"/>
<br/>
<img src="https://img.shields.io/badge/Jetpack-AppStartup | Paging3 | Hilt | DataStore -8633FF.svg"/>
</p>

<!--![](http://cdn.51git.cn/2020-06-19-3551539-2cae0f5a80bce069.png)-->

## <p align="center"> 仓库目录结构介绍 </p>

```
AndroidX-Jetpack-Practice
│
├── AppStartupSimple                // App Startup 示例应用
│
├── Paging3Simple                   // Paging 3 加载本地数据库的示例应用
│
├── Paging3SimpleWithNetWork        // Paging 3 加载网络数据的示例应用
│
├── HiltSimple                      // Hilt 全部注解的实例应用
│
├── HiltWithAppStartupSimple        // Hilt 结合了 App Startup 和 ViewModel 等等示例应用
│
├── HiltWithMultiModuleSimple       // Hilt 在多模块中的示例应用
│
├── DataStoreSimple                 // DataStoreSimple 的示例应用
│    │
│    ├── main(master) 分支           // Preferences DataStore 的使用
│    ├── datastore_proto 分支        // Proto DataStore 的使用
│
├── VersionPlugin                   // 整个仓库的依赖库的版本管理
```

关于每个项目的文章分析，以及这些技术在项目中如何使用，在后文会详细的介绍，请往后看，如果有帮助，帮我在**右上角 star 一下** 就是对我最大的鼓励！

**联系我**

* 个人微信：hi-dhl
* 公众号：ByteCode，包含 Jetpack ，Kotlin ，Android 10 系列源码，译文，LeetCode / 剑指 Offer / 多线程 / 国内外大厂算法题 等等一系列文章

<img src='http://cdn.51git.cn/2020-10-20-151047.png' width = 350px/>


## <p align="center"> 综合实战项目 </p>

最新 Jetpack 实战项目 [PokemonGo](https://github.com/hi-dhl/PokemonGo)（神奇宝贝）基于 MVVM 架构和 Repository 设计模式，这是一个小型的 App 项目，涉及到技术：Paging3（network + db），Dagger-Hilt，App Startup，DataBinding，Room，Motionlayout，Kotlin Flow，Coil，JProgressView 等等。

[PokemonGo 仓库地址：https://github.com/hi-dhl/PokemonGo](https://github.com/hi-dhl/PokemonGo)

PokemonGo 效果图如下所示，如果图片无法查看，请点击这里查看 [动态效果图](http://cdn.51git.cn/2020-07-14-15946978385391.gif) | [静态图](http://cdn.51git.cn/2020-07-14-PokemonGo2.png)

<p align="center">
<img src="http://cdn.51git.cn/2020-07-14-PokemonGo2.png"/> 
</p>

## <p align="center"> 仓库项目介绍 </p>

仓库 `AndroidX-Jetpack-Practice` 致力于建立最全、最新的 **AndroidX Jetpack 组件的实战项目** 以及 **组件对应分析文章**，后续会慢慢陆续增加 Jetpack 新成员，仓库持续更新，会持续不断的慢慢的去完善，可以关注了解最新动态。

### <p align="center"> DataStoreSimple </p>


`DataStoreSimple` 是基于 Jetpack 成员 DataStore 在应用使用的示例，DataStore 主要用来替换 SharedPreferences，而 Jetpack DataStore 有两种实现方式：

* Preferences DataStore：以键值对的形式存储在本地和 SharedPreferences 类似，**main(master) 分支包含了 Preferences DataStore 的使用**，项目分析的文章请查看 [再见 SharedPreferences 拥抱 Jetpack DataStore（一）](https://juejin.im/post/6881442312560803853)
    
* Proto DataStore：存储类的对象（typed objects ），通过 protocol buffers 将对象序列化存储在本地，**datastore_proto 分支包含了 Proto DataStore 使用示例**，项目分析的文章请查看 [再见 SharedPreferences 拥抱 DataStore (二)](https://juejin.im/post/6888847647802097672)


**Proto DataStore 基于 Protobuf 实现的，Protobuf 环境配置点击下方连接前往查看：**

* [Protobuf | 安装 Gradle 插件编译 proto 文件](https://hi-dhl.com/2020/10/28/jetpack/05-probuff-AndroidStudio)
* [Protobuf | 如何在 ubuntu 上安装 Protobuf 编译 proto 文件](https://hi-dhl.com/2020/10/28/android/04-probuff-ubuntu)
* [Protobuf | 如何在 MAC 上安装 Protobuf 编译 proto 文件](https://hi-dhl.com/2020/10/28/android/05-probuff-mac)

### <p align="center"> AppStartupSimple </p>

`AppStartupSimple` 是基于 Jetpack 成员 `App Startup` 开发的一个示例应用，`App Startup` 提供了一个 `ContentProvider` 来运行所有依赖项的初始化，避免每个第三方库单独使用 `ContentProvider` 进行初始化，从而提高了 App 的启动速度。
 
* 项目 `AppStartupSimple` 结构如下：
    * 模块 `ContentProvider`：提供了运行 `ContentProvider` 示例项目
    * 模块 `Startup-Library`：提供了运行 `App Startup` 示例项目

关于 `AppStartupSimple` 分析的文章请看 [App Startup 实践以及原理分析](https://juejin.im/post/5ee4bbe4f265da76b559bdfe)

### <p align="center"> Paging3Simple </p>

`Paging3Simple` 是基于 Jetpack 成员 `Paging 3` 开发的加载本地数据库的示例应用，`Paging 3` 是一个分页库，它可以帮助您从本地存储或通过网络加载和显示数据。这种方法使你的 App 更有效地使用网络带宽和系统资源，而 `Paging3` 是使用 `Kotlin` 协程完全重写的库：

* 在内存中缓存分页数据，确保您的 App 在使用分页数据时有效地使用系统资源。
* 内置删除重复数据的请求，确保您的 App 有效地使用网络带宽和系统资源。
* 可配置 `RecyclerView` 的 `Adapter`，当用户滚动到加载数据的末尾时自动请求数据。
* 支持 `Kotlin` 协程和 `Flow`, 以及 `LiveData` 和 `RxJava`。

关于 `Paging3Simple` 加载本地数据分析的文章请看 [Jetpack 成员 Paging 3 实践以及原理分析（一）](https://juejin.im/post/5ee998e8e51d4573d65df02b)

<!--**Paging3Simple 涉及的技术栈：**

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
-->

### <p align="center"> Paging3SimpleWithNetWork </p>

`Paging3SimpleWithNetWork` 是基于 Jetpack 成员 `Paging 3` 开发的加载网络数据的示例应用。

关于 `Paging3SimpleWithNetWork` 加载网络数据分析的文章请看 [Jetpack 新成员 Paging3 网络实践及原理分析（二）](https://juejin.im/post/5eeefbf4e51d45742c53ddce)

<!--**Paging3SimpleWithNetWork 涉及的技术栈：**

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
* JDataBinding 是基于 DataBinding 封装的库-->

### <p align="center"> HiltSimple </p>

`HiltSimple` 是基于 Jetpack 成员 Hilt 开发的示例应用。

* 项目包含了 Hilt 常用注解 `@HiltAndroidApp`、`@AndroidEntryPoint`、`@Inject`、`@Module`、`@InstallIn`、`@Provides`、`@EntryPoint` 等等的使用。
* 还包含了 Hilt 如何和第三方库、Jetpack 其他成员的使用。

关于 `HiltSimple` 项目分析的文章请查看 [Jetpack 新成员 Hilt 实践（一）启程过坑记](https://juejin.im/post/5ef2f31951882565a94e06a5)

### <p align="center"> HiltWithAppStartupSimple </p>

`HiltWithAppStartupSimple` 是基于 Jetpack 成员 Hilt 开发的示例应用，结合了 `App Startup`、`ViewModel` 等等。

`HiltWithAppStartupSimple` 包含了 Hilt 全部注解的使用案例，也包含了项目 `HiltSimple` 中用到案例，可以先去了解 `HiltSimple` 之后在来了解 `HiltWithAppStartupSimple` 会更加的清楚。

关于 `HiltWithAppStartupSimple` 项目分析的文章请查看 [Jetpack 新成员 Hilt 实践之 App Startup（二）进阶篇](https://juejin.im/post/5ef7638c5188252e6a532db3)

### <p align="center"> HiltWithMultiModuleSimple </p>

`HiltWithAppStartupSimple` 是基于 Jetpack 成员 Hilt 在多模块中应用的示例，项目中使用的注解都是前两篇文章介绍的内容。

关于 `HiltWithMultiModuleSimple` 项目分析的文章请查看 [Jetpack 新成员 Hilt 与 Dagger 大不同（三）落地篇](https://juejin.im/post/5efca0c1e51d4534a40d972f)

> HiltSimple、HiltWithAppStartupSimple 和 HiltWithMultiModuleSimple 包含了 Hilt 所有注解的含义以及项目示例、以及和 Jetpack 组件的使用，Hilt 与 Dagger 不同之处，以及在多模块中局限性以及使用，在代码中都有详细的注释。

### <p align="center"> VersionPlugin </p>

`VersionPlugin` 是基于 `Composing builds` 开发的自定义插件，作为整个仓库的依赖库的版本管理，使用 `Composing builds` 作为依赖库的版本管理，它有以下好处：

* 编译速度快，升级单个依赖库，不需要更新整个项目
* 支持 AndroidStudio 自动补全和单击跳转
* ......

关于 `VersionPlugin` 的分析的文章请看 [再见吧 buildSrc, 拥抱 Composing builds 提升 Android 编译速度](https://juejin.im/post/5ed3ef906fb9a047bf7070b6)。

这是关于 buildSrc 和 Composing builds 详细使用案例的代码仓库的地址 [ComposingBuilds-vs-buildSrc](https://github.com/hi-dhl/ComposingBuilds-vs-buildSrc)，在代码中都要详细的注释。


### 其他成员

其他组件成员陆续增加中......敬请期待






---

最后推荐我一直在更新维护的项目和网站：

* 计划建立一个最全、最新的 AndroidX Jetpack 相关组件的实战项目 以及 相关组件原理分析文章，正在逐渐增加 Jetpack 新成员，仓库持续更新，欢迎前去查看：[AndroidX-Jetpack-Practice](https://github.com/hi-dhl/AndroidX-Jetpack-Practice)

* LeetCode / 剑指 offer / 国内外大厂面试题 / 多线程 题解，语言 Java 和 kotlin，包含多种解法、解题思路、时间复杂度、空间复杂度分析<br/>

    <image src="http://cdn.51git.cn/2020-10-04-16017884626310.jpg" width = "500px"/>
  
    * 剑指 offer 及国内外大厂面试题解：[在线阅读](https://offer.hi-dhl.com)
    * LeetCode 系列题解：[在线阅读](https://leetcode.hi-dhl.com)

* 最新 Android 10 源码分析系列文章，了解系统源码，不仅有助于分析问题，在面试过程中，对我们也是非常有帮助的，仓库持续更新，欢迎前去查看 [Android10-Source-Analysis](https://github.com/hi-dhl/Android10-Source-Analysis)

* 整理和翻译一系列精选国外的技术文章，每篇文章都会有**译者思考**部分，对原文的更加深入的解读，仓库持续更新，欢迎前去查看 [Technical-Article-Translation](https://github.com/hi-dhl/Technical-Article-Translation)

* 「为互联网人而设计，国内国外名站导航」涵括新闻、体育、生活、娱乐、设计、产品、运营、前端开发、Android 开发等等网址，欢迎前去查看 [为互联网人而设计导航网站](https://site.51git.cn)

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


