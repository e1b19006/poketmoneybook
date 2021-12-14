package oit.is.t5.poketmoneybook.model;

public class Kind {
  int kind_id;
  int user_id;
  String kind_name;

  public int getKind_id() {
    return kind_id;
  }

  public void setKind_id(int kind_id) {
    this.kind_id = kind_id;
  }

  public int getUser_id() {
    return user_id;
  }

  public void setUser_id(int user_id) {
    this.user_id = user_id;
  }

  public String getKind_name() {
    return kind_name;
  }

  public void setKind_name(String kind_name) {
    this.kind_name = kind_name;
  }

}
