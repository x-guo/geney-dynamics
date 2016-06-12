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
public class MapperJava implements EntityInfo {

    private static final String MAPPER     = "Mapper";
    private static final String DAL_MAPPER = "dal.mapper";
    private String              mapperJavaPackage;
    private String              mapperJavaSimpleName;
    private String              mapperJavaName;

    public MapperJava(Class<?> entity){
        this.mapperJavaPackage = entity.getPackage().getName().replace(DAL_ENTITY, DAL_MAPPER);
        this.mapperJavaSimpleName = entity.getSimpleName().replace(DO, MAPPER);
        this.mapperJavaName = mapperJavaPackage + POINT + mapperJavaSimpleName;
    }

    public String getMapperJavaPackage() {
        return mapperJavaPackage;
    }

    public void setMapperJavaPackage(String mapperJavaPackage) {
        this.mapperJavaPackage = mapperJavaPackage;
    }

    public String getMapperJavaSimpleName() {
        return mapperJavaSimpleName;
    }

    public void setMapperJavaSimpleName(String mapperJavaSimpleName) {
        this.mapperJavaSimpleName = mapperJavaSimpleName;
    }

    public String getMapperJavaName() {
        return mapperJavaName;
    }

    public void setMapperJavaName(String mapperJavaName) {
        this.mapperJavaName = mapperJavaName;
    }

}
