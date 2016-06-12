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
public class Service implements EntityInfo {
    
    private static final String SERVICE_UPPER = "Service";
    private static final String SERVICE       = "service";
    private String              servicePackage;
    private String              serviceSimpleName;
    private String              serviceName;

    public Service(Class<?> entity){
        this.servicePackage = entity.getPackage().getName().replace(DAL_ENTITY, SERVICE);
        this.serviceSimpleName = entity.getSimpleName().replace(DO, SERVICE_UPPER);
        this.serviceName = servicePackage + POINT + serviceSimpleName;
    }

    public String getServicePackage() {
        return servicePackage;
    }

    public void setServicePackage(String servicePackage) {
        this.servicePackage = servicePackage;
    }

    public String getServiceSimpleName() {
        return serviceSimpleName;
    }

    public void setServiceSimpleName(String serviceSimpleName) {
        this.serviceSimpleName = serviceSimpleName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

}
