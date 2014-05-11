package cn.szboc.platform.modules.parameter.domain;

public enum ParameterItemType {

    PACKAGE("0"), PARAMETER("1");

    ParameterItemType(String type) {
        this.type = type;
    }

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.getType();
    }

    /**
     * 根据构造参数返回对应类型
     */
    public static ParameterItemType getInstance(String type) {
        if(type == null){
            return null;
        }
        for (ParameterItemType itemType : ParameterItemType.values()) {
            if (itemType.toString().equals(type)) {
                return itemType;
            }
        }
        throw new IllegalArgumentException("ParameterItemType枚举类型中没有对应值为" + type + "的项目");
    }

}
