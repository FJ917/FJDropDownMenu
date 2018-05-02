package fj.dropdownmenu.lib.ion;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;

import fj.dropdownmenu.lib.view.DropdownButton;
import fj.dropdownmenu.lib.view.DropdownColumnView;

/**
 * @author FengTong
 * @date 2017/8/17
 */
public class ViewUtils {

    public static void injectContentView(Activity activity) {
        Class<?> clazz = activity.getClass();
        if (clazz.getAnnotations() != null){
            if (clazz.isAnnotationPresent(ContentView.class)) {
                // 得到activity这个类的ContentView注解
                ContentView inject = clazz.getAnnotation(ContentView.class);
                int layoutId = inject.value();
                activity.setContentView(layoutId);
            }
        }
    }

    public static void injectViews(Activity activity, View view) {
        view.clearAnimation();
        view.setVisibility(View.GONE);
        Class a = activity.getClass();
        Field[] fields = a.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(ViewInject.class)) {
                ViewInject viewInject = field.getAnnotation(ViewInject.class);
                if(field.getType().getName().equals("fj.dropdownmenu.lib.view.DropdownButton")){
                    DropdownButton dropdownButton = (DropdownButton) activity.findViewById(viewInject.value());
                    dropdownButton.setChecked(false);
                }
                if(field.getType().getName().equals("fj.dropdownmenu.lib.view.DropdownColumnView")){
                    DropdownColumnView dropdownColumnView = (DropdownColumnView) activity.findViewById(viewInject.value());
                    dropdownColumnView.setVisibility(View.GONE);
                    dropdownColumnView.clearAnimation();
                }
            }
        }
    }

    public static void injectFragmentViews(Object target,View view, View mask) {
        mask.clearAnimation();
        mask.setVisibility(View.GONE);
        Class a = target.getClass();
        Field[] fields = a.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(ViewInject.class)) {
                ViewInject viewInject = field.getAnnotation(ViewInject.class);
                if(field.getType().getName().equals("fj.dropdownmenu.lib.view.DropdownButton")){
                    DropdownButton dropdownButton = (DropdownButton) view.findViewById(viewInject.value());
                    dropdownButton.setChecked(false);
                }
                if(field.getType().getName().equals("fj.dropdownmenu.lib.view.DropdownColumnView")){
                    DropdownColumnView dropdownColumnView = (DropdownColumnView) view.findViewById(viewInject.value());
                    dropdownColumnView.setVisibility(View.GONE);
                    dropdownColumnView.clearAnimation();
                }
            }
        }
    }
}
