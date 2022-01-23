package oit.is.t5.poketmoneybook.model;

public class Record {
  int log_id;
  int value;
  int user_id;
  int kind_id;
  int type_id;
  String date;
  String time;
  String remark;
  int status;
  String statusS;
  String kind_name;
  String type_name;
  String user_name;

  public int getUser_id() {
    return user_id;
  }

  public void setUser_id(int user_id) {
    this.user_id = user_id;
  }

  public String getUser_name() {
    return user_name;
  }

  public void setUser_name(String user_name) {
    this.user_name = user_name;
  }

  public String getKind_name() {
    return kind_name;
  }

  public void setKind_name(String kind_name) {
    this.kind_name = kind_name;
  }

  public String getType_name() {
    return type_name;
  }

  public void setType_name(String type_name) {
    this.type_name = type_name;
  }

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

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getStatusS() {
    return statusS;
  }

  public void setStatusS(String statusS) {
    this.statusS = statusS;
  }

}
