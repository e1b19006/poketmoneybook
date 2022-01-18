package oit.is.t5.poketmoneybook.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StatisticsMapper {
  @Select("select * from log join kind on (log.kind_id = kind.kind_id) join type on (log.type_id = type.type_id) join user on (log.user_id = user.user_id) where log.user_id = #{user_id} and date = #{date}")
  ArrayList<Record> selectTypeRecord(int user_id, String date);

  @Select("select date, sum(value) value from log join kind on (log.kind_id = kind.kind_id) join type on (log.type_id = type.type_id) join user on (log.user_id = user.user_id) where log.user_id = #{user_id} and date = #{date} ")
  Statistics selectSumDRecord(int user_id, String date);

  @Select("select date, sum(value) value from log join kind on (log.kind_id = kind.kind_id) join type on (log.type_id = type.type_id) join user on (log.user_id = user.user_id) where log.user_id = #{user_id} and date like #{date} ")
  Statistics selectSumMRecord(int user_id, String date);

  @Select("select date, value from log where user_id = #{user_id}")
  ArrayList<Statistics> selectAllUser(int user_id);

}
