package com.shawn.house.web.dao;

import java.util.List;
import com.shawn.house.web.entity.BuildingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by shawn.zeng on 2018/6/6.
 */
public interface BuildingJPA extends JpaRepository<BuildingEntity,Integer> {

    @Query(value = "select * from building  where not exists (select * from room where room.building_code = building.building_code)",nativeQuery = true)
    List<BuildingEntity> queryBuildingEntitiesByNoRoom();
}
