package com.google.daogen.core.impl;

import com.google.daogen.core.*;
import com.google.daogen.core.template.TemplateRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.metadata.CallParameterMetaData;
import org.springframework.jdbc.core.metadata.OracleCallMetaDataProvider;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.io.StringWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.List;

public class OracleSProcSpringBasedCodeGenerator implements CodeGenerator {
    private DataSource dataSource;

    private static final Logger logger = LoggerFactory.getLogger(OracleSProcSpringBasedCodeGenerator.class);

    private TemplateRenderer templateRenderer;

    public OracleSProcSpringBasedCodeGenerator(DataSource dataSource, TemplateRenderer templateRenderer) {
        this.dataSource = dataSource;
        this.templateRenderer = templateRenderer;
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

    public String generateCode(EntityDetail entityDetail) throws SQLException {
        Assert.state(entityDetail instanceof StoredProcedureDetail, "Please pass stored procedure entity detail");
        StoredProcedureDetail detail = (StoredProcedureDetail) entityDetail;
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource).
                withSchemaName(detail.getSchemaName()).
                withCatalogName(detail.getProcedureName()).
                withProcedureName(detail.getProcedureName());
        Connection conn = getConnection();
        DatabaseMetaData databaseMetaData = conn.getMetaData();
        OracleCallMetaDataProvider metaDataProvider = null;

        metaDataProvider = new OracleCallMetaDataProvider(databaseMetaData) {
            @Override
            public String metaDataSchemaNameToUse(String schemaName) {
                return null; //This is a spring Bug @ekanathk
            }
        };
        metaDataProvider.initializeWithMetaData(databaseMetaData);
        metaDataProvider.initializeWithProcedureColumnMetaData(databaseMetaData, detail.getSchemaName(),
                null, detail.getProcedureName());
        List<CallParameterMetaData> metaDataList = metaDataProvider.getCallParameterMetaData();
        Writer writer = new StringWriter();
        templateRenderer.renderTemplate(writer, "OracleStoredProc.ftl",
                new OracleStoredProcEntity(simpleJdbcCall, metaDataList));
        return writer.toString();
    }

    private Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public DataSource getDataSource() {
        return dataSource;
    }


}
