package com.shawn.house.web.dao;

import com.shawn.house.web.entity.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by shawn.zeng on 2018/6/5.
 */
public interface RoomRepository extends MongoRepository<Room,String> {
}
