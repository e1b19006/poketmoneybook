package oit.is.t5.poketmoneybook.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface JournalMapper {

  @Select("select * from log join kind on (log.kind_id = kind.kind_id) join type on (log.type_id = type.type_id) join user on (log.user_id = user.user_id) where log.user_id = #{user_id}")
  ArrayList<Record> selectAllRecord(int user_id);

  @Select("select * from log join kind on (log.kind_id = kind.kind_id) join type on (log.type_id = type.type_id) join user on (log.user_id = user.user_id) where log.user_id = #{user_id} and date >= #{dateFrom} and date <= #{dateTo}")
  ArrayList<Record> selectDateRecord(int user_id, String dateFrom, String dateTo);
}
