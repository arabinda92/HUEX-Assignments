package com.assignments.service;
import com.assignments.entity.CsvModel;
import com.assignments.exception.CsvException;
import com.assignments.repository.CsvRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * This is implementation class
 */

@Slf4j
@Service
public class CsvServiceImpl implements CsvService{

  @Autowired
  private CsvRepository csvRepository;

  @Override
  public List getMostViewedPages(Long count, String orderBy) {
    log.debug("This fetches most viewed pages with count : {}", count);
    TreeMap<String, Integer> responseMap = new TreeMap<>();
    HashMap<String, Integer> checkPagesMap = new HashMap<>();
    List<String> eventLabelList = csvRepository.findAllEventLabel();
    if (eventLabelList == null) {
        throw new CsvException(String.format("Event_label column is empty, please insert some records"));
    }
    for (String cc : eventLabelList) {
     if (checkPagesMap.containsKey(cc)) {
       checkPagesMap.put(cc, checkPagesMap.get(cc)+1);
     } else {
       checkPagesMap.put(cc,1);
     }
    }
    List<String> listOfPages = new ArrayList<>();
    responseMap.putAll(checkPagesMap);
    for (int i = 1; i <= count; i++) {
      for (Map.Entry<String, Integer> entry : responseMap.entrySet()) {
        listOfPages.add(entry.getKey());
      }
    }
    log.debug("List of pages fetched successfully");
    return listOfPages;
  }

  @Override
  public List getMostTimeSpentPages(Long count, String orderBy) {
    return null;
  }

  @Override
  public List getPagesWithActiveUsers(Long count, String orderBy) {
    return null;
  }

  @Override
  public List getReports(String orderBy, Long count, String fromDate, String toDate) {

    return null;
  }
}
