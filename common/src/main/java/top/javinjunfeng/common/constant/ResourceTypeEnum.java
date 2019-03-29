package top.javinjunfeng.common.constant;

public enum ResourceTypeEnum {

    DASH("dash"),
    FUNCTION("function"),
    VIEW("view");

    private String resourceType;


    ResourceTypeEnum(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getResourceType() {
        return resourceType;
    }

    @Override
    public String toString() {
        return this.getResourceType();
    }

}
