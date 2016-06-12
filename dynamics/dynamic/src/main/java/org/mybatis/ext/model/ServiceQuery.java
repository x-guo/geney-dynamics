package org.mybatis.ext.model;

/**
 * com.cheng.users.dal.entity.UserDO 
 *
 * package:    com.cheng.users.dal.entity 
 * simpleName: UserDO 
 * name:       com.cheng.users.dal.entity.UserDO 
 * module:     users 
 * 
 * @author TianJiang Apr 18, 2014 10:08:33 PM
 */
public class ServiceQuery implements EntityInfo {

    private static final String QUERY         = "Query";
    private static final String SERVICE_QUERY = "service.query";
    private String              serviceQueryPackage;
    private String              serviceQuerySimpleName;
    private String              serviceQueryName;

    public ServiceQuery(Class<?> entity){
        this.serviceQueryPackage = entity.getPackage().getName().replace(DAL_ENTITY, SERVICE_QUERY);
        this.serviceQuerySimpleName = entity.getSimpleName().replace(DO, QUERY);
        this.serviceQueryName = serviceQueryPackage + POINT + serviceQuerySimpleName;
    }

    public String getServiceQueryPackage() {
        return serviceQueryPackage;
    }

    public void setServiceQueryPackage(String serviceQueryPackage) {
        this.serviceQueryPackage = serviceQueryPackage;
    }

    public String getServiceQuerySimpleName() {
        return serviceQuerySimpleName;
    }

    public void setServiceQuerySimpleName(String serviceQuerySimpleName) {
        this.serviceQuerySimpleName = serviceQuerySimpleName;
    }

    public String getServiceQueryName() {
        return serviceQueryName;
    }

    public void setServiceQueryName(String serviceQueryName) {
        this.serviceQueryName = serviceQueryName;
    }

}
