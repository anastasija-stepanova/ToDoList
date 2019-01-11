package com.javacourse2018.Service;

import com.javacourse2018.Entity.DealList;
import com.javacourse2018.Entity.Status;


public interface DealListInteractorInterface {
  void setTitle(String title);
  void addDeal(String title);
  void removeDeal(String title);
  DealList getDeals();
  void updateDeal(String title, String newTitle, Status status);
}
