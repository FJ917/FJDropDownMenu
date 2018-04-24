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
 * 双列筛选栗子
 */
public class DoubleActivity extends AppCompatActivity implements DropdownI.DoubleRow {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @ViewInject(R.id.btnAnimal)
    @BindView(R.id.btnAnimal)
    DropdownButton btnAnimal;
    @BindView(R.id.mask)
    View mask;
    @ViewInject(R.id.lvAnimal)
    @BindView(R.id.lvAnimal)
    DropdownColumnView lvAnimal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_double);
        ButterKnife.bind(this);
        DropdownUtils.init(this, mask);
        ViewUtils.injectViews(this, mask);
        setSupportActionBar(toolbar);

        //动物
        lvAnimal.setDoubleRow(this)
                .setSingleRowList(DataBean.getAnimalSingle(), -1)//单列数据
                .setDoubleRowList(DataBean.getAnimalDouble(), -1)//双列数据
                .setButton(btnAnimal)          //按钮
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

    @Override
    public void onDoubleSingleChanged(DropdownItemObject singleRowObject) {
        Log.d("动物",singleRowObject.getValue());
    }

    @Override
    public void onDoubleChanged(DropdownItemObject doubleRowObject) {
        Log.d("动物子类",doubleRowObject.getValue());
    }
}
