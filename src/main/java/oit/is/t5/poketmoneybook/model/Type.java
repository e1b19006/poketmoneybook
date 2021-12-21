package oit.is.t5.poketmoneybook.model;

public class Type {
  int type_id;
  int user_id;
  String type_name;

  public int getUser_id() {
    return user_id;
  }

  public void setUser_id(int user_id) {
    this.user_id = user_id;
  }

  public int getType_id() {
    return type_id;
  }

  public void setType_id(int type_id) {
    this.type_id = type_id;
  }

  public String getType_name() {
    return type_name;
  }

  public void setType_name(String type_name) {
    this.type_name = type_name;
  }

}
