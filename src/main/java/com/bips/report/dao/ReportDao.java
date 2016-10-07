package com.bips.report.dao;

import java.util.List;

import com.bips.report.beans.DateSelectorBean;
import com.bips.report.beans.SalesByDateBean;

public interface ReportDao {
 public List<DateSelectorBean> findData(String report_type,String startdate, String enddate) throws ClassNotFoundException;
 public List<SalesByDateBean> SalesByDate(String tr_report_type, String tr_fromdate, String tr_todate)
		throws ClassNotFoundException;
}
