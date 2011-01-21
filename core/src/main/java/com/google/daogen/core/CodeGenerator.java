package com.google.daogen.core;

import javax.sql.DataSource;
import java.sql.SQLException;

public interface CodeGenerator {

    DatabaseType getDatabaseType();

    DatabaseEntityType getDatabaseEntityType();

    DAOStyle getDAOStyle();

    String generateCode(EntityDetail entityDetail) throws SQLException;

    DataSource getDataSource();
}
