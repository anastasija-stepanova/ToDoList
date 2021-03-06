package com.javacourse2018.Service;

import com.javacourse2018.Entity.Deal;
import com.javacourse2018.Entity.DealList;
import com.javacourse2018.Entity.Status;

import java.util.List;

public class DealListInteractor implements DealListInteractorInterface {
  private DealList list;

  public DealListInteractor() {
    this.list = new DealList();
  }

  @Override
  public void setDealList(DealList dealList) {
    this.list = dealList;
  }

  public void setTitle(String title) {
    this.list.setTitle(title);
  }


  public void addDeal(String title) {
    Deal newDeal = new Deal();
    newDeal.setStatus(Status.IN_PROGRESS);
    newDeal.setTitle(title);

    List<Deal> listOfDeal = list.getDealList();
    listOfDeal.add(newDeal);
  }
  public void removeDeal(String title) {
    int index = getIndexOfDeal(title);

    if (index == -1) {
      // TODO: Сказать пользователю что нет такого элемента
      return;
    }

    this.list.getDealList().remove(index);
  }
  public DealList getDeals() {
    return this.list;
  }
  public void updateDeal(String title, String newTitle, Status status) {
    int index = getIndexOfDeal(title);

    if (index == -1) {
      // TODO: Сказать пользователю что нет такого элемента
      return;
    }

    Deal dealToUpdate = this.list.getDealList().get(index);
    if (newTitle != null) {
      dealToUpdate.setTitle(newTitle);
    }

    if (status != null) {
      dealToUpdate.setStatus(status);
    }
  }


  private int getIndexOfDeal(String title) {
    int index = -1;
    List<Deal> listOfDeal = this.list.getDealList();
    for (int i = 0; i < listOfDeal.size(); i++) {
      if (listOfDeal.get(i).getTitle().equals(title)) {
        return i;
      }
    }
    return -1;
  }
}
