package org.mybatis.ext.matedata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.mybatis.ext.data.ColumnInfo;
import org.mybatis.ext.data.TableInfo;

public class DatabaseMetaDataFactory implements MetaDataProvider {

    private DataSource      dataSource = null;

    private List<TableInfo> tableInfos = new ArrayList<TableInfo>();

    Connection              connection = null;

    private DatabaseMetaData getDatabaseMetaData() {
        try {
            connection = dataSource.getConnection();
            return connection.getMetaData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<String> getTableNames() {
        List<String> list = new ArrayList<String>();
        DatabaseMetaData dd = getDatabaseMetaData();
        if (dd == null) {
            return list;
        }
        try {
            ResultSet tableRet = dd.getTables(null, "%", "%", new String[] { "TABLE" });
            while (tableRet.next()) {
                list.add(tableRet.getString("TABLE_NAME"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    private List<ColumnInfo> queryColumnInfo(String tableName) {
        List<ColumnInfo> list = new ArrayList<ColumnInfo>();
        ResultSet colRet;
        try {
            colRet = getDatabaseMetaData().getColumns(null, "%", tableName, "%");
            while (colRet.next()) {
                ColumnInfo info = new ColumnInfo();
                info.setColName(colRet.getString("COLUMN_NAME"));
                info.setColType(colRet.getString("TYPE_NAME"));
                info.setColSize(colRet.getInt("COLUMN_SIZE"));
                info.setDigits(colRet.getInt("DECIMAL_DIGITS"));
                info.setNullable(colRet.getInt("NULLABLE"));
                list.add(info);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    private List<TableInfo> queryTableInfo() {
        if (tableInfos.size() > 0) {
            return tableInfos;
        }

        List<String> tables = getTableNames();
        if (tables == null || tables.size() == 0) {
            return tableInfos;
        }
        for (String tableName : tables) {
            tableInfos.add(new TableInfo(tableName, this.queryColumnInfo(tableName)));
        }

        return tableInfos;
    }

    public TableInfo getTableInfo(String tableName) {
        List<TableInfo> tis = queryTableInfo();
        for (TableInfo info : tis) {
            if (info.getTableName().equals(tableName)) {
                return info;
            }
        }
        return null;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
