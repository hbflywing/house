package com.shawn.house.web.dao;

import com.shawn.house.web.entity.Project;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by shawn.zeng on 2018/6/4.
 */
public interface ProjectRepository extends MongoRepository<Project,String>{
}
