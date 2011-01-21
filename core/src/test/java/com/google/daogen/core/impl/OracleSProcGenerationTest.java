package com.google.daogen.core.impl;

import com.google.daogen.core.StoredProcedureDetail;
import com.google.daogen.core.template.FreeMarkerTemplateRenderer;
import org.junit.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

public class OracleSProcGenerationTest {

    @Test
    public void testSimpleGeneration() {
        DataSource dataSource = new DriverManagerDataSource("jdbc:oracle:thin:@powdevdb05.is.pow.uk.betfair:1521:PWCUKSP3",
                "source_sportex", "source_sportex");
        OracleSProcSpringBasedCodeGenerator generator = new OracleSProcSpringBasedCodeGenerator(dataSource,
                new FreeMarkerTemplateRenderer());
        try {
            generator.generateCode(new StoredProcedureDetail("PKG_LOOKUPS_LOCAL", "pr_get_market_type_for_sport", "SOURCE_SPORTEX"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
