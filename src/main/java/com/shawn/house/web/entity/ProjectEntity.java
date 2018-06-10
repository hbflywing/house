package com.shawn.house.web.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by shawn.zeng on 2018/6/10.
 */
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
    private String saleTime;
    private String others;
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

        ProjectEntity that = (ProjectEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (projectName != null ? !projectName.equals(that.projectName) : that.projectName != null) return false;
        if (projectCode != null ? !projectCode.equals(that.projectCode) : that.projectCode != null) return false;
        if (total != null ? !total.equals(that.total) : that.total != null) return false;
        if (houseSaled != null ? !houseSaled.equals(that.houseSaled) : that.houseSaled != null) return false;
        if (houseSaleable != null ? !houseSaleable.equals(that.houseSaleable) : that.houseSaleable != null)
            return false;
        if (nohouseSaled != null ? !nohouseSaled.equals(that.nohouseSaled) : that.nohouseSaled != null) return false;
        if (nohouseSaleable != null ? !nohouseSaleable.equals(that.nohouseSaleable) : that.nohouseSaleable != null)
            return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        if (startWorkingTime != null ? !startWorkingTime.equals(that.startWorkingTime) : that.startWorkingTime != null)
            return false;
        if (completionTime != null ? !completionTime.equals(that.completionTime) : that.completionTime != null)
            return false;
        if (useArea != null ? !useArea.equals(that.useArea) : that.useArea != null) return false;
        if (areaYear != null ? !areaYear.equals(that.areaYear) : that.areaYear != null) return false;
        if (areaPurpose != null ? !areaPurpose.equals(that.areaPurpose) : that.areaPurpose != null) return false;
        if (areaLevel != null ? !areaLevel.equals(that.areaLevel) : that.areaLevel != null) return false;
        if (floorage != null ? !floorage.equals(that.floorage) : that.floorage != null) return false;
        if (plotRatio != null ? !plotRatio.equals(that.plotRatio) : that.plotRatio != null) return false;
        if (totalBuilding != null ? !totalBuilding.equals(that.totalBuilding) : that.totalBuilding != null)
            return false;
        if (saleTime != null ? !saleTime.equals(that.saleTime) : that.saleTime != null) return false;
        if (others != null ? !others.equals(that.others) : that.others != null) return false;
        if (buildingAreaCode != null ? !buildingAreaCode.equals(that.buildingAreaCode) : that.buildingAreaCode != null)
            return false;
        if (areaCode != null ? !areaCode.equals(that.areaCode) : that.areaCode != null) return false;
        if (buildingDesignCode != null ? !buildingDesignCode.equals(that.buildingDesignCode) : that.buildingDesignCode != null)
            return false;
        if (constructionCode != null ? !constructionCode.equals(that.constructionCode) : that.constructionCode != null)
            return false;
        if (previousCode != null ? !previousCode.equals(that.previousCode) : that.previousCode != null) return false;
        if (companyCode != null ? !companyCode.equals(that.companyCode) : that.companyCode != null) return false;
        if (companyName != null ? !companyName.equals(that.companyName) : that.companyName != null) return false;
        if (companyTel != null ? !companyTel.equals(that.companyTel) : that.companyTel != null) return false;
        if (agentCompany != null ? !agentCompany.equals(that.agentCompany) : that.agentCompany != null) return false;
        if (agentTel != null ? !agentTel.equals(that.agentTel) : that.agentTel != null) return false;
        if (office != null ? !office.equals(that.office) : that.office != null) return false;
        if (updateDate != null ? !updateDate.equals(that.updateDate) : that.updateDate != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (projectName != null ? projectName.hashCode() : 0);
        result = 31 * result + (projectCode != null ? projectCode.hashCode() : 0);
        result = 31 * result + (total != null ? total.hashCode() : 0);
        result = 31 * result + (houseSaled != null ? houseSaled.hashCode() : 0);
        result = 31 * result + (houseSaleable != null ? houseSaleable.hashCode() : 0);
        result = 31 * result + (nohouseSaled != null ? nohouseSaled.hashCode() : 0);
        result = 31 * result + (nohouseSaleable != null ? nohouseSaleable.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (startWorkingTime != null ? startWorkingTime.hashCode() : 0);
        result = 31 * result + (completionTime != null ? completionTime.hashCode() : 0);
        result = 31 * result + (useArea != null ? useArea.hashCode() : 0);
        result = 31 * result + (areaYear != null ? areaYear.hashCode() : 0);
        result = 31 * result + (areaPurpose != null ? areaPurpose.hashCode() : 0);
        result = 31 * result + (areaLevel != null ? areaLevel.hashCode() : 0);
        result = 31 * result + (floorage != null ? floorage.hashCode() : 0);
        result = 31 * result + (plotRatio != null ? plotRatio.hashCode() : 0);
        result = 31 * result + (totalBuilding != null ? totalBuilding.hashCode() : 0);
        result = 31 * result + (saleTime != null ? saleTime.hashCode() : 0);
        result = 31 * result + (others != null ? others.hashCode() : 0);
        result = 31 * result + (buildingAreaCode != null ? buildingAreaCode.hashCode() : 0);
        result = 31 * result + (areaCode != null ? areaCode.hashCode() : 0);
        result = 31 * result + (buildingDesignCode != null ? buildingDesignCode.hashCode() : 0);
        result = 31 * result + (constructionCode != null ? constructionCode.hashCode() : 0);
        result = 31 * result + (previousCode != null ? previousCode.hashCode() : 0);
        result = 31 * result + (companyCode != null ? companyCode.hashCode() : 0);
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (companyTel != null ? companyTel.hashCode() : 0);
        result = 31 * result + (agentCompany != null ? agentCompany.hashCode() : 0);
        result = 31 * result + (agentTel != null ? agentTel.hashCode() : 0);
        result = 31 * result + (office != null ? office.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }
}
