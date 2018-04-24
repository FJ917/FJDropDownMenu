package fj.dropdownmenu.lib.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

import fj.dropdownmenu.lib.R;
import fj.dropdownmenu.lib.pojo.DropdownItemObject;

/**
 * SingleRow adapter
 * @author FengTong
 */
public class FinallyAdapter extends BaseAdapter {
    private Drawable mSelectedIcon;//选中的图标
    private List<DropdownItemObject> brandsList;//数据
    private int selectedId;//默认选中id
    private LayoutInflater mInflater;
    public FinallyAdapter(Context context,
                          Drawable mSelectedIcon,
                          List<DropdownItemObject> mList,
                          int selectedId){
        this.mSelectedIcon = mSelectedIcon;
        this.brandsList = mList;
        this.selectedId = selectedId;
        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    public void setSelectedId(int selectedId){
        this.selectedId = selectedId;
    }
    @Override
    public int getCount() {
        return brandsList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = mInflater.inflate(R.layout.adapter_single_row,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.llItem = (LinearLayout) convertView.findViewById(R.id.llItem);
            viewHolder.tvTitle = (TextView)convertView.findViewById(R.id.tvTitle);
            viewHolder.ivSelect = (ImageView) convertView.findViewById(R.id.ivSelect);
            viewHolder.rbSelect = (RadioButton)convertView.findViewById(R.id.rbSelect);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }
        viewHolder.tvTitle.setText(brandsList.get(position).getText());
        viewHolder.llItem.setBackgroundResource(R.color.stand_bg);
        //设置选中图标
        viewHolder.ivSelect.setImageDrawable(mSelectedIcon);
        if(selectedId == brandsList.get(position).getId()){
            //选中RadioButton
            viewHolder.rbSelect.setChecked(true);
            //处于最后一次选择显示选中图标
            viewHolder.ivSelect.setVisibility(View.VISIBLE);
        } else{
            //取消选中RadioButton
            viewHolder.rbSelect.setChecked(false);
            //没有选中，隐藏选中图标
            viewHolder.ivSelect.setVisibility(View.GONE);
        }
        return convertView;
    }
    private class ViewHolder{
        LinearLayout llItem;
        TextView tvTitle;
        ImageView ivSelect;
        RadioButton rbSelect;
    }
}
