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

public class DoubleFragment extends Fragment implements DropdownI.DoubleRow{
    private static String TITLE = "double";
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
    public static DoubleFragment newInstance(String title) {
        DoubleFragment fragment = new DoubleFragment();
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
        View view = inflater.inflate(R.layout.activity_double, container, false);
        ButterKnife.bind(this, view);
        Bundle bundle = getArguments();
        toolbar.setNavigationIcon(null);
        toolbar.setTitle(bundle.getString(TITLE));

        DropdownUtils.initFragment(getActivity(),this,view, mask);
        ViewUtils.injectFragmentViews(this,view, mask);

        //动物
        lvAnimal.setDoubleRow(this)
                .setSingleRowList(DataBean.getAnimalSingle(), -1)//单列数据
                .setDoubleRowList(DataBean.getAnimalDouble(), -1)//双列数据
                .setButton(btnAnimal)          //按钮
                .show();

        return view;
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
