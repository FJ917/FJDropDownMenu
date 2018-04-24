package fj.dropdownmenu.lib.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.List;

import fj.dropdownmenu.lib.R;
import fj.dropdownmenu.lib.adapter.FinallyAdapter;
import fj.dropdownmenu.lib.adapter.SelectAdapter;
import fj.dropdownmenu.lib.concat.DropdownI;
import fj.dropdownmenu.lib.pojo.DropdownItemObject;
import fj.dropdownmenu.lib.utils.DropdownUtils;


/**
 * 列选择view
 */
public class DropdownColumnView extends LinearLayout {
    /** context*/
    private Context context;
    /** 列表类型 */
    private int columnType;
    /** adapter*/
    private FinallyAdapter finallyAdapter;
    private SelectAdapter selectAdapter;
    private SelectAdapter selectDoubleAdapter;

    /** 单列ListView*/
    private ListView lvSingleRow;
    /** 单列默认选中id*/
    private int singleSelectedId = -1;

    /** 双列ListView*/
    private ListView lvDoubleRow;
    /** 双列默认选中id*/
    private int doubleSelectedId = -1;

    /** 双列ListView*/
    private ListView lvThreeRow;
    /** 双列默认选中id*/
    private int threeSelectedId = -1;

    /** 单列数据*/
    private List<DropdownItemObject> singleRowList = null;
    /** 双列数据*/
    private List<DropdownItemObject> doubleRowList = null;
    /** 三列数据*/
    private List<DropdownItemObject> threeRowList = null;

    /**默认选种图标*/
    private Drawable mSelectedIcon;

    private RelativeLayout mRelativeLayout;
    private View randomView;

    public DropdownButton button;


    private DropdownI.SingleRow singleRow;
    public DropdownColumnView setSingleRow(DropdownI.SingleRow singleRow){
        this.singleRow = singleRow;
        return this;
    }
    private DropdownI.DoubleRow doubleRow;
    public DropdownColumnView setDoubleRow(DropdownI.DoubleRow doubleRow){
        this.doubleRow = doubleRow;
        return this;
    }
    private DropdownI.ThreeRow threeRow;
    public DropdownColumnView setThreeRow(DropdownI.ThreeRow threeRow){
        this.threeRow = threeRow;
        return this;
    }
    private DropdownI.RandomView random;
    public DropdownColumnView setRandom(DropdownI.RandomView random) {
        this.random = random;
        return this;
    }

    public DropdownColumnView(Context context) {
        this(context, null);
        this.context = context;
    }

