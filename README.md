# 下拉筛选菜单
![栗子配图.png](https://upload-images.jianshu.io/upload_images/2071764-ff2a8e4bb30f9153.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

---

### 栗子惯例，先上GIF

![1222.gif](https://upload-images.jianshu.io/upload_images/2071764-aef735254b5af0b2.gif?imageMogr2/auto-orient/strip)



---


> ### 使用姿势

#### 引入
```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
dependencies {
    compile 'com.github.FJ917:FJDropDownMenu:v1.1'
}
```
#### 使用

#####更新v1.1版本
新增适配Fragment，使用区别在于，初始化的方法

```
DropdownUtils.initFragment(getActivity(),this,view, mask);
ViewUtils.injectFragmentViews(this,view, mask);
```
---

结构：由DropdownButton和DropdownColumnView构成
```
<fj.dropdownmenu.lib.view.DropdownButton
        android:layout_height="match_parent"
        android:layout_weight="match_parent" />
```
```
<fj.dropdownmenu.lib.view.DropdownColumnView
        app:columnType="singleRow"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
```

自定义属性attrs.xml

DropdownButton属性

|属性|说明|
|----|----|
|isLine|是否显示横线|
|selectedTextColor|选中文字颜色|
|selectedIcon|选中图标|
|lineColor|选中横线颜色|
|notSelectedTextColor|未选中文字颜色|
|notSelectedIcon|未选中图标|

DropdownColumnView属性

|属性|说明|
|----|----|
|columnSelectedIcon|列选中图标|
|columnType|singleRow(单列)，doubleRow(双列)，threeRow(三列)，randomView(任意布局)|

在java 代码中需要对DropdownButton和DropdownColumnView加上注解@ViewInject()
```
@ViewInject(R.id.btnRandomView)
DropdownButton btnRandomView;

@ViewInject(R.id.dcRandomView)
DropdownColumnView dcRandomView;
```

初始化
```
DropdownUtils.init(this, mask);
ViewUtils.injectViews(this, mask);
```

设置数据
```
//单列
lvType.setSingleRow(this)
        .setSingleRowList(DataBean.getType(), -1)  //单列数据
        .setButton(btnType) //按钮
        .show();
//双列
lvAnimal.setDoubleRow(this)
        .setSingleRowList(DataBean.getAnimalSingle(), -1)//单列数据
        .setDoubleRowList(DataBean.getAnimalDouble(), -1)//双列数据
        .setButton(btnAnimal)          //按钮
        .show();
//三列
lvRegion.setThreeRow(this)
        .setSingleRowList(DataBean.getRegionProvince(), -1)  //单列数据
        .setDoubleRowList(DataBean.getRegionCity(), -1)//双列数据
        .setThreeRowList(DataBean.getRegionArea(), -1)//三列数据
        .setButton(btnRegion) //按钮
        .show();
```

点击事件接口
```
implements DropdownI.SingleRow, DropdownI.DoubleRow,DropdownI.ThreeRow
```

```
/**
 * 单列表返回
 */
@Override
public void onSingleChanged(DropdownItemObject singleRowObject) {
    Log.d("类型",singleRowObject.getValue());
}
/**
 * 双列表返回
 */
@Override
public void onDoubleSingleChanged(DropdownItemObject singleRowObject) {
    Log.d("动物",singleRowObject.getValue());
}
@Override
public void onDoubleChanged(DropdownItemObject doubleRowObject) {
    Log.d("动物子类",doubleRowObject.getValue());
}
/**
 * 三列表返回
 */
@Override
public void onThreeSingleChanged(DropdownItemObject singleRowObject) {
    Log.d("省",singleRowObject.getValue());
}
@Override
public void onThreeDoubleChanged(DropdownItemObject doubleRowObject) {
    Log.d("市",doubleRowObject.getValue());
}
@Override
public void onThreeChanged(DropdownItemObject threeRowObject) {
    Log.d("区",threeRowObject.getValue());
}
```

任意布局

```
btnRandomView.setText("弹出自定义布局");
dcRandomView.setRandom(this)
        .setRandomView(R.layout.random_view)
        .setButton(btnRandomView) //按钮
        .show();
```
布局返回接口
```
implements DropdownI.RandomView
```

```
@Override
public void onRandom(View view) {
    Button btnRandom = (Button) view.findViewById(R.id.btnRandom);
    final EditText etRandom = (EditText) view.findViewById(R.id.etRandom);
    btnRandom.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(RandomViewActivity.this, etRandom.getText().toString(), Toast.LENGTH_SHORT).show();
            DropdownUtils.hide();//点击后是否收起布局
        }
    });
}
```


---


> **个人博客：[WWW.FJ917.COM](http://www.fj917.com)**<br>
> **简书：[www.jianshu.com/u/3d2770e6e489](http://www.jianshu.com/u/3d2770e6e489)**


|欢迎加入QQ交流群657206000[点我加入](http://shang.qq.com/wpa/qunwpa?idkey=9b454a6f01bd94d97e4c3f2771447a989ec77794eb5a563422263153c00f700d)|
|:---:|
|![QQ交流群：657206000](http://upload-images.jianshu.io/upload_images/2071764-bce605159bbceb2a.png)|
