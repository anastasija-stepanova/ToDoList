package com.javacourse2018.Service;

import com.javacourse2018.Entity.DealList;

import java.util.List;

public interface LoaderInterface {
  void save(String path, List<DealList> dealLists);
  void load(String path, List<DealList> dealLists);
}
