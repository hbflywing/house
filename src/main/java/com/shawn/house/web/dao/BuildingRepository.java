package com.shawn.house.web.dao;

import com.shawn.house.web.entity.Building;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by shawn.zeng on 2018/6/4.
 */
public interface BuildingRepository extends MongoRepository<Building,String> {
}
