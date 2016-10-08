package com.bips.report.dao;

import java.util.List;

import com.bips.report.beans.DateSelectorBean;
import com.bips.report.beans.ReportBean;

public interface ReportDao {
 public List<DateSelectorBean> findDeptData(String report_type,String startdate, String enddate) throws ClassNotFoundException;
 public List<ReportBean> findTrendData(String tr_report_type, String tr_fromdate, String tr_todate)
		throws ClassNotFoundException;
}
