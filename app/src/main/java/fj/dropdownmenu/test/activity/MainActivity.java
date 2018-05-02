package fj.dropdownmenu.test.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fj.dropdownmenu.test.R;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btnSingle)
    Button btnSingle;
    @BindView(R.id.btnDouble)
    Button btnDouble;
    @BindView(R.id.btnThree)
    Button btnThree;
    @BindView(R.id.btnCombination)
    Button btnCombination;
    @BindView(R.id.btnNestedCombination)
    Button btnNestedCombination;
    @BindView(R.id.btnRandomView)
    Button btnRandomView;
    @BindView(R.id.btnFragmentDemo)
    Button btnFragmentDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnSingle, R.id.btnDouble, R.id.btnThree, R.id.btnCombination, R.id.btnNestedCombination, R.id.btnRandomView, R.id.btnFragmentDemo})
    public void onViewClicked(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.btnSingle:
                intent.setClass(this,SingleActivity.class);
                startActivity(intent);
                break;
            case R.id.btnDouble:
                intent.setClass(this,DoubleActivity.class);
                startActivity(intent);
                break;
            case R.id.btnThree:
                intent.setClass(this,ThreeActivity.class);
                startActivity(intent);
                break;
            case R.id.btnCombination:
                intent.setClass(this,CombinationActivity.class);
                startActivity(intent);
                break;
            case R.id.btnNestedCombination:
                intent.setClass(this,NestedCombinationActivity.class);
                startActivity(intent);
                break;
            case R.id.btnRandomView:
                intent.setClass(this,RandomViewActivity.class);
                startActivity(intent);
                break;
            case R.id.btnFragmentDemo:
                intent.setClass(this,FragmentDemoActivity.class);
                startActivity(intent);
                break;
        }

    }
}
