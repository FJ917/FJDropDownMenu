package fj.dropdownmenu.test.activity;

import android.app.Instrumentation;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
 * 任意view布局
 */
public class RandomViewActivity extends AppCompatActivity implements DropdownI.RandomView{

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @ViewInject(R.id.btnRandomView)
    @BindView(R.id.btnRandomView)
    DropdownButton btnRandomView;
    @BindView(R.id.mask)
    View mask;
    @ViewInject(R.id.dcRandomView)
    @BindView(R.id.dcRandomView)
    DropdownColumnView dcRandomView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_view);
        ButterKnife.bind(this);
        DropdownUtils.init(this, mask);
        ViewUtils.injectViews(this, mask);
        setSupportActionBar(toolbar);
        //自定义布局
        btnRandomView.setText("弹出自定义布局");
        dcRandomView.setRandom(this)
                .setRandomView(R.layout.random_view)
                .setButton(btnRandomView) //按钮
                .show();
    }

    @Override
    public void onRandom(View view) {
        Button btnRandom = (Button) view.findViewById(R.id.btnRandom);
        final EditText etRandom = (EditText) view.findViewById(R.id.etRandom);
        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RandomViewActivity.this, etRandom.getText().toString(), Toast.LENGTH_SHORT).show();
                DropdownUtils.hide();//点击后是否收起布局
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
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
}
