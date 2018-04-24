package fj.dropdownmenu.test.bean;

import java.util.ArrayList;
import java.util.List;

import fj.dropdownmenu.lib.pojo.DropdownItemObject;

/**
 * @author FengTong
 * @date 2017/8/22
 */
public class DataBean {

    /**
     * 获取分类数据
     * @return itemType
     */
    public static List<DropdownItemObject> getType(){
        List<DropdownItemObject> itemType = new ArrayList<>();//分类
        DropdownItemObject typeObj = new DropdownItemObject(-1, "全部分类", "全部分类");
        itemType.add(typeObj);
        for (int i = 0; i < 10; i++) {
            typeObj = new DropdownItemObject(i, "分类" + i, "分类" + i);
            itemType.add(typeObj);
        }
        return itemType;
    }

    /**
     * 获取动物一级数据
     * @return itemType
     */
    public static List<DropdownItemObject> getAnimalSingle(){
        List<DropdownItemObject> itemAnimal = new ArrayList<>();//动物
        DropdownItemObject animalObj = new DropdownItemObject(-1, "全部动物", "全部动物");
        itemAnimal.add(animalObj);
        animalObj = new DropdownItemObject(1, "狗", "狗");
        itemAnimal.add(animalObj);
        animalObj = new DropdownItemObject(2, "猫", "猫");
        itemAnimal.add(animalObj);
        return itemAnimal;
    }

    /**
     * 获取动物二级数据
     * @return itemType
     */
    public static List<DropdownItemObject> getAnimalDouble(){
        List<DropdownItemObject> itemAnimalDouble = new ArrayList<>();//所有动物子分类
        DropdownItemObject animalObj = new DropdownItemObject(-1, -1, "全部动物", "全部动物");
        itemAnimalDouble.add(animalObj);

        animalObj = new DropdownItemObject(1, -1, "全部狗", "全部狗");
        itemAnimalDouble.add(animalObj);
        animalObj = new DropdownItemObject(1, 1, "藏獒", "藏獒");
        itemAnimalDouble.add(animalObj);
        animalObj = new DropdownItemObject(1, 2, "二哈", "二哈");
        itemAnimalDouble.add(animalObj);
        animalObj = new DropdownItemObject(1, 3, "土狗", "土狗");
        itemAnimalDouble.add(animalObj);

        animalObj = new DropdownItemObject(2, -1, "全部猫", "全部猫");
        itemAnimalDouble.add(animalObj);
        animalObj = new DropdownItemObject(2, 1, "暹罗", "暹罗");
        itemAnimalDouble.add(animalObj);
        animalObj = new DropdownItemObject(2, 2, "波斯", "波斯");
        itemAnimalDouble.add(animalObj);
        return itemAnimalDouble;
    }


    /**
     * 获取地区省数据
     * @return itemType
     */
    public static List<DropdownItemObject> getRegionProvince(){
        List<DropdownItemObject> regionProvinceList = new ArrayList<>();//地区
        DropdownItemObject regionProvinceObj = new DropdownItemObject(-1, "全部地区", "全部地区");
        regionProvinceList.add(regionProvinceObj);
        regionProvinceObj = new DropdownItemObject(1, "云南", "云南");
        regionProvinceList.add(regionProvinceObj);
        regionProvinceObj = new DropdownItemObject(2, "四川", "四川");
        regionProvinceList.add(regionProvinceObj);
        regionProvinceObj = new DropdownItemObject(3, "江苏", "江苏");
        regionProvinceList.add(regionProvinceObj);
        return regionProvinceList;
    }

    /**
     * 获取地区市级数据
     * @return itemType
     */
    public static List<DropdownItemObject> getRegionCity(){
        List<DropdownItemObject> regionCityList = new ArrayList<>();//所有二级
        DropdownItemObject regionCityObj  = new DropdownItemObject(-1, -1, "全部市", "全部市");
        regionCityList.add(regionCityObj);

        regionCityObj = new DropdownItemObject(1, -1, "全部市", "全部市");
        regionCityList.add(regionCityObj);
        regionCityObj = new DropdownItemObject(1, 1, "昆明", "昆明");
        regionCityList.add(regionCityObj);
        regionCityObj = new DropdownItemObject(1, 2, "红河州", "红河州");
        regionCityList.add(regionCityObj);
        regionCityObj = new DropdownItemObject(1, 3, "曲靖", "曲靖");
        regionCityList.add(regionCityObj);

        regionCityObj = new DropdownItemObject(2, -1, "全部市", "全部市");
        regionCityList.add(regionCityObj);
        regionCityObj = new DropdownItemObject(2, 1, "成都", "成都");
        regionCityList.add(regionCityObj);
        regionCityObj = new DropdownItemObject(2, 2, "攀枝花", "攀枝花");
        regionCityList.add(regionCityObj);
        regionCityObj = new DropdownItemObject(2, 3, "攀枝花", "攀枝花");
        regionCityList.add(regionCityObj);

        regionCityObj = new DropdownItemObject(3, -1, "全部市", "全部市");
        regionCityList.add(regionCityObj);
        regionCityObj = new DropdownItemObject(3, 1, "南京", "南京");
        regionCityList.add(regionCityObj);
        regionCityObj = new DropdownItemObject(3, 2, "无锡", "无锡");
        regionCityList.add(regionCityObj);
        regionCityObj = new DropdownItemObject(3, 3, "徐州", "徐州");
        regionCityList.add(regionCityObj);
        return regionCityList;
    }

