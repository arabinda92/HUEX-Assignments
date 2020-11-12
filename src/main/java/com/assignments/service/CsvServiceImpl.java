package com.assignments.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class CsvServiceImpl implements CsvService{

  @Override
  public List getMostViewedPages(Long n, Date fromDate, Date toDate) {
    return null;
  }

  @Override
  public List getMostTimeSpentPages(Long n, Date fromDate, Date toDate) {
    return null;
  }

  @Override
  public List getPagesWithActiveUsers(Long n, Date fromDate, Date toDate) {
    return null;
  }
}
