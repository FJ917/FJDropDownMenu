package fj.dropdownmenu.test.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
 * Created by FJ917 on 2018/5/2.
 */

public class ThreeFragment extends Fragment implements DropdownI.ThreeRow{
    private static String TITLE = "three";
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @ViewInject(R.id.btnRegion)
    @BindView(R.id.btnRegion)
    DropdownButton btnRegion;
    @BindView(R.id.mask)
    View mask;
    @ViewInject(R.id.lvRegion)
    @BindView(R.id.lvRegion)
    DropdownColumnView lvRegion;

    public static ThreeFragment newInstance(String title) {
        ThreeFragment fragment = new ThreeFragment();
        Bundle args = new Bundle();
        args.putString(TITLE, title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_three, container, false);
        ButterKnife.bind(this, view);
        Bundle bundle = getArguments();
        toolbar.setNavigationIcon(null);
        toolbar.setTitle(bundle.getString(TITLE));

        DropdownUtils.initFragment(getActivity(),this,view, mask);
        ViewUtils.injectFragmentViews(this,view, mask);

        lvRegion.setThreeRow(this)
                .setSingleRowList(DataBean.getRegionProvince(), -1)  //单列数据
                .setDoubleRowList(DataBean.getRegionCity(), -1)//双列数据
                .setThreeRowList(DataBean.getRegionArea(), -1)//三列数据
                .setButton(btnRegion) //按钮
                .show();

        return view;
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

