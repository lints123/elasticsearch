package com.springboot.elasticsearch.entity.organization;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;
import java.util.List;

@Document(indexName = "#{esAttribute.indexOrganizationNew}", type = "#{esAttribute.typeOrganizationNew}")
public class OrganizationElastic {
    // 企业id
    @Id
    @Field(type = FieldType.String)
    private String organizationId;

    // 企业名称
    @Field(type = FieldType.String, index = FieldIndex.analyzed)
    private String organizationName;

    // 企业所属类型
    @Field(type = FieldType.String, index = FieldIndex.not_analyzed)
    private String organizationTypeId;

    // 企业简称
    @Field(type = FieldType.String, index = FieldIndex.analyzed)
    private String organizationShortName;

    @Field(type = FieldType.Integer)
    private String appId;

    // 创建时间
    @Field(type = FieldType.Date)
    private Date enterDate;

    // 企业编号
    @Field(type = FieldType.String)
    private String organizationCode;

    // 企业商品销量
    @Field(type = FieldType.Integer)
    private Integer volume;

    // 企业代理数
    @Field(type = FieldType.Integer)
    private Integer dlQuota;

    // 店铺id
    @Field(type = FieldType.String ,index = FieldIndex.not_analyzed)
    private String shopId;

    // 店铺名称
    @Field(type = FieldType.String, index = FieldIndex.analyzed)
    private String shopName;

    // 商品表
    private List<OrganGoodsElastic> organGoodsElasticList;

    // 线下网点表
    private List<UnderLineDotElastic> underLineDotElasticList;

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationTypeId() {
        return organizationTypeId;
    }

    public void setOrganizationTypeId(String organizationTypeId) {
        this.organizationTypeId = organizationTypeId;
    }

    public String getOrganizationShortName() {
        return organizationShortName;
    }

    public void setOrganizationShortName(String organizationShortName) {
        this.organizationShortName = organizationShortName;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public Date getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(Date enterDate) {
        this.enterDate = enterDate;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public List<OrganGoodsElastic> getOrganGoodsElasticList() {
        return organGoodsElasticList;
    }

    public void setOrganGoodsElasticList(List<OrganGoodsElastic> organGoodsElasticList) {
        this.organGoodsElasticList = organGoodsElasticList;
    }

    public List<UnderLineDotElastic> getUnderLineDotElasticList() {
        return underLineDotElasticList;
    }

    public void setUnderLineDotElasticList(List<UnderLineDotElastic> underLineDotElasticList) {
        this.underLineDotElasticList = underLineDotElasticList;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Integer getDlQuota() {
        return dlQuota;
    }

    public void setDlQuota(Integer dlQuota) {
        this.dlQuota = dlQuota;
    }
}
