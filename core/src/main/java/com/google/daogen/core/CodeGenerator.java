package com.google.daogen.core;

import javax.sql.DataSource;

public interface CodeGenerator {

    DatabaseType getDatabaseType();

    DatabaseEntityType getDatabaseEntityType();

    DAOStyle getDAOStyle();

    void generateCode();

    DataSource getDataSource();
}
