package com.assignments.service;

import java.util.Date;
import java.util.List;

/**
 * This is CsvService Interface
 */
public interface CsvService {
  /**
   * @param n is the request parameter from CLI
   * @return list of most viewed page details
   */
  List getMostViewedPages(Long n, Date fromDate, Date toDate);

  /**
   * @param n is the request parameter from CLI
   * @return list of pages with most time spent
   */
  List getMostTimeSpentPages(Long n, Date fromDate, Date toDate);

  /**
   * @param n is the request parameter from CLI
   * @return list of page with most active users
   */
  List getPagesWithActiveUsers(Long n, Date fromDate, Date toDate);
}
