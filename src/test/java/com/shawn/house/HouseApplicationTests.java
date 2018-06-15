package com.shawn.house;

import com.shawn.house.v1.engine.queue.BlockingQueueRoom;
import com.shawn.house.v1.job.BuildingJob;
import com.shawn.house.v1.job.ProjectJob;
import com.shawn.house.v1.job.RoomJob;
import com.shawn.house.v1.web.dao.RoomJPA;
import com.shawn.house.v1.web.entity.RoomEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

	@Autowired
	private RoomJPA roomJPA;

	@Autowired
	private BlockingQueueRoom blockingQueueRoom;

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

	@Test
	public void contextLoadssss() throws InterruptedException, IOException {
		Page<RoomEntity> list = roomJPA.findByRoomCodeNotAndPrice("00000000-0000-0000-0000-000000000000","",new PageRequest(0,20));
	}

	@Test
	public void contextLoadsssss(){
		new Thread(blockingQueueRoom.newRunnableProducer()).start();
		new Thread(blockingQueueRoom.newRunnableConsumer()).start();
	}

}
