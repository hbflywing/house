package com.shawn.house.web.entity;

import javax.persistence.*;

/**
 * Created by shawn.zeng on 2018/6/10.
 */
@Entity
@Table(name = "ip_pool", schema = "house", catalog = "")
public class IpPoolEntity {
    private Integer id;
    private String ip;
    private String port;

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
    @Column(name = "ip")
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Basic
    @Column(name = "port")
    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IpPoolEntity that = (IpPoolEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (ip != null ? !ip.equals(that.ip) : that.ip != null) return false;
        if (port != null ? !port.equals(that.port) : that.port != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (ip != null ? ip.hashCode() : 0);
        result = 31 * result + (port != null ? port.hashCode() : 0);
        return result;
    }
}
