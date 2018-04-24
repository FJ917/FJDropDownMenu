package fj.dropdownmenu.lib.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

import fj.dropdownmenu.lib.R;

/**
 * 最终选中的列item
 */
public class DropdownItemFinally extends TextView {

    private Drawable mSelectedIcon = getResources().getDrawable(R.drawable.ic_check);//选中图标

    public DropdownItemFinally(Context context) {
        this(context,null);
    }

    public DropdownItemFinally(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    public DropdownItemFinally(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**设置图标*/
    public DropdownItemFinally setSelectedIcon(Drawable icon){
        mSelectedIcon = icon;
        return this;
    }

    public void bind(CharSequence text, boolean checked){
        setText(text);
        if (checked){
            Drawable icon = mSelectedIcon;
            setCompoundDrawablesWithIntrinsicBounds(null,null,icon,null);
        }else{
            setCompoundDrawablesWithIntrinsicBounds(null,null,null,null);
        }
    }


}
