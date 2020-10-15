package com.sm.cn.entity;

public class SearchBean {
    private int goodsTypeId;
    private int goodsBrandId;
    private String text;

    public int getGoodsTypeId() {
        return goodsTypeId;
    }

    public void setGoodsTypeId(int goodsTypeId) {
        this.goodsTypeId = goodsTypeId;
    }

    public int getGoodsBrandId() {
        return goodsBrandId;
    }

    public void setGoodsBrandId(int goodsBrandId) {
        this.goodsBrandId = goodsBrandId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "SearchBean{" +
                "goodsTypeId=" + goodsTypeId +
                ", goodsBrandId=" + goodsBrandId +
                ", text='" + text + '\'' +
                '}';
    }
}
