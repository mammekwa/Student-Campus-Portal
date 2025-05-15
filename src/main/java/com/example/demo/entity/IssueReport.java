package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "issue_reports")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IssueReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reporterId;
    private String reporterRole;
    private String issueTitle;

    @Column(length = 2000)
    private String issueDescription;
    private LocalDateTime reportedAt;



}
