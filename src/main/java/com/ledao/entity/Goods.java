package com.ledao.entity;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

/**
 * @author LeDao
 * @company
 * @create 2020-01-17 15:11
 */
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private Integer id;
    /**
     * 商品编码
     */
    private String code;
    /**
     * 商品名称
     */
    @NotEmpty(message = "请输入要搜索的商品名称!")
    private String name;
    /**
     * 图片名
     */
    private String imageName;
    /**
     * 商品型号
     */
    private String model;
    /**
     * 商品类别
     */
    private GoodsType type;
    /**
     * 商品单位
     */
    private String unit;
    /**
     * 上次采购价格
     */
    private float lastPurchasingPrice;
    /**
     * 采购价格  成本价  假如价格变动 算平均值
     */
    private float purchasingPrice;
    /**
     * 出售价格
     */
    private float sellingPrice;
    /**
     * 库存数量
     */
    private int inventoryQuantity;
    /**
     * 库存下限
     */
    private int minNum;
    /**
     * 0 初始化状态 1 期初库存入仓库  2  有进货或者销售单据
     */
    private int state;
    /**
     * 生产厂商
     */
    private String producer;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 是否热卖 0否 1是
     */
    private Integer hot;
    /**
     * 是否热卖 0否 1是
     */
    private Integer isNew;
    /**
     * 是否特价 0否 1是
     */
    private Integer specialPrice;
    /**
     * 详情
     */
    private String details;
    /**
     * 查询用到 根据商品编码或者商品名称查询
     */
    private String codeOrName;
    /**
     * 销售总数
     */
    private Long saleTotal;
    /**
     * 发布日期
     */
    private Date releaseDate;
    /**
     * 是否已收藏 0代表不是 1代表是
     */
    private Integer isFavorite=0;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public GoodsType getType() {
        return type;
    }

    public void setType(GoodsType type) {
        this.type = type;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public float getLastPurchasingPrice() {
        return lastPurchasingPrice;
    }

    public void setLastPurchasingPrice(float lastPurchasingPrice) {
        this.lastPurchasingPrice = lastPurchasingPrice;
    }

    public float getPurchasingPrice() {
        return purchasingPrice;
    }

    public void setPurchasingPrice(float purchasingPrice) {
        this.purchasingPrice = purchasingPrice;
    }

    public float getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(float sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public int getInventoryQuantity() {
        return inventoryQuantity;
    }

    public void setInventoryQuantity(int inventoryQuantity) {
        this.inventoryQuantity = inventoryQuantity;
    }

    public int getMinNum() {
        return minNum;
    }

    public void setMinNum(int minNum) {
        this.minNum = minNum;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }

    public Integer getIsNew() {
        return isNew;
    }

    public void setIsNew(Integer isNew) {
        this.isNew = isNew;
    }

    public Integer getSpecialPrice() {
        return specialPrice;
    }

    public void setSpecialPrice(Integer specialPrice) {
        this.specialPrice = specialPrice;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getCodeOrName() {
        return codeOrName;
    }

    public void setCodeOrName(String codeOrName) {
        this.codeOrName = codeOrName;
    }

    public Long getSaleTotal() {
        return saleTotal;
    }

    public void setSaleTotal(Long saleTotal) {
        this.saleTotal = saleTotal;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(Integer isFavorite) {
        this.isFavorite = isFavorite;
    }

    @Override
    public String toString() {
        return "--{" +
                "id=" + id +
                ", 编号='" + code + '\'' +
                ", 商品名称='" + name + '\'' +
                ", 上次采购价格=" + lastPurchasingPrice +
                ", 采购价格=" + purchasingPrice +
                ", 出售价格=" + sellingPrice +
                '}';
    }
}
