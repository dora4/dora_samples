 

## DoraSDK官方Demo

基于dora全家桶 https://github.com/dora4/dora

可使用开发模板 https://github.com/dora4/dora-idea-template
 
- BaseActivity中的常用API

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
