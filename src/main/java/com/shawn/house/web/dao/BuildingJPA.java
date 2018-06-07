package com.shawn.house.web.dao;

import com.shawn.house.web.entity.BuildingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by shawn.zeng on 2018/6/6.
 */
public interface BuildingJPA extends JpaRepository<BuildingEntity,Integer> {
}
