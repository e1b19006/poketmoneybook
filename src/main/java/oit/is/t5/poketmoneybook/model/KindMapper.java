package oit.is.t5.poketmoneybook.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface KindMapper {
  @Select("select * from kind where user_id = #{user_id}")
  ArrayList<Kind> selectAllUserkind(int user_id);

  @Insert("insert into kind (user_id, kind_name)values(#{user_id}, #{kind_name})")
  void insertKind(Kind kind);



}
