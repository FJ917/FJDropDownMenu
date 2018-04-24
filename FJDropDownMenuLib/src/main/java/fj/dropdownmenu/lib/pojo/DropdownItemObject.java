package fj.dropdownmenu.lib.pojo;

public class DropdownItemObject {

    public int    id;       //itemID
    public String text;     //显示文本
    public String value;    //值
    public int    parentId; //父类id
    public int    topParentId; //顶级父类id

    public DropdownItemObject() {

    }

    public DropdownItemObject(int id, String text, String value) {
        this.id = id;
        this.text = text;
        this.value = value;
    }

    public DropdownItemObject(int parentId, int id, String text, String value) {
        this.parentId = parentId;
        this.id = id;
        this.text = text;
        this.value = value;
    }

    public DropdownItemObject(int topParentId,int parentId, int id, String text, String value) {
        this.topParentId = topParentId;
        this.parentId = parentId;
        this.id = id;
        this.text = text;
        this.value = value;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getTopParentId() {
        return topParentId;
    }

    public void setTopParentId(int topParentId) {
        this.topParentId = topParentId;
    }
}
