import org.springframework.jdbc.core.simple.SimpleJdbcCall;

class StoredProcedure {
    private DataSource dataSource;
    private SimpleJdbcCall storedProc;

    public void initialisation {
        storedProc = new SimpleJdbcCall(dataSource).withCatalogName("${entity.simpleJdbcCall.catalogName}")
            .withProcedureName("${entity.simpleJdbcCall.procedureName}");
        storedProc.setAccessCallParameterMetaData(false);

    }


}

