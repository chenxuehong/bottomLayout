# 依赖添加 
To get a Git project into your build:

Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.lytx1121:bottomLayout:v1.0'
	}
  
# bottomLayout使用实例
# MainActivity.xml布局
  <?xml version="1.0" encoding="utf-8"?>
  <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
      xmlns:tools="http://schemas.android.com/tools"
      android:layout_width="match_parent"
      android:layout_height="match_parent"
      android:orientation="vertical"
      tools:context="com.common.bottomlayout.MainActivity">

      <com.common.bottomlayout.view.NoScrollViewPager
          android:id="@+id/noScrollViewPager"
          android:layout_width="match_parent"
          android:layout_height="0dp"
          android:layout_weight="1"></com.common.bottomlayout.view.NoScrollViewPager>

      <View
          android:layout_width="match_parent"
          android:layout_height="0.3dp"
          android:background="@android:color/darker_gray"></View>

      <com.common.bottomlayout.view.BottomBarLayoutWithVP
          android:id="@+id/bottomBarLayout"
          android:layout_width="match_parent"
          android:layout_height="49dp"></com.common.bottomlayout.view.BottomBarLayoutWithVP>

  </LinearLayout>

# java代码：
    private BottomBarLayoutWithVP bottomBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView() {
       bottomBar = findViewById(R.id.bottom_bar);
        NoScrollViewPager viewPager = findViewById(R.id.fl_container);
        bottomBar.with(this)
                .setViewPager(viewPager)
                .setTextColor(Color.RED, Color.BLACK)
                .setTextSize(14)
                .setSmoothScroll(true)
                .addItemView("直播", R.drawable.zhibo_l, R.drawable.zhibo, LiveFragment.class)
                .addItemView("商城", R.drawable.shangcheng_l, R.drawable.shangcheng, ShoppingFragment.class)
                .addItemView("我的", R.drawable.wo_l, R.drawable.wo, MineFragment.class)
                .addStateListAnimatorForScale(1.0f, 0.88f, 50)
                .setUnreadMsgCountAtIndex(1,2)
                .build();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bottomBar != null) {
            bottomBar.clearCache();
        }
    }
 
