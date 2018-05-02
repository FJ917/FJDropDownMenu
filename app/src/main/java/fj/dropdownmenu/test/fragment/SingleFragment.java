package fj.dropdownmenu.test.fragment;

import android.app.Activity;
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

public class SingleFragment extends Fragment implements DropdownI.SingleRow{
    private static String TITLE = "single";
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @ViewInject(R.id.btnType)
    @BindView(R.id.btnType)
    DropdownButton btnType;
    @BindView(R.id.mask)
    View mask;
    @ViewInject(R.id.lvType)
    @BindView(R.id.lvType)
    DropdownColumnView lvType;

    public static SingleFragment newInstance(String title) {
        SingleFragment fragment = new SingleFragment();
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
        View view = inflater.inflate(R.layout.activity_single, container, false);
        ButterKnife.bind(this, view);
        Bundle bundle = getArguments();
        toolbar.setNavigationIcon(null);
        toolbar.setTitle(bundle.getString(TITLE));

        DropdownUtils.initFragment(getActivity(),this,view, mask);
        ViewUtils.injectFragmentViews(this,view, mask);

        //分类
        lvType.setSingleRow(this)
                .setSingleRowList(DataBean.getType(), -1)  //单列数据
                .setButton(btnType) //按钮
                .show();

        return view;
    }

    @Override
    public void onSingleChanged(DropdownItemObject singleRowObject) {
        Log.d("类型",singleRowObject.getValue());
    }
}
