package com.shawn.house;

import com.shawn.house.job.BuildingJob;
import com.shawn.house.job.ProjectJob;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HouseApplicationTests {

	@Autowired
	private ProjectJob projectJob;
	@Autowired
	private BuildingJob buildingJob;

	@Test
	public void contextLoads() {
		projectJob.job();
	}

	@Test
	public void contextLoadss() throws InterruptedException {
		buildingJob.job();
	}

}
