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
public class Controller implements EntityInfo {

    private static final String CONTROLLER = "Controller";
    private static final String WEB        = "web";
    private String              controllerPackage;
    private String              controllerSimpleName;
    private String              controllerName;

    public Controller(Class<?> entity){
        this.controllerPackage = entity.getPackage().getName().replace(DAL_ENTITY, WEB);
        this.controllerSimpleName = entity.getSimpleName().replace(DO, CONTROLLER);
        this.controllerName = controllerPackage + POINT + controllerSimpleName;
    }

    public String getControllerPackage() {
        return controllerPackage;
    }

    public void setControllerPackage(String controllerPackage) {
        this.controllerPackage = controllerPackage;
    }

    public String getControllerSimpleName() {
        return controllerSimpleName;
    }

    public void setControllerSimpleName(String controllerSimpleName) {
        this.controllerSimpleName = controllerSimpleName;
    }

    public String getControllerName() {
        return controllerName;
    }

    public void setControllerName(String controllerName) {
        this.controllerName = controllerName;
    }

}
