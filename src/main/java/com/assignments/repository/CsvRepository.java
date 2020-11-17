package com.assignments.repository;

import com.assignments.entity.CsvModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

/**
 * This is a repository class
 */

@org.springframework.stereotype.Repository
public interface CsvRepository extends JpaRepository<CsvModel, String> {

  @Query("SELECT c.event_label FROM CsvModel c")
  List<String> findAllEventLabel();

  @Query("SELECT c FROM CsvModel c WHERE DATEDIFF(c.created_at,c.last_updated_at) < 60")
  List<CsvModel> findActiveUsersByUpdateDate();
}

