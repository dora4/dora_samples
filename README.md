 

## DoraSDK官方Demo

基于dora全家桶 https://github.com/dora4/dora

可使用开发模板 https://github.com/dora4/dora-idea-template

- 案例一（基于RSA的非对称加密）

  ```kotlin
  //生成公钥私钥键值对
  val keyPair = SecurityUtils.generateRSAKeyPair(1024)
  //从map中获取公钥
  val publicKey = keyPair["publicKey"]
  //从map中获取私钥
  val privateKey = keyPair["privateKey"]
  tv_rsa_key_pair.text = "生成一对秘钥\n\n公钥：${publicKey}\n\n私钥：${privateKey}\n\n"
  btn_rsa_next_step.setOnClickListener {
      val text = "Dora1234567890"
      val encryptByPublic = SecurityUtils.encryptByPublic(publicKey, text)
      val decryptByPrivate = SecurityUtils.decryptByPrivate(privateKey, encryptByPublic)
      tv_rsa_key_pair.append("等待加密的字符串${text}\n公钥加密后：${encryptByPublic}\n" +
              "私钥解密后：${decryptByPrivate}")
  }
  ```

- 案例二（数据的三级缓存）

  dora-db的orm相关代码

  ```java
  @Table("pop_music")
  public class PopMusic implements OrmTable {
  
      @Id
      long id;
      @Column("music_name")
      String musicName;
      @Column("music_artist")
      String musicArtist;
  
      public PopMusic(String name, String artist) {
          this.musicName = name;
          this.musicArtist = artist;
      }
  
      public String getMusicName() {
          return musicName;
      }
  
      public void setMusicName(String musicName) {
          this.musicName = musicName;
      }
  
      public String getMusicArtist() {
          return musicArtist;
      }
  
      public void setMusicArtist(String musicArtist) {
          this.musicArtist = musicArtist;
      }
  
      @Override
      public PrimaryKeyEntity getPrimaryKey() {
          return new PrimaryKeyId(id);
      }
  
      @Override
      public boolean isUpgradeRecreated() {
          return false;
      }
  }
  ```

  dora-cache的缓存逻辑相关代码

  ```java
  public class PopMusicRepository extends BaseDatabaseCacheRepository<PopMusic> {
  
      @Inject
      public PopMusicRepository() {
          super(PopMusic.class);
      }
    
      /**
       * 告诉框架怎么加载这部分数据。
       *
       * @param callback
       */
      @Override
      protected void onLoadFromNetwork(DoraListCallback<PopMusic> callback) {
          RetrofitManager.getService(MusicService.class).popMusicGet().enqueue(callback);
      }
  
      /**
       * 数据过滤条件，从数据库查询出来之前会先过滤不要的数据。
       */
      @Override
      protected WhereBuilder where() {
          return super.where();
      }
  }
  ```
  
  界面调用逻辑代码（如果不为集合数据，则调用getData()方法）
  
  ```java
          repository.getListData().observe(this, new Observer<List<PopMusic>>() {
              @Override
              public void onChanged(List<PopMusic> popMusics) {
                  ViewUtils.configRecyclerView(mBinding.rvDataCache).setAdapter(new PopMusicAdapter(popMusics));
              }
          });
  ```
  
- 案例三（BaseActivity中的常用API）

  1. toast()和toastL()

     方便你在任意代码处弹出Toast，自动帮你切换线程，所以无需担心会报错

  2. openActivity()和openActivityForResult()系列

     替代startActivity和startActivityForResult，传递参数更为方便

  3. onGetExtras()

     方便获取intent传递过来的参数，在initData()之前调用，所以在initData的时候，该有的参数都有值了

  4. onNetworkConnected()和onNetworkDisconnected()

     网络断开和连接状态的监听

  5. requirePermissions()

     在打开界面之前判断是否有需要的权限，再调用initData

  6. onShowStatusBar()

     方便初始化状态栏

  7. showPage()和nextPage()，以及getFragmentPages()

     这个是自动管理BaseActivity内部Fragment切换的框架，常用于不需要activity的转场动画，而直接改变整体界面布局的场景。这里暂不做详细介绍，有兴趣的可以阅读源代码。

     

撸码不易，如果觉得帮您节省了大量的开发时间，对您有所帮助，欢迎您的赞赏！

| 支付宝打赏                                                   | 微信打赏                                                     |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| <img src="https://github.com/dora4/dora_samples/blob/master/donate/alipay.jpg" alt="支付宝打赏作者" width="260px" /> | <img src="https://github.com/dora4/dora_samples/blob/master/donate/wxpay.jpg" alt="微信打赏作者" width="260px" /> |

捐赠虚拟货币

###### 柚子(EOS): 钱包地址 - doramusic123 , 备注TAG - 你的github用户名

###### USDT(TRC-20链): 钱包地址 - TYVXzqctSSPSTeVPYg7i7qbEtSxwrAJQ5y

###### 以太坊(ETH): 钱包地址 - 0x5dA12D7DB7B5D6C8D2Af78723F6dCE4A3C89caB9
