package com.springboot.elasticsearch.entity.organization;

import java.util.List;

public class OrganGoodsElastic {
    // 组织id
    private String organizationId;
    // 商品id
    private String saleGoodsId;
    // 商品名称
    private String name;
    // 品牌表
    private List<BrandElastic> brandElasticList;

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getSaleGoodsId() {
        return saleGoodsId;
    }

    public void setSaleGoodsId(String saleGoodsId) {
        this.saleGoodsId = saleGoodsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public List<BrandElastic> getBrandElasticList() {
        return brandElasticList;
    }

    public void setBrandElasticList(List<BrandElastic> brandElasticList) {
        this.brandElasticList = brandElasticList;
    }
}
