package com.shawn.house.web.dao;

import com.shawn.house.web.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by shawn.zeng on 2018/6/10.
 */
public interface PriceJPA extends JpaRepository<PriceEntity,Integer> {
}
