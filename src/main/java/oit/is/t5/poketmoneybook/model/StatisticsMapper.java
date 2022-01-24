package oit.is.t5.poketmoneybook.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StatisticsMapper {
  @Select("select * from log join kind on (log.kind_id = kind.kind_id) join type on (log.type_id = type.type_id) join user on (log.user_id = user.user_id) where log.user_id = #{user_id}")
  ArrayList<Record> selectAllRecord(int user_id);

  @Select("select type_name, sum(value) value from log join kind on (log.kind_id = kind.kind_id) join type on (log.type_id = type.type_id) join user on (log.user_id = user.user_id) where log.user_id=#{user_id} and date like #{month} and status = 0 group by type_name order by sum(value) desc")
  ArrayList<Statistics> selectTypeRecord(int user_id, String month);

  @Select("select Kind_name, sum(value) value from log join kind on (log.kind_id = kind.kind_id) join type on (log.type_id = type.type_id) join user on (log.user_id = user.user_id) where log.user_id=#{user_id} and date like #{month} and status = 0 group by Kind_name order by sum(value) desc")
  ArrayList<Statistics> selectKindRecord(int user_id, String month);

  @Select("select sum(value) value from log where not user_id = #{user_id} and status = 0 and date like #{month} group by user_id")
  ArrayList<Record> selectOtherSumSRecord(int user_id, String month);

  @Select("select sum(value) value from log where not user_id = #{user_id} and status = 1 and date like #{month} group by user_id")
  ArrayList<Record> selectOtherSumIRecord(int user_id, String month);
}
