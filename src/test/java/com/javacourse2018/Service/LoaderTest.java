package com.javacourse2018.Service;

import com.javacourse2018.Entity.Deal;
import com.javacourse2018.Entity.DealList;
import com.javacourse2018.Entity.Status;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class LoaderTest {
  private static final String path = "C:/Users/Anastasia/Desktop/t1.json";
  private static final String wrongPath = "wrong.json";

  @Test
  public void save() {
    LoaderInterface loader = new Loader();
    List<DealList> dealListList = new ArrayList<>();

    DealList dealList1 = new DealList();

    dealList1.setTitle("List 1");
    List<Deal> deals1 = new ArrayList<>();

    Deal d1 = new Deal();
    d1.setStatus(Status.IN_PROGRESS);
    d1.setTitle("Чихнуть");
    deals1.add(d1);
    Deal d2 = new Deal();
    d2.setStatus(Status.IN_PROGRESS);
    d2.setTitle("Пойти в магазин");
    deals1.add(d2);

    dealList1.setDealList(deals1);

    DealList dealList2 = new DealList();

    dealList2.setTitle("List 2");

    List<Deal> deals2 = new ArrayList<>();

    Deal d3 = new Deal();
    d3.setStatus(Status.DONE);
    d3.setTitle("Выкинуть мусор");
    deals2.add(d3);
    Deal d4 = new Deal();
    d4.setStatus(Status.IN_PROGRESS);
    d4.setTitle("Подстричь кошку");
    deals2.add(d4);

    dealList2.setDealList(deals2);

    dealListList.add(dealList1);
    dealListList.add(dealList2);

    loader.save(path, dealListList);
  }

  @Test
  public void load() {
    LoaderInterface loader1 = new Loader();
    List<DealList> list1 = loader1.load(wrongPath);
    Assert.assertNull(list1);
    LoaderInterface loader = new Loader();
    List<DealList> list = loader.load(path);
    list = loader.load(path);
    Assert.assertEquals(list.size(), 2);
    Assert.assertEquals(list.get(0).getTitle(), "List 1");
    Assert.assertEquals(list.get(1).getTitle(), "List 2");
    Assert.assertEquals(list.get(0).getDealList().size(), 2);
    Assert.assertEquals(list.get(0).getDealList().get(0).getStatus(), Status.IN_PROGRESS);
    Assert.assertEquals(list.get(0).getDealList().get(0).getTitle(), "Чихнуть");
  }
}