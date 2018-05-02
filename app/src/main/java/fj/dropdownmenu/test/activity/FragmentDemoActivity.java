package fj.dropdownmenu.test.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import fj.dropdownmenu.test.R;
import fj.dropdownmenu.test.fragment.DoubleFragment;
import fj.dropdownmenu.test.fragment.SingleFragment;
import fj.dropdownmenu.test.fragment.ThreeFragment;

/**
 * Created by FJ917 on 2018/5/2.
 */

public class FragmentDemoActivity extends Activity implements BottomNavigationBar.OnTabSelectedListener{
    @BindView(R.id.llRoot)
    LinearLayout llRoot;
    @BindView(R.id.bottomBar)
    BottomNavigationBar bottomBar;

    private SingleFragment singleFragment;//单列
    private DoubleFragment doubleFragment;//双列
    private ThreeFragment threeFragment;//三列


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_demo);
        ButterKnife.bind(this);

        assignViews();
    }

    /**
     * 添加页面
     */
    private void assignViews() {

        bottomBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        bottomBar
                .setActiveColor(R.color.colorPrimary)//选中颜色
                .setInActiveColor(R.color.font_black_content)//未选中颜色
                .setBarBackgroundColor(R.color.white)//背景色
                .addItem(new BottomNavigationItem(R.drawable.ic_check, "单列"))
                .addItem(new BottomNavigationItem(R.drawable.ic_check, "双列"))
                .addItem(new BottomNavigationItem(R.drawable.ic_check, "三列"))
                .setMode(BottomNavigationBar.MODE_FIXED)
                .initialise();
        bottomBar.setTabSelectedListener(this);//设置监听
        setDefaultFragment();//设置默认选项
    }

    /**
     * 设置默认的
     */
    private void setDefaultFragment() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        singleFragment = SingleFragment.newInstance("单列");
        transaction.replace(R.id.llRoot, singleFragment);
        transaction.commit();
    }

    @Override
    public void onTabSelected(int position) {
        FragmentManager fm = this.getFragmentManager();
        //开启事务
        FragmentTransaction transaction = fm.beginTransaction();
        switch (position) {
            case 0:
                if (singleFragment == null) {
                    singleFragment = SingleFragment.newInstance("单列");
                }
                transaction.replace(R.id.llRoot, singleFragment);
                break;
            case 1:
                if (doubleFragment == null) {
                    doubleFragment = DoubleFragment.newInstance("双列");
                }
                transaction.replace(R.id.llRoot, doubleFragment);
                break;

            case 2:
                if (threeFragment == null) {
                    threeFragment = ThreeFragment.newInstance("三列");
                }
                transaction.replace(R.id.llRoot, threeFragment);
                break;
            default:
                break;
        }
        // 事务提交
        transaction.commit();
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
