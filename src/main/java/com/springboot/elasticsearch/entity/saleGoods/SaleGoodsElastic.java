package com.springboot.elasticsearch.entity.saleGoods;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;
import java.util.List;

@Document(indexName = "#{esAttribute.indexSaleGoodsNew}", type = "#{esAttribute.typeSaleGoodsNew}")
public class SaleGoodsElastic {
    @Id
    @Field(type = FieldType.String)
    private String saleGoodsId; // ID
    @Field(type = FieldType.String, index = FieldIndex.analyzed)
    private String name;// 名称
    @Field(type = FieldType.Integer)
    private Integer status;// 状态
    // 商品所属企业id
    @Field(type = FieldType.String ,index = FieldIndex.not_analyzed)
    private String organizationId;
    // 商品所属企业名称
    @Field(type = FieldType.String, index = FieldIndex.analyzed)
    private String organizationName;

    // 商品创建时间
    @Field(type = FieldType.Date)
    private Date createTime;

    // 商品价格
    @Field(type = FieldType.Integer)
    private Integer price;

    // 商品所属目录id
    @Field(type = FieldType.String ,index = FieldIndex.not_analyzed)
    private String goodsContentsId;

    // 商品所属目录名称
    private String contentsName;

    // 商品的属性列表
    private List<GoodsAttrElastic> goodsAttrElasticList;

    // 商品所属店铺列表
    private List<ShopElastic> shopElasticList;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getGoodsContentsId() {
        return goodsContentsId;
    }

    public void setGoodsContentsId(String goodsContentsId) {
        this.goodsContentsId = goodsContentsId;
    }

    public String getContentsName() {
        return contentsName;
    }

    public void setContentsName(String contentsName) {
        this.contentsName = contentsName;
    }

    public List<GoodsAttrElastic> getGoodsAttrElasticList() {
        return goodsAttrElasticList;
    }

    public void setGoodsAttrElasticList(List<GoodsAttrElastic> goodsAttrElasticList) {
        this.goodsAttrElasticList = goodsAttrElasticList;
    }

    public List<ShopElastic> getShopElasticList() {
        return shopElasticList;
    }

    public void setShopElasticList(List<ShopElastic> shopElasticList) {
        this.shopElasticList = shopElasticList;
    }
}
