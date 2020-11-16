package com.assignments.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.assignments.service.CsvService;

import java.util.Date;
import java.util.List;

/**
 * This is main controller class
 * It will have all the API end point definitions related to CSV data.
 */

@ApiResponses(value = {
  @ApiResponse(code = 401, message = "Unauthorized access to the resource."),
  @ApiResponse(code = 403, message = "Access to the resource is forbidden."),
  @ApiResponse(code = 404, message = "Resource not found.")
})
@RestController
public class MainController extends BaseController {

  @Autowired
  private CsvService csvService;

  @ApiOperation(value = "To fetch most viewed pages")
  @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Pages fetched successfully.",
      response = List.class)
  })
  @GetMapping("viewedPages")
  public ResponseEntity<Object> fetchMostViewedPages(@RequestParam(value = "count") Long count,
                                                     @RequestParam(value = "orderBy",
                                                       required = false) String orderBy)
                                                      {
    return ResponseEntity.ok().body(csvService.getMostViewedPages(count, orderBy));
  }

  @ApiOperation(value = "To fetch pages with most time spent")
  @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Pages fetched successfully.",
      response = List.class)
  })
  @GetMapping("pages")
  public ResponseEntity<Object> fetchMostTimeSpentPages(@RequestParam(value = "count") Long count,
                                                        @RequestParam(value = "orderBy",
                                                          required = false) String orderBy) {
    return ResponseEntity.ok().body(csvService.getMostTimeSpentPages(count, orderBy));
  }

  @ApiOperation(value = "To fetch pages with most active users")
  @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Pages fetched successfully.",
      response = List.class)
  })
  @GetMapping("users")
  public ResponseEntity<Object> fetchPagesWithActiveUsers(@RequestParam(value = "count") Long count,
                                                          @RequestParam(value = "orderBy",
                                                            required = false) String orderBy) {
    return ResponseEntity.ok().body(csvService.getPagesWithActiveUsers(count, orderBy));
  }

  @ApiOperation(value = "To fetch pages with most active users")
  @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Pages fetched successfully.",
      response = List.class)
  })
  @GetMapping("timelyReport")
  public ResponseEntity<Object> fetchReports(@RequestParam(value = "orderBy") String orderBy,
                                             @RequestParam(value = "count") Long count,
                                             @RequestParam(value = "fromDate") String fromDate,
                                             @RequestParam(value = "toDate") String toDate) {
    return ResponseEntity.ok().body(csvService.getReports(orderBy, count, fromDate, toDate));
  }
}
