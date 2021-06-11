package com.flipkart.service;

import com.flipkart.bean.RegisteredCourse;
import com.flipkart.bean.ReportCard;

import java.util.ArrayList;
import java.util.List;

public class ReportCardImpl implements ReportCardInterface {

	private static List<ReportCard> reportCards;

	public ReportCardImpl() {
		if(reportCards == null){
			reportCards = new ArrayList<>();
		}
	}

	@Override
	public ReportCard printReportCard(String rollNo) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
