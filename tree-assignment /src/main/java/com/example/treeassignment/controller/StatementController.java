package com.example.treeassignment.controller;

import com.example.treeassignment.model.Statement;
import com.example.treeassignment.model.dto.StatementDTO;
import com.example.treeassignment.service.StatementService;
import com.example.treeassignment.service.mapper.EntityToDTOConverter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/statements")
public class StatementController {
    private StatementService statementService;

    public StatementController(StatementService statementService) {
        this.statementService = statementService;
    }
    @GetMapping("/by-date")
    public ResponseEntity<List<StatementDTO>> getStatementByDate(
            Long accountId,
            @RequestParam(required = false) String fromDate,
            @RequestParam(required = false) String toDate,
            @RequestParam(required = false) String min,
            @RequestParam(required = false) String max
    ) {


        List<Statement> statements = statementService.findAllByDateFieldBetween(accountId, fromDate, toDate, min, max);
        List<StatementDTO> statementDTOs = EntityToDTOConverter.convertToStatementDTOs(statements);

        return ResponseEntity.ok(statementDTOs);
    }
}
