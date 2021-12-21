package oit.is.t5.poketmoneybook.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TypeMapper {
  @Select("select * from type where user_id = #{user_id}")
  ArrayList<Type> selectAllUsertype(int user_id);

  @Insert("insert into type (user_id, type_name)values(#{user_id}, #{type_name})")
  void insertType(Type type);

}
