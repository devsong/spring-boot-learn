package com.gzs.learn.boot.mapper;

import com.gzs.learn.boot.entity.TestHb;
import com.gzs.learn.boot.entity.TestHbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestHbMapper {
    long countByExample(TestHbExample example);

    int deleteByExample(TestHbExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TestHb record);

    int insertSelective(TestHb record);

    List<TestHb> selectByExample(TestHbExample example);

    TestHb selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TestHb record, @Param("example") TestHbExample example);

    int updateByExample(@Param("record") TestHb record, @Param("example") TestHbExample example);

    int updateByPrimaryKeySelective(TestHb record);

    int updateByPrimaryKey(TestHb record);
}