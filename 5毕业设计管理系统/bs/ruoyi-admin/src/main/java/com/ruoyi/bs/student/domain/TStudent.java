package com.ruoyi.bs.student.domain;


public class TStudent {

  private long id;
  private String studentNo;
  private String studentName;
  private String sex;
  private long majorId;
  private String grade;
  private String inputMan;
  private java.sql.Timestamp lastModifyTime;
  private String phone;
  private String email;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getStudentNo() {
    return studentNo;
  }

  public void setStudentNo(String studentNo) {
    this.studentNo = studentNo;
  }


  public String getStudentName() {
    return studentName;
  }

  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }


  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }


  public long getMajorId() {
    return majorId;
  }

  public void setMajorId(long majorId) {
    this.majorId = majorId;
  }


  public String getGrade() {
    return grade;
  }

  public void setGrade(String grade) {
    this.grade = grade;
  }


  public String getInputMan() {
    return inputMan;
  }

  public void setInputMan(String inputMan) {
    this.inputMan = inputMan;
  }


  public java.sql.Timestamp getLastModifyTime() {
    return lastModifyTime;
  }

  public void setLastModifyTime(java.sql.Timestamp lastModifyTime) {
    this.lastModifyTime = lastModifyTime;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

}
