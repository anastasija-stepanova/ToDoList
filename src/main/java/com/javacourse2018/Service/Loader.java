package com.javacourse2018.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javacourse2018.Entity.Deal;
import com.javacourse2018.Entity.DealList;
import com.javacourse2018.Entity.Status;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Loader implements LoaderInterface {

  public boolean save(String path, List<DealList> dealLists) {
    //into json file
    ObjectMapper mapper = new ObjectMapper();
    try {
      mapper.writeValue(new File(path), dealLists);
      return true;
    } catch (IOException ex) {
      System.out.println("Error while writing file");
      return false;
    }
  }

  public List<DealList> load(String path) {
    //from json file
    ObjectMapper mapper = new ObjectMapper();
    try {
      List<DealList> arrayOfList = new ArrayList<>();

      for (Object dealList: mapper.readValue(new File(path), List.class)) {
        if (dealList instanceof HashMap) {
          HashMap<String, Object> rawDealList = (HashMap<String, Object>) dealList;
          DealList dealListParsed = parseDealList(rawDealList);
          if (dealListParsed == null) {
            return null;
          }
          arrayOfList.add(dealListParsed);
        }
      }
      return arrayOfList;
    } catch (IOException ex) {
      System.out.println("Error while reading file");
      return null;
    }
  }

  private DealList parseDealList(HashMap<String, Object> map) {
    if (!(map.get("title") instanceof String) || !(map.get("dealList") instanceof List)) {
      return null;
    }
    String title = (String) map.get("title");

    DealList dealList = new DealList();
    dealList.setTitle(title);

    List<Deal> dealListArr = new ArrayList<>();
    for (Object rawDealList: (List<Object>) map.get("dealList")) {
      if (!(rawDealList instanceof HashMap)) {
        return null;
      }
      Deal deal = parseDeal((HashMap<String, String>) rawDealList);
      if (deal == null) {
        return null;
      }
      dealListArr.add(deal);
    }
    dealList.setDealList(dealListArr);

    return dealList;
  }

  private Deal parseDeal(HashMap<String, String> map) {
    Deal deal = new Deal();
    String rawStatus = map.get("status");
    String title = map.get("title");

    if (rawStatus == null || title == null) {
      return null;
    }
    Status status = Status.fromString(rawStatus);
    if (status == null) {
      return null;
    }
    deal.setStatus(status);
    deal.setTitle(title);
    return deal;
  }
}
