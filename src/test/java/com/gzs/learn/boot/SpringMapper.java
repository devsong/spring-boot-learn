package com.gzs.learn.boot;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gzs.learn.boot.entity.TestHb;
import com.gzs.learn.boot.entity.TestHbExample;
import com.gzs.learn.boot.mapper.TestHbCustomMapper;
import com.gzs.learn.boot.mapper.TestHbMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@ImportResource(locations = { "/spring/spring-beans.xml" })
public class SpringMapper {
	@Resource
	TestHbMapper testHbMapper;

	@Resource
	TestHbCustomMapper testHbCustomMapper;

	@Test
	public void testHb() {
		try {
			TestHb hb = new TestHb();
			hb.setAddress("addr");
			hb.setAge(1);
			hb.setCreateTime(new Date());
			hb.setName("name");
			hb.setPhone("18202794850");
			hb.setUpdateTime(new Date());
			for (int i = 0; i < 10; i++) {
				testHbMapper.insertSelective(hb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testPageHelper() {
		Page<TestHb> page = PageHelper.startPage(1, 5);
		List<TestHb> list = testHbCustomMapper.queryHbs();
		System.out.println(String.format("total is %d,size is %d", page.getTotal(), list.size()));
	}

	@Test
	public void querByExample() {
		TestHbExample example = new TestHbExample();
		example.createCriteria().andPhoneEqualTo("18202794850").andIdEqualTo(1);
		List<TestHb> hbs = testHbMapper.selectByExample(example);
		System.out.println(hbs.size());
	}
}
