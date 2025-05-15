package com.example.demo.service.impl;

import com.example.demo.entity.IssueReport;
import com.example.demo.repository.IssueReportRepository;
import com.example.demo.service.IssueReportService;
import com.example.demo.service.IssueReportService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
public class IssueReportServiceImpl implements IssueReportService{
   private IssueReportRepository issueReportRepository;

    public IssueReportServiceImpl(IssueReportRepository issueReportRepository) {
        this.issueReportRepository = issueReportRepository;
    }

    @Override
    public IssueReport saveReport(String reporterId, String reporterRole, String issueTitle, String issueDescription) {
        IssueReport report = IssueReport.builder()
                .reporterId(reporterId)
                .reporterRole(reporterRole)
                .issueTitle(issueTitle)
                .issueDescription(issueDescription)
                .reportedAt(LocalDateTime.now())
                .build();

        return issueReportRepository.save(report);
    }

}
