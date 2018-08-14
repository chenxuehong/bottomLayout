package com.common.bottomlayout;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.common.bottomlayout.fragment.LiveFragment;
import com.common.bottomlayout.fragment.MineFragment;
import com.common.bottomlayout.fragment.ShoppingFragment;
import com.common.bottomlayout.view.BottomBarLayoutWithVP;
import com.common.bottomlayout.view.NoScrollViewPager;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.bottomBarLayout)
    BottomBarLayoutWithVP bottomBarLayout;
    @Bind(R.id.noScrollViewPager)
    NoScrollViewPager noScrollViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        bottomBarLayout.with(this)
                .setViewPager(noScrollViewPager)
                .setTextColor(Color.RED, Color.BLACK)
                .setTextSize(14)
                .setSmoothScroll(true)
                .addItemView("直播", R.drawable.zhibo_l, R.drawable.zhibo, LiveFragment.class)
                .addItemView("商城", R.drawable.shangcheng_l, R.drawable.shangcheng, ShoppingFragment.class)
                .addItemView("我的", R.drawable.wo_l, R.drawable.wo, MineFragment.class)
                .addStateListAnimatorForScale(1.0f, 0.88f, 50)
                .setUnreadMsgCountAtIndex(1, 2)
                .build();
    }
}
