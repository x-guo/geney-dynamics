package org.mybatis.ext.data;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public class TableInfo implements Serializable {

    private static final long serialVersionUID = 8424589024114827747L;

    private String            tableName;

    private List<ColumnInfo>  columnInfos;

    public TableInfo(String tableName, List<ColumnInfo> columnInfos){
        this.tableName = tableName;
        this.columnInfos = columnInfos;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<ColumnInfo> getColumnInfos() {
        return columnInfos;
    }

    public void setColumnInfos(List<ColumnInfo> columnInfos) {
        this.columnInfos = columnInfos;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
    
}
