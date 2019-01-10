package com.javacourse2018.entity;

public class Deal {
  private Integer id;
  private Enum<Status> status;
  private String title;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Enum<Status> getStatus() {
    return status;
  }

  public void setStatus(Enum<Status> status) {
    this.status = status;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}