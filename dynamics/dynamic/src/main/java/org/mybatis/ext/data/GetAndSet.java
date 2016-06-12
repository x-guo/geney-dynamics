package org.mybatis.ext.data;

import java.io.Serializable;

public class GetAndSet implements Serializable {

    private static final String SET              = "set";
    private static final String GET              = "get";
    private static final long   serialVersionUID = 4114801985122595804L;
    private String              getter;
    private String              setter;

    public GetAndSet(String prop){
        this.setGetter(prop);
        this.setSetter(prop);
    }

    public String getGetter() {
        return getter;
    }

    private void setGetter(String prop) {
        this.getter = GET + prop.substring(0, 1).toUpperCase() + prop.substring(1);

    }

    public String getSetter() {
        return setter;
    }

    private void setSetter(String prop) {
        this.setter = SET + prop.substring(0, 1).toUpperCase() + prop.substring(1);
    }
}
