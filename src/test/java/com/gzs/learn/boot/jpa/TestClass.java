package com.gzs.learn.boot.jpa;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gzs.learn.boot.jpa.entity.TestHb;
import com.gzs.learn.boot.jpa.repository.TestHbRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestClass {
	@Resource
	private TestHbRepository testHbRepository;

	@Test
	public void testSave() {
		TestHb hb = new TestHb();
		hb.setAddress("address");
		hb.setAge(10);
		hb.setCreateTime(new Date());
		hb.setName("name1");
		hb.setPhone("18202794850");
		hb.setUpdateTime(new Date());
		testHbRepository.saveAndFlush(hb);
		// testHbRepository.save(hb);
	}
}
