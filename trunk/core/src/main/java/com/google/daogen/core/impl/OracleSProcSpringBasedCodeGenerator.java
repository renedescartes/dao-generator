package com.google.daogen.core.impl;

import com.google.daogen.core.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import javax.sql.DataSource;

public class OracleSProcSpringBasedCodeGenerator implements CodeGenerator{
    private DataSource dataSource;

    private static final Logger logger = LoggerFactory.getLogger(OracleSProcSpringBasedCodeGenerator.class);

    public OracleSProcSpringBasedCodeGenerator(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public DatabaseType getDatabaseType() {
        return DatabaseType.ORACLE;
    }

    public DatabaseEntityType getDatabaseEntityType() {
        return DatabaseEntityType.STORED_PROC;
    }

    public DAOStyle getDAOStyle() {
        return DAOStyle.SPRING_SIMPLE;
    }

    public void generateCode(EntityDetail entityDetail) {
        Assert.state(entityDetail instanceof StoredProcedureDetail, "Please pass stored procedure entity detail");

    }

    public DataSource getDataSource() {
        return dataSource;
    }


}
