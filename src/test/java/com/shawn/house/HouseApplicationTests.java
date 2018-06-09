package com.shawn.house;

import com.shawn.house.job.BuildingJob;
import com.shawn.house.job.ProjectJob;
import com.shawn.house.job.RoomJob;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HouseApplicationTests {

	@Autowired
	private ProjectJob projectJob;
	@Autowired
	private BuildingJob buildingJob;

	@Autowired
	private RoomJob roomJob;

	@Test
	public void contextLoads() {
		projectJob.job();
	}

	@Test
	public void contextLoadss() throws InterruptedException {
		buildingJob.job();
	}

	@Test
	public void contextLoadsss() throws InterruptedException, IOException {
		roomJob.job();
	}

}
