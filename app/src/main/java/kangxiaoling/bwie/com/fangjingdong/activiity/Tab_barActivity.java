package kangxiaoling.bwie.com.fangjingdong.activiity;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.gyf.barlibrary.ImmersionBar;
import com.hjm.bottomtabbar.BottomTabBar;

import butterknife.BindView;
import kangxiaoling.bwie.com.fangjingdong.R;
import kangxiaoling.bwie.com.fangjingdong.fragment.FourFragment;
import kangxiaoling.bwie.com.fangjingdong.fragment.OneFragment;
import kangxiaoling.bwie.com.fangjingdong.fragment.ThreeFragment;
import kangxiaoling.bwie.com.fangjingdong.fragment.TwoFragment;
import lianxibase1.bwie.com.base.base.BaseActivity;

import static kangxiaoling.bwie.com.fangjingdong.R.id.tab_bar;

public class Tab_barActivity extends AppCompatActivity {

    private BottomTabBar tab_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_bar);
        initView();
    }

    private void initView() {
        ImmersionBar.with(this).init();
        tab_bar = (BottomTabBar) findViewById(R.id.tab_bar);
        tab_bar.init(getSupportFragmentManager())
                    .addTabItem("首页", R.drawable.syc, OneFragment.class)
                    .addTabItem("发现", R.drawable.fxc, TwoFragment.class)
                    .addTabItem("推荐", R.drawable.flc, ThreeFragment.class)
                    .addTabItem("我的", R.drawable.myc, FourFragment.class);
        }
    }
