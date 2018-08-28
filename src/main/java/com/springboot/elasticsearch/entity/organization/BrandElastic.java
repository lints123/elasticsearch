package com.springboot.elasticsearch.entity.organization;

public class BrandElastic {
    // 品牌id
    private String brandId;
    // 品牌名称
    private String name;
    // 组织id
    private String organizationId;

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }
}
