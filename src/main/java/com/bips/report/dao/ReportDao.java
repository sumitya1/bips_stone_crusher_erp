package com.bips.report.dao;

import java.util.List;

public interface ReportDao {
 public List findData(String startdate, String enddate) throws ClassNotFoundException;
}
