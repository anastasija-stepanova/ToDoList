package com.javacourse2018.Entity;

public class Deal {
  private Enum<Status> status;
  private String title;

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