    public DropdownColumnView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        this.context = context;
    }

    public DropdownColumnView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        View view = LayoutInflater.from(getContext()).inflate(R.layout.dropdown_column_view, this, true);
        lvSingleRow = (ListView) view.findViewById(R.id.lvSingleRow);
        lvDoubleRow = (ListView) view.findViewById(R.id.lvDoubleRow);
        lvThreeRow = (ListView) view.findViewById(R.id.lvThreeRow);
        mRelativeLayout = (RelativeLayout) view.findViewById(R.id.mRelativeLayout);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.DropdownColumnView);
        if(typedArray != null){
            mSelectedIcon = typedArray.getDrawable(R.styleable.DropdownColumnView_columnSelectedIcon);
            if(mSelectedIcon == null)
                mSelectedIcon = getResources().getDrawable(R.drawable.ic_check);
            columnType = typedArray.getInt(R.styleable.DropdownColumnView_columnType,1);
        }
    }

    /**点击的button*/
    public DropdownColumnView setButton(DropdownButton button){
        this.button = button;
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getVisibility() == VISIBLE) {
                    DropdownUtils.hide();
                } else {
                    DropdownUtils.show(DropdownColumnView.this);
                }
            }
        });
        return this;
    }

    /**
     * 设置单列数据
     * @param singleRowList -- 单列数据（必填）
     * @return
     */
    public DropdownColumnView setSingleRowList(List<DropdownItemObject> singleRowList, int singleSelectedId){
        this.singleRowList = singleRowList;
        this.singleSelectedId = singleSelectedId;
        return this;
    }
    /**
     * 设置双列数据
     * @param doubleRowList -- 双列数据（为空默认为单列选择）
     * @return
     */
    public DropdownColumnView setDoubleRowList(List<DropdownItemObject> doubleRowList, int doubleSelectedId){
        this.doubleRowList = doubleRowList;
        this.doubleSelectedId = doubleSelectedId;
        return this;
    }
    /**
     * 设置三列数据
     * @param threeRowList  -- 三列数据（为空默认为双列选择）
     * @return
     */
    public DropdownColumnView setThreeRowList(List<DropdownItemObject> threeRowList, int threeSelectedId){
        this.threeRowList = threeRowList;
        this.threeSelectedId = threeSelectedId;
        return this;
    }

    /**
     * 设置任意view
     * @param randomView
     * @return
     */
    public DropdownColumnView setRandomView(int randomView){
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.randomView = layoutInflater.inflate(randomView, null);
        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        this.randomView.setLayoutParams(params);
        return this;
    }

    /**初始化*/
    public DropdownColumnView show(){
        //判断列表类型
        switch (columnType){
            case 1:
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) lvSingleRow.getLayoutParams();
                //获取当前控件的布局对象
                params.width = LayoutParams.MATCH_PARENT ;//设置当前控件布局的高度
                lvSingleRow.setLayoutParams(params);//将设置好的布局参数应用到控件中
                //设置默认选中按钮上的文字
                button.setText(DropdownUtils.getTitle(singleRowList,singleSelectedId));
                //单列
                SingleRow();
                break;
            case 2:
                params= (RelativeLayout.LayoutParams) lvDoubleRow.getLayoutParams();
                //获取当前控件的布局对象
                params.width = LayoutParams.MATCH_PARENT ;//设置当前控件布局的高度
                lvDoubleRow.setLayoutParams(params);//将设置好的布局参数应用到控件中
                lvDoubleRow.setVisibility(View.VISIBLE);
                //双列
                DoubleRowSingle();
                DoubleRow(singleSelectedId);
                break;
            case 3:
                params= (RelativeLayout.LayoutParams) lvThreeRow.getLayoutParams();
                //获取当前控件的布局对象
                params.width = LayoutParams.MATCH_PARENT ;//设置当前控件布局的高度
                lvThreeRow.setLayoutParams(params);//将设置好的布局参数应用到控件中
                lvDoubleRow.setVisibility(View.VISIBLE);
                lvThreeRow.setVisibility(View.VISIBLE);
                ThreeRowSingle();
                ThreeRowDouble(singleSelectedId);
                ThreeRow(singleSelectedId,doubleSelectedId);
                //设置默认选中按钮上的文字
                break;
            case 4:
                mRelativeLayout.removeAllViews();
                mRelativeLayout.addView(randomView);
                random.onRandom(randomView);
                break;
        }
        return this;
    }

    //单列加载数据
    public DropdownColumnView SingleRow(){
        finallyAdapter = new FinallyAdapter(context,mSelectedIcon,singleRowList,singleSelectedId);
        lvSingleRow.setAdapter(finallyAdapter);
        lvSingleRow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //获取选中的参数
                DropdownItemObject singleRowObject = singleRowList.get(position);
                finallyAdapter.setSelectedId(singleRowObject.getId());//设置选中 id
                finallyAdapter.notifyDataSetChanged();
                button.setText(singleRowObject.getText());

                DropdownUtils.hide();//点击后是否收起布局
                singleRow.onSingleChanged(singleRowObject);
            }
        });
        return this;
    }
    //双列加载数据
    public DropdownColumnView DoubleRowSingle(){
        //设置默认选中按钮上的文字
        button.setText(DropdownUtils.getTitle(doubleRowList,doubleSelectedId));

        selectAdapter = new SelectAdapter(context,mSelectedIcon,singleRowList,singleSelectedId);
        lvSingleRow.setAdapter(selectAdapter);
        lvSingleRow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //获取选中的参数
                DropdownItemObject singleRowObject = singleRowList.get(position);
                selectAdapter.setSelectedId(singleRowObject.getId());//设置选中 id
                selectAdapter.notifyDataSetChanged();
                button.setText(singleRowObject.getText());
//                DropdownUtils.hide();//点击后是否收起布局
                DoubleRow(singleRowObject.getId());
                doubleRow.onDoubleSingleChanged(singleRowObject);
            }
        });
        return this;
    }

    public DropdownColumnView DoubleRow(int singleSelectedId){
        final List<DropdownItemObject> itemRegionLinkage =
                DropdownUtils.getCurrentObj(doubleRowList,singleSelectedId);

        button.setText(DropdownUtils.getTitle(itemRegionLinkage,doubleSelectedId));

        finallyAdapter = new FinallyAdapter(context,mSelectedIcon,itemRegionLinkage,doubleSelectedId);
        lvDoubleRow.setAdapter(finallyAdapter);
        lvDoubleRow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //获取选中的参数
                DropdownItemObject doubleRowObject = itemRegionLinkage.get(position);
//                doubleSelectedId = doubleRowObject.getId();
                finallyAdapter.setSelectedId(doubleRowObject.getId());//设置选中 id
                button.setText(doubleRowObject.getValue());
                finallyAdapter.notifyDataSetChanged();

                DropdownUtils.hide();//点击后是否收起布局
                doubleRow.onDoubleChanged(doubleRowObject);
            }
        });
        return this;
    }

    //三列加载数据
    public DropdownColumnView ThreeRowSingle(){
        //设置默认选中按钮上的文字
        button.setText(DropdownUtils.getTitle(doubleRowList,doubleSelectedId));

        selectAdapter = new SelectAdapter(context,mSelectedIcon,singleRowList,singleSelectedId);
        lvSingleRow.setAdapter(selectAdapter);
        lvSingleRow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //获取选中的参数
                DropdownItemObject singleRowObject = singleRowList.get(position);

                selectAdapter.setSelectedId(singleRowObject.getId());//设置选中 id
                selectAdapter.notifyDataSetChanged();
                button.setText(singleRowObject.getText());
//                DropdownUtils.hide();//点击后是否收起布局
                ThreeRowDouble(singleRowObject.getId());
                ThreeRow(singleRowObject.getId(),doubleSelectedId);
                threeRow.onThreeSingleChanged(singleRowObject);
            }
        });
        return this;
    }

    public DropdownColumnView ThreeRowDouble(final int singleSelectedId){
        final List<DropdownItemObject> itemRegionLinkage =
                DropdownUtils.getCurrentObj(doubleRowList,singleSelectedId);

        button.setText(DropdownUtils.getTitle(itemRegionLinkage,doubleSelectedId));

        selectDoubleAdapter = new SelectAdapter(context,mSelectedIcon,itemRegionLinkage,doubleSelectedId);
        lvDoubleRow.setAdapter(selectDoubleAdapter);
        lvDoubleRow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //获取选中的参数
                DropdownItemObject doubleRowObject = itemRegionLinkage.get(position);

                selectDoubleAdapter.setSelectedId(doubleRowObject.getId());//设置选中 id
                button.setText(doubleRowObject.getValue());
                selectDoubleAdapter.notifyDataSetChanged();
                ThreeRow(singleSelectedId,doubleRowObject.getId());
//                DropdownUtils.hide();//点击后是否收起布局
                threeRow.onThreeDoubleChanged(doubleRowObject);
            }
        });
        return this;
    }
    public DropdownColumnView ThreeRow(int singleSelectedId, int doubleSelectedId){

        final List<DropdownItemObject> itemRegionLinkage =
                DropdownUtils.getCurrentObj(threeRowList,singleSelectedId,doubleSelectedId);

        button.setText(DropdownUtils.getTitle(itemRegionLinkage,threeSelectedId));

        finallyAdapter = new FinallyAdapter(context,mSelectedIcon,itemRegionLinkage,threeSelectedId);
        lvThreeRow.setAdapter(finallyAdapter);
        lvThreeRow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //获取选中的参数
                DropdownItemObject threeRowObject = itemRegionLinkage.get(position);
//                doubleSelectedId = doubleRowObject.getId();
                finallyAdapter.setSelectedId(threeRowObject.getId());//设置选中 id
                button.setText(threeRowObject.getValue());
                finallyAdapter.notifyDataSetChanged();

                DropdownUtils.hide();//点击后是否收起布局
                threeRow.onThreeChanged(threeRowObject);
            }
        });
        return this;
    }
}
