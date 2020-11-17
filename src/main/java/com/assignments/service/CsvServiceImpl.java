package com.assignments.service;
import com.assignments.entity.CsvModel;
import com.assignments.exception.CsvException;
import com.assignments.repository.CsvRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * This is implementation class
 */

@Slf4j
@Service
public class CsvServiceImpl implements CsvService{

  @Autowired
  private CsvRepository csvRepository;

  /**
   * This method will fetch pages with most views
   * @param count is the request parameter from CLI*
   * @param orderBy
   * @return
   */
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
  //To do : need to write logic for time spent
  @Override
  public List getMostTimeSpentPages(Long count, String orderBy) {
    return null;
  }

  /**
   * This method will fetch all active users
   * @param count is the request parameter from CLI
   * @param orderBy
   * @return
   */
  @Override
  public List getPagesWithActiveUsers(Long count, String orderBy) {
    log.debug("This method fetches most active users");
    SimpleDateFormat datetimeFormatter = new SimpleDateFormat(
      "yyyy-MM-dd HH:mm:ss");
    List<CsvModel> csvModelList = csvRepository.findLastUpdatedAt();
    List<String> responseList = new ArrayList<>();
    if (csvModelList == null) {
      throw new CsvException(String.format("records not found , please insert some records"));
    }
    for (int i=1; i<= count ;i++) {
      for (CsvModel c: csvModelList) {
        responseList.add(c.getUuid());
      }
    }
    log.debug("Most active users fetched successfully");
    return responseList;
  }
  //To do : Need to add date filters
  @Override
  public List getReports(String orderBy, Long count, String fromDate, String toDate) {
    return null;
  }
}
