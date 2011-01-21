package com.google.daogen.core;

public class StoredProcedureDetail implements EntityDetail {

    private String packageName;
    private String procedureName;
    private String schemaName;

    public StoredProcedureDetail(String packageName, String procedureName) {
        this(packageName, procedureName, null);
    }

    public StoredProcedureDetail(String packageName, String procedureName, String schemaName) {
        this.packageName = packageName;
        this.procedureName = procedureName;
        this.schemaName = schemaName;
    }

    public String getPackageName() {
        return packageName;
    }

    public String getProcedureName() {
        return procedureName;
    }

    public String getSchemaName() {
        return schemaName;
    }
}
