package com.example.treeassignment.service;

import com.example.treeassignment.model.Statement;
import com.example.treeassignment.repository.StatementRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class StatementService {
    private StatementRepository statementRepository;

    public StatementService(StatementRepository statementRepository) {
        this.statementRepository = statementRepository;
    }
    public List<Statement> findAllByDateFieldBetween(Long accountId, String fromDate, String toDate, String min, String max) {
        LocalDate parsedFromDate = fromDate != null ? LocalDate.parse(fromDate) : null;
        LocalDate parsedToDate = toDate != null ? LocalDate.parse(toDate) : null;
        BigDecimal newMin = (min != null && !min.isEmpty()) ? new BigDecimal(min) : null;
        BigDecimal newMax = (max != null && !max.isEmpty()) ? new BigDecimal(max) : null;

        if (fromDate == null || fromDate.isEmpty()) {
            if (min == null || min.isEmpty()) {
                return statementRepository.findStatementsByAccountAndAmount(accountId, newMin, newMax);
            } else {
                return statementRepository.findStatementsByAccountAndAmount(accountId, newMin, newMax);
            }
        } else if (min == null || min.isEmpty()) {
            return statementRepository.findStatementsByAccountAndDateRange(accountId, parsedFromDate, parsedToDate);
        } else {
            return statementRepository.findStatementsByAccountAndDateRangeAndAmount(accountId, parsedFromDate, parsedToDate, newMin, newMax);
        }
    }
}
