package com.shawn.house.v1.proxy.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by shawn.zeng on 2018/6/8.
 */
public interface IpPoolJPA extends JpaRepository<IpPoolEntity,Integer> {
}
