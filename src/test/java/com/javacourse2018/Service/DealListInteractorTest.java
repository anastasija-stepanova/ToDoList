package com.javacourse2018.Service;

import com.javacourse2018.entity.Deal;
import com.javacourse2018.entity.DealList;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DealListInteractorTest {

  @Test
  public void addDeal() {
    DealListInteractor interactor = new DealListInteractor();
    interactor.addDeal("Покормить кошку");
    interactor.addDeal("Поесть");
    Assert.assertEquals(interactor.getDeals().getDealList().size(), 2);
  }

  @Test
  public void removeDeal() {
    DealListInteractor interactor = new DealListInteractor();
    interactor.addDeal("Покормить кошку");
    interactor.addDeal("Поесть");
    interactor.removeDeal("Поесть");
    Assert.assertEquals(interactor.getDeals().getDealList().size(), 1);
  }

  @Test
  public void getDeals() {
    DealListInteractor interactor = new DealListInteractor();
    interactor.addDeal("Покормить кошку");
    interactor.addDeal("Поесть");
    interactor.removeDeal("Поесть");
    List<Deal> deals = interactor.getDeals().getDealList();
    Assert.assertEquals(deals.get(0).getTitle(), "Покормить кошку");
  }

  @Test
  public void updateDeal() {
    DealListInteractor interactor = new DealListInteractor();
    interactor.addDeal("Покормить кошку");
    interactor.updateDeal("Покормить кошку", "Покормить кота", null);
    List<Deal> deals = interactor.getDeals().getDealList();
    Assert.assertEquals(deals.get(0).getTitle(), "Покормить кота");
  }
}