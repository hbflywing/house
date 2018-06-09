package com.shawn.house.web.dao;

import com.shawn.house.web.entity.RoomEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Created by shawn.zeng on 2018/6/6.
 */
public interface RoomJPA extends JpaRepository<RoomEntity,Integer> {
    Page<RoomEntity> findByRoomCodeNotAndPrice(String string, String price, Pageable pageable);

    Page<RoomEntity> findByPriceNot(String string,Pageable pageable);
}
