package com.assignments.service;

import java.util.Date;
import java.util.List;

/**
 * This is CsvService Interface
 */
public interface CsvService {
  /**
   * @param count is the request parameter from CLI*
   * @return list of most viewed page details
   */
  List getMostViewedPages(Long count, String orderBy);

  /**
   * @param count is the request parameter from CLI
   * @return list of pages with most time spent
   */
  List getMostTimeSpentPages(Long count, String orderBy);

  /**
   * @param count is the request parameter from CLI
   * @return list of page with most active users
   */
  List getPagesWithActiveUsers(Long count, String orderBy);

  /**
   *
   * @param count is the request parameter from CLI
   * @param fromDate
   * @param toDate
   * @return list of pages for a specific period
   */
  List getReports(Long count, Date fromDate, Date toDate);
}
