package oit.is.t5.poketmoneybook.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface KindMapper {
  @Select("if exists (select * from sys.objects where object_id = OBJECT_ID(N'kind#{user_id}')and type in (N'U')) select * from kind#{user_id} else select * from kind#{user_id}")
  ArrayList<Kind> selectAllUserkind(int user_id);

  // "if exists (select * from sys.objects where object_id =
  // OBJECT_ID(N'kind#{user_id}')and type in (N'U')) select * from kind#{user_id}
  // else create table kind#{user_id} (kind_id identity primary key,kind_name char
  // not null)"
}
