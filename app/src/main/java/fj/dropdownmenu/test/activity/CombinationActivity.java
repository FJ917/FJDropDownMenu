package fj.dropdownmenu.test.activity;

import android.app.Instrumentation;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import fj.dropdownmenu.lib.concat.DropdownI;
import fj.dropdownmenu.lib.ion.ViewInject;
import fj.dropdownmenu.lib.ion.ViewUtils;
import fj.dropdownmenu.lib.pojo.DropdownItemObject;
import fj.dropdownmenu.lib.utils.DropdownUtils;
import fj.dropdownmenu.lib.view.DropdownButton;
import fj.dropdownmenu.lib.view.DropdownColumnView;
import fj.dropdownmenu.test.R;
import fj.dropdownmenu.test.bean.DataBean;

/**
 * 单列，双列，三列组合实现栗子
 */
public class CombinationActivity extends AppCompatActivity implements DropdownI.SingleRow, DropdownI.DoubleRow,
        DropdownI.ThreeRow {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @ViewInject(R.id.btnType)
    @BindView(R.id.btnType)
    DropdownButton btnType;
    @ViewInject(R.id.btnAnimal)
    @BindView(R.id.btnAnimal)
    DropdownButton btnAnimal;
    @ViewInject(R.id.btnRegion)
    @BindView(R.id.btnRegion)
    DropdownButton btnRegion;
    @BindView(R.id.mask)
    View mask;
    @ViewInject(R.id.lvType)
    @BindView(R.id.lvType)
    DropdownColumnView lvType;
    @ViewInject(R.id.lvAnimal)
    @BindView(R.id.lvAnimal)
    DropdownColumnView lvAnimal;
    @ViewInject(R.id.lvRegion)
    @BindView(R.id.lvRegion)
    DropdownColumnView lvRegion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combination);
        ButterKnife.bind(this);

        DropdownUtils.init(this, mask);
        ViewUtils.injectViews(this, mask);
        setSupportActionBar(toolbar);

        //分类
        lvType.setSingleRow(this)
                .setSingleRowList(DataBean.getType(), -1)  //单列数据
                .setButton(btnType) //按钮
                .show();
        //动物
        lvAnimal.setDoubleRow(this)
                .setSingleRowList(DataBean.getAnimalSingle(), -1)//单列数据
                .setDoubleRowList(DataBean.getAnimalDouble(), -1)//双列数据
                .setButton(btnAnimal)          //按钮
                .show();
        //地区
        lvRegion.setThreeRow(this)
                .setSingleRowList(DataBean.getRegionProvince(), -1)  //单列数据
                .setDoubleRowList(DataBean.getRegionCity(), -1)//双列数据
                .setThreeRowList(DataBean.getRegionArea(), -1)//三列数据
                .setButton(btnRegion) //按钮
                .show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                new Thread() {
                    @Override
                    public void run() {
                        Instrumentation inst = new Instrumentation();
                        inst.sendKeyDownUpSync(KeyEvent.KEYCODE_BACK);
                    }
                }.start();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 单列表返回
     */
    @Override
    public void onSingleChanged(DropdownItemObject singleRowObject) {
        Log.d("类型",singleRowObject.getValue());
    }

    /**
     * 双列表返回
     */
    @Override
    public void onDoubleSingleChanged(DropdownItemObject singleRowObject) {
        Log.d("动物",singleRowObject.getValue());
    }

    @Override
    public void onDoubleChanged(DropdownItemObject doubleRowObject) {
        Log.d("动物子类",doubleRowObject.getValue());
    }

    /**
     * 三列表返回
     */
    @Override
    public void onThreeSingleChanged(DropdownItemObject singleRowObject) {
        Log.d("省",singleRowObject.getValue());
    }

    @Override
    public void onThreeDoubleChanged(DropdownItemObject doubleRowObject) {
        Log.d("市",doubleRowObject.getValue());
    }

    @Override
    public void onThreeChanged(DropdownItemObject threeRowObject) {
        Log.d("区",threeRowObject.getValue());
    }

}
