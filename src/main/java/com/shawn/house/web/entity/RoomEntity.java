package com.shawn.house.web.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;

/**
 * Created by shawn.zeng on 2018/6/10.
 */
@Entity
@Table(name = "room", schema = "house", catalog = "")
public class RoomEntity {
    private Integer id;
    private String buildingNo;
    private String unit;
    private String floor;
    private String roomNo;
    private String roomCode;
    private String buildingCode;
    private Byte status;
    private String previousArea;
    private String actualArea;
    private String price;
    private byte[] priceByte;
    private String priceString;
    @Transient
    private Timestamp updateDate;
    @Transient
    private Timestamp createDate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "building_no")
    public String getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(String buildingNo) {
        this.buildingNo = buildingNo;
    }

    @Basic
    @Column(name = "unit")
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Basic
    @Column(name = "floor")
    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    @Basic
    @Column(name = "room_no")
    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    @Basic
    @Column(name = "room_code")
    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    @Basic
    @Column(name = "building_code")
    public String getBuildingCode() {
        return buildingCode;
    }

    public void setBuildingCode(String buildingCode) {
        this.buildingCode = buildingCode;
    }

    @Basic
    @Column(name = "status")
    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Basic
    @Column(name = "previous_area")
    public String getPreviousArea() {
        return previousArea;
    }

    public void setPreviousArea(String previousArea) {
        this.previousArea = previousArea;
    }

    @Basic
    @Column(name = "actual_area")
    public String getActualArea() {
        return actualArea;
    }

    public void setActualArea(String actualArea) {
        this.actualArea = actualArea;
    }

    @Basic
    @Column(name = "price")
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Basic
    @Column(name = "price_byte")
    public byte[] getPriceByte() {
        return priceByte;
    }

    public void setPriceByte(byte[] priceByte) {
        this.priceByte = priceByte;
    }

    @Basic
    @Column(name = "price_string")
    public String getPriceString() {
        return priceString;
    }

    public void setPriceString(String priceString) {
        this.priceString = priceString;
    }

    @Basic
    @Column(name = "update_date")
    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    @Basic
    @Column(name = "create_date")
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomEntity that = (RoomEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (buildingNo != null ? !buildingNo.equals(that.buildingNo) : that.buildingNo != null) return false;
        if (unit != null ? !unit.equals(that.unit) : that.unit != null) return false;
        if (floor != null ? !floor.equals(that.floor) : that.floor != null) return false;
        if (roomNo != null ? !roomNo.equals(that.roomNo) : that.roomNo != null) return false;
        if (roomCode != null ? !roomCode.equals(that.roomCode) : that.roomCode != null) return false;
        if (buildingCode != null ? !buildingCode.equals(that.buildingCode) : that.buildingCode != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (previousArea != null ? !previousArea.equals(that.previousArea) : that.previousArea != null) return false;
        if (actualArea != null ? !actualArea.equals(that.actualArea) : that.actualArea != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (!Arrays.equals(priceByte, that.priceByte)) return false;
        if (priceString != null ? !priceString.equals(that.priceString) : that.priceString != null) return false;
        if (updateDate != null ? !updateDate.equals(that.updateDate) : that.updateDate != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (buildingNo != null ? buildingNo.hashCode() : 0);
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        result = 31 * result + (floor != null ? floor.hashCode() : 0);
        result = 31 * result + (roomNo != null ? roomNo.hashCode() : 0);
        result = 31 * result + (roomCode != null ? roomCode.hashCode() : 0);
        result = 31 * result + (buildingCode != null ? buildingCode.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (previousArea != null ? previousArea.hashCode() : 0);
        result = 31 * result + (actualArea != null ? actualArea.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(priceByte);
        result = 31 * result + (priceString != null ? priceString.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }
}
