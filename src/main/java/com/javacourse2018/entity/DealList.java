package com.javacourse2018.entity;

import java.util.ArrayList;
import java.util.List;

public class DealList {
  private Integer id;
  private String title;
  private List<Deal> dealList;

  public DealList() {
    this.dealList = new ArrayList<>();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public List<Deal> getDealList() {
    return dealList;
  }

  public void setDealList(List<Deal> dealList) {
    this.dealList = dealList;
  }
}
