package com.javacourse2018.Service;

public interface DealControllerInterface {
  void chooseDealList(String title);
  DealListInteractorInterface getCurrentList();
  void save();
  void load(String filePath);
}