    /**
     * 获取地区区数据
     * @return itemType
     */
    public static List<DropdownItemObject> getRegionArea(){
        List<DropdownItemObject> regionAreaList = new ArrayList<>();//所有区
        DropdownItemObject regionAreaObj = new DropdownItemObject(-1, -1, -1, "全部区", "全部区");
        regionAreaList.add(regionAreaObj);

        regionAreaObj = new DropdownItemObject(1, -1, -1, "全部区", "全部区");
        regionAreaList.add(regionAreaObj);

        //-------------云南---------
        regionAreaObj = new DropdownItemObject(1, 1, -1, "全部区", "全部区");
        regionAreaList.add(regionAreaObj);
        regionAreaObj = new DropdownItemObject(1, 1, 1, "五华区", "五华区");
        regionAreaList.add(regionAreaObj);
        regionAreaObj = new DropdownItemObject(1, 1, 2, "盘龙区", "盘龙区");
        regionAreaList.add(regionAreaObj);

        regionAreaObj = new DropdownItemObject(1, 2, -1, "全部区", "全部区");
        regionAreaList.add(regionAreaObj);
        regionAreaObj = new DropdownItemObject(1, 2, 1, "蒙自", "蒙自");
        regionAreaList.add(regionAreaObj);
        regionAreaObj = new DropdownItemObject(1, 2, 2, "建水", "建水");
        regionAreaList.add(regionAreaObj);

        regionAreaObj = new DropdownItemObject(1, 3, -1, "全部区", "全部区");
        regionAreaList.add(regionAreaObj);
        regionAreaObj = new DropdownItemObject(1, 3, 1, "麒麟区", "麒麟区");
        regionAreaList.add(regionAreaObj);
        regionAreaObj = new DropdownItemObject(1, 3, 2, "沾益区", "沾益区");
        regionAreaList.add(regionAreaObj);



        //--------------四川-------
        regionAreaObj = new DropdownItemObject(2, -1, -1, "全部区", "全部区");
        regionAreaList.add(regionAreaObj);

        regionAreaObj = new DropdownItemObject(2, 1, -1, "全部区", "全部区");
        regionAreaList.add(regionAreaObj);
        regionAreaObj = new DropdownItemObject(2, 1, 1, "锦江区", "锦江区");
        regionAreaList.add(regionAreaObj);
        regionAreaObj = new DropdownItemObject(2, 1, 2, "青羊区", "青羊区");
        regionAreaList.add(regionAreaObj);

        regionAreaObj = new DropdownItemObject(2, 2, -1, "全部区", "全部区");
        regionAreaList.add(regionAreaObj);
        regionAreaObj = new DropdownItemObject(2, 2, 1, "东区", "东区");
        regionAreaList.add(regionAreaObj);
        regionAreaObj = new DropdownItemObject(2, 2, 2, "西区", "西区");
        regionAreaList.add(regionAreaObj);

        regionAreaObj = new DropdownItemObject(2, 3, -1, "全部区", "全部区");
        regionAreaList.add(regionAreaObj);
        regionAreaObj = new DropdownItemObject(2, 3, 1, "自流井区", "自流井区");
        regionAreaList.add(regionAreaObj);
        regionAreaObj = new DropdownItemObject(2, 3, 2, "贡井区", "贡井区");
        regionAreaList.add(regionAreaObj);


        //------------------江苏--------------
        regionAreaObj = new DropdownItemObject(3, -1, -1, "全部区", "全部区");
        regionAreaList.add(regionAreaObj);

        regionAreaObj = new DropdownItemObject(3, 1, -1, "全部区", "全部区");
        regionAreaList.add(regionAreaObj);
        regionAreaObj = new DropdownItemObject(3, 1, 1, "玄武区", "玄武区");
        regionAreaList.add(regionAreaObj);
        regionAreaObj = new DropdownItemObject(3, 1, 2, "秦淮区", "秦淮区");
        regionAreaList.add(regionAreaObj);

        regionAreaObj = new DropdownItemObject(3, 2, -1, "全部区", "全部区");
        regionAreaList.add(regionAreaObj);
        regionAreaObj = new DropdownItemObject(3, 2, 1, "锡山区", "锡山区");
        regionAreaList.add(regionAreaObj);
        regionAreaObj = new DropdownItemObject(3, 2, 2, "惠山区", "惠山区");
        regionAreaList.add(regionAreaObj);

        regionAreaObj = new DropdownItemObject(3, 3, -1, "全部区", "全部区");
        regionAreaList.add(regionAreaObj);
        regionAreaObj = new DropdownItemObject(3, 3, 1, "鼓楼区", "鼓楼区");
        regionAreaList.add(regionAreaObj);
        regionAreaObj = new DropdownItemObject(3, 3, 2, "云龙区", "云龙区");
        regionAreaList.add(regionAreaObj);
        return regionAreaList;
    }
}
