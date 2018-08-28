package com.springboot.elasticsearch.entity.saleGoods;
public class ShopElastic {
    // 店铺id
    private String shopId;
    // 店铺名称
    private String shopName;
    // 商品id
    private String saleGoodsId;

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

    public String getSaleGoodsId() {
        return saleGoodsId;
    }

    public void setSaleGoodsId(String saleGoodsId) {
        this.saleGoodsId = saleGoodsId;
    }
}
