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
  @GetMapping("pages/mostViewed")
  public ResponseEntity<Object> fetchMostViewedPages(@RequestParam(value = "n") Long n,
                                                     @RequestParam(value="fromDate")
                                                     @DateTimeFormat(pattern="YYYY-MM-DD") Date fromDate,
                                                     @RequestParam(value = "toDate")
                                                       @DateTimeFormat(pattern="YYYY-MM-DD") Date toDate) {
    return ResponseEntity.ok().body(csvService.getMostViewedPages(n, fromDate, toDate));
  }

  @ApiOperation(value = "To fetch pages with most time spent")
  @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Pages fetched successfully.",
      response = List.class)
  })
  @GetMapping("pages/mostTimeSpent")
  public ResponseEntity<Object> fetchMostTimeSpentPages(@RequestParam(value = "number of pages")
                                                            Long n,
                                                        @RequestParam(value = "fromDate",
                                                          required = false) Date fromDate,
                                                        @RequestParam(value = "toDate",
                                                          required = false) Date toDate) {
    return ResponseEntity.ok().body(csvService.getMostTimeSpentPages(n, fromDate, toDate));
  }

  @ApiOperation(value = "To fetch pages with most active users")
  @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Pages fetched successfully.",
      response = List.class)
  })
  @GetMapping("pages/mostActiveUsers")
  public ResponseEntity<Object> fetchPagesWithActiveUsers(@RequestParam(value = "number of pages")
                                                              Long n,
                                                          @RequestParam(value = "fromDate",
                                                            required = false) Date fromDate,
                                                          @RequestParam(value = "toDate",
                                                            required = false) Date toDate) {
    return ResponseEntity.ok().body(csvService.getPagesWithActiveUsers(n, fromDate, toDate));
  }
}