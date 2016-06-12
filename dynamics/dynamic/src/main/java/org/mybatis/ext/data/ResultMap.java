package org.mybatis.ext.data;

import java.io.Serializable;

public class ResultMap implements Serializable {

    private static final long serialVersionUID = 8876211698845518605L;

    private String            prop;
    private String            column;
    private String            jdbcType;

    private GetAndSet         getAndSet;

    public String getProp() {
        return prop;
    }

    public void setProp(String prop) {
        this.prop = prop;
        this.getAndSet = (new GetAndSet(prop));
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getJdbcType() {
        return jdbcType;
    }

    public void setJdbcType(String jdbcType) {
        this.jdbcType = jdbcType;
    }

    public GetAndSet getGetAndSet() {
        return getAndSet;
    }

}
