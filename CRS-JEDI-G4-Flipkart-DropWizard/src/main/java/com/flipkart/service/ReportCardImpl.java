package com.flipkart.service;

import com.flipkart.bean.ReportCard;
import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/** The Class ReportCardImpl. */
public class ReportCardImpl implements ReportCardInterface {

  /** The report cards. */
  private static List<ReportCard> reportCards;

  /** Instantiates a new report card impl. */
  public ReportCardImpl() {
    if (reportCards == null) {
      reportCards = new ArrayList<>();
    }
  }

  /**
   * Prints the report card.
   *
   * @param rollNo the roll no
   * @return the report card
   */
  @Override
  public ReportCard printReportCard(String rollNo) {
    // TODO Auto-generated method stub
    return null;
  }
}
