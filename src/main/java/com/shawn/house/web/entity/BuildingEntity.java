package com.shawn.house.web.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by shawn.zeng on 2018/6/6.
 */
@Entity
@Table(name = "building", schema = "house", catalog = "")
public class BuildingEntity {
    private Integer id;
    private String buildingName;
    private String buildingStructure;
    private String totalFloor;
    private String totalRoom;
    private String buildingCode;
    private String projectCode;
    private Timestamp updateDate;

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
    @Column(name = "building_name")
    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    @Basic
    @Column(name = "building_structure")
    public String getBuildingStructure() {
        return buildingStructure;
    }

    public void setBuildingStructure(String buildingStructure) {
        this.buildingStructure = buildingStructure;
    }

    @Basic
    @Column(name = "total_floor")
    public String getTotalFloor() {
        return totalFloor;
    }

    public void setTotalFloor(String totalFloor) {
        this.totalFloor = totalFloor;
    }

    @Basic
    @Column(name = "total_room")
    public String getTotalRoom() {
        return totalRoom;
    }

    public void setTotalRoom(String totalRoom) {
        this.totalRoom = totalRoom;
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
    @Column(name = "project_code")
    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BuildingEntity that = (BuildingEntity) o;

        if (id != that.id) return false;
        if (buildingName != null ? !buildingName.equals(that.buildingName) : that.buildingName != null) return false;
        if (buildingStructure != null ? !buildingStructure.equals(that.buildingStructure) : that.buildingStructure != null)
            return false;
        if (totalFloor != null ? !totalFloor.equals(that.totalFloor) : that.totalFloor != null) return false;
        if (totalRoom != null ? !totalRoom.equals(that.totalRoom) : that.totalRoom != null) return false;
        if (buildingCode != null ? !buildingCode.equals(that.buildingCode) : that.buildingCode != null) return false;
        if (projectCode != null ? !projectCode.equals(that.projectCode) : that.projectCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (buildingName != null ? buildingName.hashCode() : 0);
        result = 31 * result + (buildingStructure != null ? buildingStructure.hashCode() : 0);
        result = 31 * result + (totalFloor != null ? totalFloor.hashCode() : 0);
        result = 31 * result + (totalRoom != null ? totalRoom.hashCode() : 0);
        result = 31 * result + (buildingCode != null ? buildingCode.hashCode() : 0);
        result = 31 * result + (projectCode != null ? projectCode.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "update_date")
    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }
}
