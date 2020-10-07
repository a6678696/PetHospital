package com.ledao.entity;

/**
 * 供应商实体
 *
 * @author LeDao
 * @company
 * @create 2020-01-17 15:43
 */
public class Supplier {

    /**
     *编号
     */
    private Integer id;
    /**
     *供应商名称
     */
    private String name;
    /**
     *联系人
     */
    private String contact;
    /**
     *联系电话
     */
    private String number;
    /**
     *联系地址
     */
    private String address;
    /**
     *备注
     */
    private String remarks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "--{" +
                "编号=" + id +
                ", 供应商名称='" + name + '\'' +
                ", 联系人='" + contact + '\'' +
                ", 联系电话='" + number + '\'' +
                ", 联系地址='" + address + '\'' +
                '}';
    }
}
