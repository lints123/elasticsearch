package com.springboot.elasticsearch.elastic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EsAttribute {
    // 商品详情的索引名
    @Value("${index.name.salegoods.new}")
    private String indexSaleGoodsNew;

    // 商品详情索引中的type名
    @Value("${index.type.salegoods.new}")
    private String typeSaleGoodsNew;

    // 新需求（查询企业所有关联的信息，比如商品，店铺，线下网点，商品的品牌）
    @Value("${index.name.organization.new}")
    private String indexOrganizationNew;

    @Value("${index.type.organization.new}")
    private String typeOrganizationNew;

    public String getIndexSaleGoodsNew() {
        return indexSaleGoodsNew;
    }

    public void setIndexSaleGoodsNew(String indexSaleGoodsNew) {
        this.indexSaleGoodsNew = indexSaleGoodsNew;
    }

    public String getTypeSaleGoodsNew() {
        return typeSaleGoodsNew;
    }

    public void setTypeSaleGoodsNew(String typeSaleGoodsNew) {
        this.typeSaleGoodsNew = typeSaleGoodsNew;
    }

    public String getIndexOrganizationNew() {
        return indexOrganizationNew;
    }

    public void setIndexOrganizationNew(String indexOrganizationNew) {
        this.indexOrganizationNew = indexOrganizationNew;
    }

    public String getTypeOrganizationNew() {
        return typeOrganizationNew;
    }

    public void setTypeOrganizationNew(String typeOrganizationNew) {
        this.typeOrganizationNew = typeOrganizationNew;
    }
}
