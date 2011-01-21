package com.google.daogen.core.impl;

import org.springframework.jdbc.core.metadata.CallParameterMetaData;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.util.List;

public class OracleStoredProcEntity {

    private SimpleJdbcCall simpleJdbcCall;

    private List<CallParameterMetaData> metaDataList;

    public OracleStoredProcEntity(SimpleJdbcCall simpleJdbcCall, List<CallParameterMetaData> metaDataList) {
        this.simpleJdbcCall = simpleJdbcCall;
        this.metaDataList = metaDataList;
    }

    public SimpleJdbcCall getSimpleJdbcCall() {
        return simpleJdbcCall;
    }

    public List<CallParameterMetaData> getMetaDataList() {
        return metaDataList;
    }
}
