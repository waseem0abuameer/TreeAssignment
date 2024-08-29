package com.example.treeassignment.repository;

import com.example.treeassignment.model.Statement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface StatementRepository extends JpaRepository<Statement, Long> {
    @Query("SELECT s FROM Statement s WHERE s.account.id = :accountId AND s.datefield BETWEEN :startDate AND :endDate AND s.amount BETWEEN :min AND :max")
    List<Statement> findStatementsByAccountAndDateRangeAndAmount(@Param("accountId") Long accountId,
                                                        @Param("startDate") LocalDate startDate,
                                                        @Param("endDate") LocalDate endDate,
                                                        @Param("min") BigDecimal min,
                                                        @Param("max") BigDecimal max);
    @Query("SELECT s FROM Statement s WHERE s.account.id = :accountId AND s.datefield BETWEEN :startDate AND :endDate")
    List<Statement> findStatementsByAccountAndDateRange(@Param("accountId") Long accountId,
                                                        @Param("startDate") LocalDate startDate,
                                                        @Param("endDate") LocalDate endDate);
    @Query("SELECT s FROM Statement s WHERE s.account.id = :accountId AND s.amount BETWEEN :min AND :max")
    List<Statement> findStatementsByAccountAndAmount(@Param("accountId") Long accountId,
                                                     @Param("min") BigDecimal min,
                                                     @Param("max") BigDecimal max);
}
