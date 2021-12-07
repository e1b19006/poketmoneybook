package oit.is.t5.poketmoneybook.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RecordMapper {
  @Select("select * from log join kind on (log.kind_id = kind.kind_id) join type on (log.type_id = type.type_id) join user on (log.user_id = user.user_id)")
  ArrayList<Record> selectAllRecord();

  @Select("select * from log where log_id = #{log_id}")
  Record selectById(int log_id);

  @Insert("insert into log ( value, kind_id, type_id, date, time) values(#{value}, #{kind_id}, #{type_id},CURRENT_DATE,CURRENT_TIME)")
  @Options(useGeneratedKeys = true, keyColumn = "log_id", keyProperty = "log_id")
  void insertLog(Record record);

}
