package com.google.daogen.core.impl;

import com.google.daogen.core.CodeGenerator;
import com.google.daogen.core.DAOStyle;
import com.google.daogen.core.DatabaseEntityType;
import com.google.daogen.core.DatabaseType;

import javax.sql.DataSource;

public class OracleSProcSpringBasedCodeGenerator implements CodeGenerator{
    private DataSource dataSource;

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

    public void generateCode() {

    }

    public DataSource getDataSource() {
        return dataSource;
    }


}
