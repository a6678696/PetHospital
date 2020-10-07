package com.ledao.entity;

/**
 * 商品报溢单商品实体
 *
 * @author LeDao
 * @company
 * @create 2020-01-17 15:19
 */
public class OverflowListGoods {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 商品报溢单
     */
    private OverflowList overflowList;
    /**
     * 商品编码
     */
    private String code;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 商品型号
     */
    private String model;
    /**
     * 商品类别
     */
    private GoodsType type;
    /**
     * 类别id
     */
    private Integer typeId;
    /**
     * 商品id
     */
    private Integer goodsId;
    /**
     * 商品单位
     */
    private String unit;
    /**
     * 单价
     */
    private float price;
    /**
     * 数量
     */
    private int num;
    /**
     * 总金额
     */
    private float total;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OverflowList getOverflowList() {
        return overflowList;
    }

    public void setOverflowList(OverflowList overflowList) {
        this.overflowList = overflowList;
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

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "OverflowListGoods{" +
                "id=" + id +
                ", overflowList=" + overflowList +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", type=" + type +
                ", typeId=" + typeId +
                ", goodsId=" + goodsId +
                ", unit='" + unit + '\'' +
                ", price=" + price +
                ", num=" + num +
                ", total=" + total +
                '}';
    }
}
