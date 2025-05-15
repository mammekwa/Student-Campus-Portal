package com.example.demo.service;

import com.example.demo.entity.IssueReport;
import org.springframework.stereotype.Service;

@Service
public interface IssueReportService {
    public IssueReport saveReport(String reporterId, String reporterRole, String title, String description );

}
