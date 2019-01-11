package com.javacourse2018.Service;

import com.javacourse2018.entity.DealList;
import com.javacourse2018.entity.Status;


public interface DealListInteractorInterface {
  void setDealList(DealList dealList);
  void setTitle(String title);
  void addDeal(String title);
  void removeDeal(String title);
  DealList getDeals();
  void updateDeal(String title, String newTitle, Status status);
}
