package org.mybatis.ext.matedata;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Table;

import org.mybatis.ext.utils.ClassUtils;

public class MapperContextFactoty {

    private MetaDataProvider metaDataProvider;

    public List<MapperContext> create(String entityPackage,String module) {
        List<MapperContext> mapperContexts = new ArrayList<MapperContext>();
        List<Class<?>> entityList = ClassUtils.getClasses(entityPackage);
        if (entityList == null || entityList.size() == 0) {
            return null;
        }

        for (Class<?> zlass : entityList) {
            String tableName = getTableName(zlass);
            mapperContexts.add(new MapperContext(zlass, metaDataProvider.getTableInfo(tableName),module));
        }
        return mapperContexts;
    }

    private String getTableName(Class<?> zlass) {
        Table table = zlass.getAnnotation(Table.class);
        return table != null ? table.name() : "";
    }

    public MetaDataProvider getMetaDataProvider() {
        return metaDataProvider;
    }

    public void setMetaDataProvider(MetaDataProvider metaDataProvider) {
        this.metaDataProvider = metaDataProvider;
    }

}
