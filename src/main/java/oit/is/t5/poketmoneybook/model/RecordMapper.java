package oit.is.t5.poketmoneybook.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RecordMapper {
  @Select("select * from log")
  ArrayList<Record> selectAllRecord();

  @Select("select * from log where log_id = #{log_id}")
  Record selectById(int log_id);

}
