package fj.dropdownmenu.lib.utils;

import android.app.Activity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.ArrayList;
import java.util.List;

import fj.dropdownmenu.lib.R;
import fj.dropdownmenu.lib.ion.ViewUtils;
import fj.dropdownmenu.lib.pojo.DropdownItemObject;
import fj.dropdownmenu.lib.view.DropdownButton;
import fj.dropdownmenu.lib.view.DropdownColumnView;

/**
 * @author FengTong
 * @date 2017/8/17
 */
public class DropdownUtils {
    public static Animation dropdown_in;
    public static Animation dropdown_out;
    public static Animation dropdown_mask_out;
    public static View mask;

    public static DropdownColumnView currentDropdownList;

    public static void init(final Activity activity, View view){
        dropdown_in = AnimationUtils.loadAnimation(activity, R.anim.dropdown_in);
        dropdown_out = AnimationUtils.loadAnimation(activity, R.anim.dropdown_out);
        dropdown_mask_out = AnimationUtils.loadAnimation(activity, R.anim.dropdown_mask_out);
        mask = view;
        mask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hide();
            }
        });
        dropdown_mask_out.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}
            @Override
            public void onAnimationEnd(Animation animation) {
                if (currentDropdownList == null)
                    ViewUtils.injectViews(activity,mask);
            }
            @Override
            public void onAnimationRepeat(Animation animation) {}
        });
    }

    public static void initFragment(final Activity activity,final Object target, final View view, View v){
        dropdown_in = AnimationUtils.loadAnimation(activity, R.anim.dropdown_in);
        dropdown_out = AnimationUtils.loadAnimation(activity, R.anim.dropdown_out);
        dropdown_mask_out = AnimationUtils.loadAnimation(activity, R.anim.dropdown_mask_out);
        mask = v;
        mask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hide();
            }
        });
        dropdown_mask_out.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}
            @Override
            public void onAnimationEnd(Animation animation) {
                if (currentDropdownList == null)
                    ViewUtils.injectFragmentViews(target,view,mask);
            }
            @Override
            public void onAnimationRepeat(Animation animation) {}
        });
    }

    public static void show(DropdownColumnView view) {
        if (currentDropdownList != null) {
            currentDropdownList.clearAnimation();
            currentDropdownList.startAnimation(dropdown_out);
            currentDropdownList.setVisibility(View.GONE);
            currentDropdownList.button.setChecked(false);
        }
        currentDropdownList = view;
        mask.clearAnimation();
        mask.setVisibility(View.VISIBLE);
        currentDropdownList.clearAnimation();
        currentDropdownList.startAnimation(dropdown_in);
        currentDropdownList.setVisibility(View.VISIBLE);
        currentDropdownList.button.setChecked(true);
    }

    public static void hide() {
        if (currentDropdownList != null) {
            currentDropdownList.clearAnimation();
            currentDropdownList.startAnimation(dropdown_out);
            currentDropdownList.button.setChecked(false);
            mask.clearAnimation();
            mask.startAnimation(dropdown_mask_out);
        }
        currentDropdownList = null;
    }

    /**
     * 获取当前选中的obj
     * @param itemRegionLinkageAll--所有数据
     * @param parentId --父id
     * @return obj
     */
    public static List<DropdownItemObject> getCurrentObj(
            List<DropdownItemObject> itemRegionLinkageAll,
            int parentId)
    {
        List<DropdownItemObject> itemRegionLinkage = new ArrayList<>();//初始化地区子分类(当前项)
        //获取所有数据，根据条件查出当前选择项的子分类数据
        for (int i=0;i<itemRegionLinkageAll.size();i++){
            //itemRegionLinkageAll.get(i).getParentId()//子分类id
            //lvRegion.getCurrent().getId()当前选中的父分类
            //当这两个ID相等就说明这个子分类的数据属于父分类
            //itemRegionLinkageAll.get(i).getParentId() == -1（-1属于全部分类）
            if(itemRegionLinkageAll.get(i).getParentId() == parentId){
                itemRegionLinkage.add(itemRegionLinkageAll.get(i));
            }
        }
        return itemRegionLinkage;
    }

    /**
     * 获取当前选中的obj
     * @param itemRegionLinkageAll--所有数据
     * @param topParentId --顶父id
     * @param parentId --父id
     * @return obj
     */
    public static List<DropdownItemObject> getCurrentObj(
            List<DropdownItemObject> itemRegionLinkageAll,
            int topParentId,int parentId)
    {
        List<DropdownItemObject> itemRegionLinkage = new ArrayList<>();//初始化地区子分类(当前项)
        //获取所有数据，根据条件查出当前选择项的子分类数据
        for (int i=0;i<itemRegionLinkageAll.size();i++){
            //itemRegionLinkageAll.get(i).getParentId()//子分类id
            //lvRegion.getCurrent().getId()当前选中的父分类
            //当这两个ID相等就说明这个子分类的数据属于父分类
            //itemRegionLinkageAll.get(i).getParentId() == -1（-1属于全部分类）
            if(itemRegionLinkageAll.get(i).getParentId() == parentId &&
                    itemRegionLinkageAll.get(i).getTopParentId() == topParentId){
                itemRegionLinkage.add(itemRegionLinkageAll.get(i));
            }
        }
        return itemRegionLinkage;
    }

    /**
     * 获取对应id显示文字
     * @param list --list
     * @param id --id
     * @return 文字
     */
    public static String getTitle(List<DropdownItemObject> list, int id){
        String str = "";
        //设置默认选中按钮上的文字
        for (DropdownItemObject dropdownItemObject : list){
            if(dropdownItemObject.getId() == id){
                str = dropdownItemObject.getText();
                break;
            }
        }
        return str;
    }
}
