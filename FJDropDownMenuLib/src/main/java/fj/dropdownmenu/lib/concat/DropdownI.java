package fj.dropdownmenu.lib.concat;

import android.view.View;

import fj.dropdownmenu.lib.pojo.DropdownItemObject;

/**
 * @author FengTong
 * @date 2017/8/17
 */
public interface DropdownI {
    interface SingleRow {
        void onSingleChanged(DropdownItemObject singleRowObject);//单列点击事件
    }
    interface DoubleRow {
        void onDoubleSingleChanged(DropdownItemObject singleRowObject);//单列点击事件
        void onDoubleChanged(DropdownItemObject doubleRowObject);//双列点击事件
    }
    interface ThreeRow {
        void onThreeSingleChanged(DropdownItemObject singleRowObject);//单列点击事件
        void onThreeDoubleChanged(DropdownItemObject doubleRowObject);//双列点击事件
        void onThreeChanged(DropdownItemObject threeRowObject);//三列点击事件
    }

    interface RandomView{
        void onRandom(View view);//任意view
    }
}
