 

## DoraSDK官方Demo

基于dora全家桶 https://github.com/dora4/dora

可使用开发模板 https://github.com/dora4/dora-idea-template

- 全局生命周期配置DefaultGlobalConfig、TaskStackGlobalConfig以及自定义配置，支持配置Application、Activity和Fragment的生命周期，一次编写，所有项目复用。
    
       <!-- 全局生命周期配置，value配置为GlobalConfig，name为映射的配置类即可，可配置多个 -->
       <application>
            <!-- dora.lifecycle.config.DefaultGlobalConfig为默认配置，即使不配置任何GlobalConfig，也至少配置了它，请不要重复配置，让Activity自动监听了网络状况。继承并使用[dora.BaseApplication]自动配置 -->
            
            <!-- 调用BaseActivity的openActivity系列方法必须配置TaskStackGlobalConfig -->
            <meta-data
                android:name="dora.lifecycle.config.TaskStackGlobalConfig"
                android:value="GlobalConfig" />
            <meta-data
                android:name="dora.lifecycle.config.EventBusGlobalConfig"
                android:value="GlobalConfig" />
            <meta-data
                android:name="dora.lifecycle.config.ARouterGlobalConfig"
                android:value="GlobalConfig" />
            <meta-data
                android:name="com.example.dora.lifecycle.RetrofitGlobalConfig"
                android:value="GlobalConfig" />
            <meta-data
                android:name="com.example.dora.lifecycle.YourCustomGlobalConfig"
                android:value="GlobalConfig" />
        </application>
   
- BaseActivity、BaseFragment封装，基于MVVM架构。支持Activity中Fragment的流式切换，完美的Fragment切换方案，无Fragment重叠情况。并支持在Activity中监听手机网络的变化。
  1. showShortToast()和showLongToast()

     方便你在任意代码处弹出Toast，自动帮你切换线程，所以无需担心会报错

  2. openActivity()和openActivityForResult()系列

     替代startActivity和startActivityForResult，传递参数更为方便

  3. onGetExtras()

     方便获取intent传递过来的参数，在initData()之前调用，所以在initData的时候，该有的参数都有值了

  4. onNetworkConnected()和onNetworkDisconnected()

     网络断开和连接状态的监听

  5. onSetStatusBar()
    
     方便初始化状态栏
  
  6. showPage()和nextPage()，getFlowFragmentPageKeys()
  
     这个是自动管理BaseActivity内部Fragment切换的框架，常用于不需要activity的转场动画，而直接改变整体界面布局的场景。这里暂不做详细介绍，有兴趣的可以阅读源代码。

- DoraCrash一行代码配置将Crash信息写入文件，让BUG无处遁形。

  ```java
          DoraCrash.initCrash(this, "YourLogFolder/log");
  ```

- 可使用内存低的时候自动杀死本APP进程，在下次重启APP的时候不会有黑屏或白屏现象。
- 各种各样的工具类，开发无忧。如自动处理线程切换的ToastUtils让你更爽地弹吐司，LogUtils让你不再为tag命名而烦恼。还有复杂的Java文件读写等操作的封装、系统状态栏和导航栏适配工具、多语言国际化相关工具、图像处理相关工具、反射相关工具等。
