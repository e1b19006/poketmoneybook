package oit.is.t5.poketmoneybook.model;

public class Record {
  int log_id;
  int value;
  int kind_id;
  int type_id;
  String date;
  String time;


  public int getLog_id() {
    return log_id;
  }

  public void setLog_id(int log_id) {
    this.log_id = log_id;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public int getKind_id() {
    return kind_id;
  }

  public void setKind_id(int kind_id) {
    this.kind_id = kind_id;
  }

  public int getType_id() {
    return type_id;
  }

  public void setType_id(int type_id) {
    this.type_id = type_id;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

}
