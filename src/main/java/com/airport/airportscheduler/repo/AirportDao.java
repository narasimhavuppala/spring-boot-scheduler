package com.airport.airportscheduler.repo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AirportDao {
	
	  @Autowired
      private DataSource dataSource;
      private JdbcTemplate jdbcTemplate;

      public void setDataSource(DataSource dataSource) {
              this.dataSource = dataSource;
              this.jdbcTemplate = new JdbcTemplate(dataSource);
      }
      public boolean persistRecord(String id) {
    	  System.out.println(id);
    	  return true;
      }

}
