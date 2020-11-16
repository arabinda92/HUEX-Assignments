package com.assignments.service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class CsvServiceImpl implements CsvService{

  @Override
  public List getMostViewedPages(Long count, String orderBy) {

    return null;
  }

  @Override
  public List getMostTimeSpentPages(Long count, String orderBy) {
    //To d
    return null;
  }

  @Override
  public List getPagesWithActiveUsers(Long count, String orderBy) {
    return null;
  }

  @Override
  public List getReports(Long count, Date fromDate, Date toDate) {
    return null;
  }
}
