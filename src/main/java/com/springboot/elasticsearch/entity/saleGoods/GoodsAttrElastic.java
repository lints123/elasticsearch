package com.springboot.elasticsearch.entity.saleGoods;
/**
 * 商品属性Entity
 */
public class GoodsAttrElastic {

    // 产品id
    private String productId;
    // 商品属性关联表id
    private String prodGoodsRelationId;
    // 商品id
    private String saleGoodsId;
    // 产品属性表id
    private String proAttributeId;
    // 属性名称
    private String attributeName;
    // 属性值表id
    private String attributeValueId;
    // 属性值
    private String attributeValue;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProdGoodsRelationId() {
        return prodGoodsRelationId;
    }

    public void setProdGoodsRelationId(String prodGoodsRelationId) {
        this.prodGoodsRelationId = prodGoodsRelationId;
    }

    public String getSaleGoodsId() {
        return saleGoodsId;
    }

    public void setSaleGoodsId(String saleGoodsId) {
        this.saleGoodsId = saleGoodsId;
    }

    public String getProAttributeId() {
        return proAttributeId;
    }

    public void setProAttributeId(String proAttributeId) {
        this.proAttributeId = proAttributeId;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getAttributeValueId() {
        return attributeValueId;
    }

    public void setAttributeValueId(String attributeValueId) {
        this.attributeValueId = attributeValueId;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }
}
