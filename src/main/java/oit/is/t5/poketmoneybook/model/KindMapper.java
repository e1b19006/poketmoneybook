package oit.is.t5.poketmoneybook.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public class KindMapper {
  @Select("if exists (select * from sys.objects where object_id = OBJECT_ID(N'kind')and type in (N'U'))else create table kind#{user_id} (kind_id identity primary key,kind_name char not null)")
  ArrayList<Kind> selectAllUserkind(int user_id);
}
