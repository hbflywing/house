package com.shawn.house.web.entity;

import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@ToString
@Entity
@Table(name = "project", schema = "house", catalog = "")
public class ProjectEntity {
    private Integer id;
    private String projectName;
    private String projectCode;
    private String total;
    private String houseSaled;
    private String houseSaleable;
    private String nohouseSaled;
    private String nohouseSaleable;
    private String location;
    private String startWorkingTime;
    private String completionTime;
    private String useArea;
    private String areaYear;
    private String areaPurpose;
    private String areaLevel;
    private String floorage;
    private String plotRatio;
    private String totalBuilding;
    private String buildingAreaCode;
    private String areaCode;
    private String buildingDesignCode;
    private String constructionCode;
    private String previousCode;
    private String companyCode;
    private String companyName;
    private String companyTel;
    private String agentCompany;
    private String agentTel;
    private String office;
    private Timestamp updateDate;
    private String saleTime;
    private String others;

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
    @Column(name = "project_name")
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Basic
    @Column(name = "project_code")
    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    @Basic
    @Column(name = "total")
    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Basic
    @Column(name = "house_saled")
    public String getHouseSaled() {
        return houseSaled;
    }

    public void setHouseSaled(String houseSaled) {
        this.houseSaled = houseSaled;
    }

    @Basic
    @Column(name = "house_saleable")
    public String getHouseSaleable() {
        return houseSaleable;
    }

    public void setHouseSaleable(String houseSaleable) {
        this.houseSaleable = houseSaleable;
    }

    @Basic
    @Column(name = "nohouse_saled")
    public String getNohouseSaled() {
        return nohouseSaled;
    }

    public void setNohouseSaled(String nohouseSaled) {
        this.nohouseSaled = nohouseSaled;
    }

    @Basic
    @Column(name = "nohouse_saleable")
    public String getNohouseSaleable() {
        return nohouseSaleable;
    }

    public void setNohouseSaleable(String nohouseSaleable) {
        this.nohouseSaleable = nohouseSaleable;
    }

    @Basic
    @Column(name = "location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Basic
    @Column(name = "start_working_time")
    public String getStartWorkingTime() {
        return startWorkingTime;
    }

    public void setStartWorkingTime(String startWorkingTime) {
        this.startWorkingTime = startWorkingTime;
    }

    @Basic
    @Column(name = "completion_time")
    public String getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(String completionTime) {
        this.completionTime = completionTime;
    }

    @Basic
    @Column(name = "use_area")
    public String getUseArea() {
        return useArea;
    }

    public void setUseArea(String useArea) {
        this.useArea = useArea;
    }

    @Basic
    @Column(name = "area_year")
    public String getAreaYear() {
        return areaYear;
    }

    public void setAreaYear(String areaYear) {
        this.areaYear = areaYear;
    }

    @Basic
    @Column(name = "area_purpose")
    public String getAreaPurpose() {
        return areaPurpose;
    }

    public void setAreaPurpose(String areaPurpose) {
        this.areaPurpose = areaPurpose;
    }

    @Basic
    @Column(name = "area_level")
    public String getAreaLevel() {
        return areaLevel;
    }

    public void setAreaLevel(String areaLevel) {
        this.areaLevel = areaLevel;
    }

    @Basic
    @Column(name = "floorage")
    public String getFloorage() {
        return floorage;
    }

    public void setFloorage(String floorage) {
        this.floorage = floorage;
    }

    @Basic
    @Column(name = "plot_ratio")
    public String getPlotRatio() {
        return plotRatio;
    }

    public void setPlotRatio(String plotRatio) {
        this.plotRatio = plotRatio;
    }

    @Basic
    @Column(name = "total_building")
    public String getTotalBuilding() {
        return totalBuilding;
    }

    public void setTotalBuilding(String totalBuilding) {
        this.totalBuilding = totalBuilding;
    }

    @Basic
    @Column(name = "building_area_code")
    public String getBuildingAreaCode() {
        return buildingAreaCode;
    }

    public void setBuildingAreaCode(String buildingAreaCode) {
        this.buildingAreaCode = buildingAreaCode;
    }

    @Basic
    @Column(name = "area_code")
    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    @Basic
    @Column(name = "building_design_code")
    public String getBuildingDesignCode() {
        return buildingDesignCode;
    }

    public void setBuildingDesignCode(String buildingDesignCode) {
        this.buildingDesignCode = buildingDesignCode;
    }

    @Basic
    @Column(name = "construction_code")
    public String getConstructionCode() {
        return constructionCode;
    }

    public void setConstructionCode(String constructionCode) {
        this.constructionCode = constructionCode;
    }

    @Basic
    @Column(name = "previous_code")
    public String getPreviousCode() {
        return previousCode;
    }

    public void setPreviousCode(String previousCode) {
        this.previousCode = previousCode;
    }

    @Basic
    @Column(name = "company_code")
    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    @Basic
    @Column(name = "company_name")
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Basic
    @Column(name = "company_tel")
    public String getCompanyTel() {
        return companyTel;
    }

    public void setCompanyTel(String companyTel) {
        this.companyTel = companyTel;
    }

    @Basic
    @Column(name = "agent_company")
    public String getAgentCompany() {
        return agentCompany;
    }

    public void setAgentCompany(String agentCompany) {
        this.agentCompany = agentCompany;
    }

    @Basic
    @Column(name = "agent_tel")
    public String getAgentTel() {
        return agentTel;
    }

    public void setAgentTel(String agentTel) {
        this.agentTel = agentTel;
    }

    @Basic
    @Column(name = "office")
    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    @Basic
    @Column(name = "update_date")
    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectEntity that = (ProjectEntity) o;
        return
                Objects.equals(projectCode, that.projectCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectCode);
    }

    @Basic
    @Column(name = "sale_time")
    public String getSaleTime() {
        return saleTime;
    }

    public void setSaleTime(String saleTime) {
        this.saleTime = saleTime;
    }

    @Basic
    @Column(name = "others")
    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }
}
