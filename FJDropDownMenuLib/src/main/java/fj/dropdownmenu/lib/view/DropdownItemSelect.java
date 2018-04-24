package fj.dropdownmenu.lib.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import fj.dropdownmenu.lib.R;


/**
 * 选择过程中的item
 */
public class DropdownItemSelect extends TextView {
    public DropdownItemSelect(Context context) {
        this(context,null);
    }

    public DropdownItemSelect(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    public DropdownItemSelect(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void bind(CharSequence text, boolean checked){
        setText(text);
        if (checked){
            setBackgroundResource(R.color.stand_bg);
        }else{
            setBackgroundResource(R.color.white);
        }
    }


}
