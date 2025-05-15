package com.example.demo.controller;

import com.example.demo.entity.IssueReport;
import com.example.demo.service.IssueReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/report-issue")
@CrossOrigin(origins = "*")
public class IssueReportController {
    private IssueReportService issueReportService;
    public IssueReportController(IssueReportService issueReportService){
        this.issueReportService = issueReportService;
    }
    public static class IssueReportRequest {
        public String reporterId;
        public String reporterRole;
        public String issueTitle;
        public String issueDescription;
    }
    @PostMapping
    public ResponseEntity<?> reportIssue(@RequestBody IssueReportRequest request) {
        if (request.reporterId == null || request.reporterRole == null ||
                request.issueTitle == null || request.issueDescription == null) {
            return ResponseEntity.badRequest().body("All fields are required.");
        }

        IssueReport savedReport = issueReportService.saveReport(
                request.reporterId,
                request.reporterRole,
                request.issueTitle,
                request.issueDescription
        );

        return ResponseEntity.ok().body(savedReport);
    }
}
