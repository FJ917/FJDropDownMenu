package fj.dropdownmenu.lib.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import fj.dropdownmenu.lib.R;


public class DropdownButton extends RelativeLayout {
    private TextView textView;
    private View bottomLine;

    /** 是否显示横线 */
    private boolean isLine = true;
    /** 选中文字颜色 */
    private int mSelectedTextColor;
    /** 选中图标*/
    private Drawable mSelectedIcon;
    /** 选中横线颜色*/
    private int mLineColor;

    /** 未选中文字颜色 */
    private int mNotSelectedTextColor;
    /** 未选中图标*/
    private Drawable mNotSelectedIcon;

    private boolean checked = false;
    public DropdownButton(Context context) {
        this(context, null);
    }

    public DropdownButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DropdownButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.dropdown_button, this, true);
        textView = (TextView) findViewById(R.id.textView);
        bottomLine = findViewById(R.id.bottomLine);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.DropdownButton);
        if (typedArray != null) {
            isLine = typedArray.getBoolean(R.styleable.DropdownButton_isLine,true);

            mSelectedTextColor = typedArray.getColor(R.styleable.DropdownButton_selectedTextColor,
                    getResources().getColor(R.color.blue));

            mSelectedIcon = typedArray.getDrawable(R.styleable.DropdownButton_selectedIcon);
                    if(mSelectedIcon == null)
                        mSelectedIcon = getResources().getDrawable(R.drawable.ic_up);

            mLineColor = typedArray.getColor(R.styleable.DropdownButton_lineColor,
                    getResources().getColor(R.color.blue));

            mNotSelectedTextColor = typedArray.getColor(R.styleable.DropdownButton_notSelectedTextColor,
                    getResources().getColor(R.color.font_black_content));

            mNotSelectedIcon = typedArray.getDrawable(R.styleable.DropdownButton_notSelectedIcon);
            if(mNotSelectedIcon == null)
                mNotSelectedIcon = getResources().getDrawable(R.drawable.ic_dn);

        }
        textView.setTextColor(mNotSelectedTextColor);
        textView.setCompoundDrawablesWithIntrinsicBounds(null, null, mNotSelectedIcon, null);
    }


    public void setText(CharSequence text) {
        textView.setText(text);
    }

    public boolean getChecked(){
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
        Drawable drawable;
        if (checked) {
            drawable = mSelectedIcon;
            textView.setTextColor(mSelectedTextColor);
            bottomLine.setBackgroundColor(mLineColor);
            if (isLine) {//是否显示横线
                bottomLine.setVisibility(VISIBLE);
            }
        } else {
            drawable = mNotSelectedIcon;
            textView.setTextColor(mNotSelectedTextColor);
            bottomLine.setVisibility(GONE);
        }
        textView.setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null);
    }

}
