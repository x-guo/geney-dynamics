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
public class MapperParam implements EntityInfo {

    private static final String PARAM     = "Param";
    private static final String DAL_PARAM = "dal.param";
    private String              mapperParamPackage;
    private String              mapperParamSimpleName;
    private String              mapperParamName;

    public MapperParam(Class<?> entity){
        this.mapperParamPackage = entity.getPackage().getName().replace(DAL_ENTITY, DAL_PARAM);
        this.mapperParamSimpleName = entity.getSimpleName().replace(DO, PARAM);
        this.mapperParamName = mapperParamPackage + POINT + mapperParamSimpleName;
    }

    public String getMapperParamPackage() {
        return mapperParamPackage;
    }

    public void setMapperParamPackage(String mapperParamPackage) {
        this.mapperParamPackage = mapperParamPackage;
    }

    public String getMapperParamSimpleName() {
        return mapperParamSimpleName;
    }

    public void setMapperParamSimpleName(String mapperParamSimpleName) {
        this.mapperParamSimpleName = mapperParamSimpleName;
    }

    public String getMapperParamName() {
        return mapperParamName;
    }

    public void setMapperParamName(String mapperParamName) {
        this.mapperParamName = mapperParamName;
    }

}
