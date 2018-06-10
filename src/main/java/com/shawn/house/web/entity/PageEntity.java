package com.shawn.house.web.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by shawn.zeng on 2018/6/10.
 */
@Entity
@Table(name = "page", schema = "house", catalog = "")
public class PageEntity {
    private Integer id;
    private String projectCount;
    private Timestamp date;

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
    @Column(name = "project_count")
    public String getProjectCount() {
        return projectCount;
    }

    public void setProjectCount(String projectCount) {
        this.projectCount = projectCount;
    }

    @Basic
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PageEntity that = (PageEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (projectCount != null ? !projectCount.equals(that.projectCount) : that.projectCount != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (projectCount != null ? projectCount.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
