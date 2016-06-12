package org.mybatis.ext.matedata;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Table;

import org.mybatis.ext.data.ColumnInfo;
import org.mybatis.ext.data.ResultMap;
import org.mybatis.ext.data.TableInfo;
import org.mybatis.ext.template.ViewAddTemplate;
import org.mybatis.ext.template.ViewListTemplate;
import org.springframework.beans.BeanUtils;

public class MapperContext {

    private String              module;
    private String              tableName;

    private String              entitySimpleName;
    private String              entityName;

    private String              mapperName;
    private String              mapperPath;
    private String              mapperFileName;

    private String              mapperQueryName;
    private String              mapperQueryPath;
    private String              mapperQueryFileName;

    private String              serviceName;
    private String              servicePath;
    private String              serviceFileName;

    private String              serviceQueryName;
    private String              serviceQueryPath;
    private String              serviceQueryFileName;

    private String              controllerFileName;
    private String              controllerPath;
    private String              controllerRequestPath;

    private String              allProps      = null;
    private String              allColumns    = null;

    private List<ResultMap>     resultMaps    = new ArrayList<ResultMap>();
    private Map<String, String> entityPropMap = new HashMap<String, String>();

    public MapperContext(Class<?> entity, TableInfo tableInfo, String module){
        this.module = module;
        initEntity(entity);
        initResultMaps(entity, tableInfo);

        init();

        String simpleName = entity.getSimpleName();
        this.mapperFileName = simpleName.replace("DO", "Mapper");
        this.mapperQueryFileName = simpleName.replace("DO", "Param");
        this.serviceFileName = simpleName.replace("DO", "Service");
        this.serviceQueryFileName = simpleName.replace("DO", "Query");
        this.controllerFileName = simpleName.replace("DO", "Controller");

        String packageName = entity.getPackage().getName();
        this.mapperPath = packageName.replace("entity", "mapper");
        this.mapperQueryPath = packageName.replace("entity", "param");
        this.servicePath = packageName.replace("dal.entity", "service");
        this.serviceQueryPath = packageName.replace("dal.entity", "service.query");
        this.controllerPath = packageName.replace("dal.entity", "web");

        setMapperName(entity.getName().replace("entity", "mapper").replace("DO", "Mapper"));
        setMapperQueryName(entity.getName().replace("entity", "param").replace("DO", "Param"));
        setServiceName(entity.getName().replace("dal.entity", "service").replace("DO", "Service"));
        setServiceQueryName(entity.getName().replace("dal.entity", "service.query").replace("DO", "Query"));

        String tmpPath = simpleName.replace("DO", "");
        this.setControllerRequestPath(tmpPath.substring(0, 1).toLowerCase() + tmpPath.substring(1));
    }

    private void init() {
        List<String> props = new ArrayList<String>();
        List<String> colus = new ArrayList<String>();

        for (ResultMap result : resultMaps) {
            props.add(result.getProp());
            colus.add(result.getColumn());
        }
        initAllColumns(colus);
        initAllProp(props);
    }

    private void initResultMaps(Class<?> entity, TableInfo tableInfo) {
        if (tableInfo != null && tableInfo.getColumnInfos() != null) {
            List<ColumnInfo> columnInfos = tableInfo.getColumnInfos();
            for (ColumnInfo columnInfo : columnInfos) {
                try {
                    ResultMap resultMap = new ResultMap();
                    String entityProp = getEntityProp(columnInfo.getColName());
                    resultMap.setProp(entityProp);
                    resultMap.setColumn(columnInfo.getColName().toUpperCase());
                    String propType = BeanUtils.findPropertyType(entityProp, entity).getSimpleName();
                    resultMap.setJdbcType(propType);
                    resultMaps.add(resultMap);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String getEntityProp(String colName) {
        if (colName == null) {
            return "";
        }
        colName = colName.replaceAll("_", "").trim().toUpperCase();
        return entityPropMap.get(colName);
    }

    private void initAllColumns(List<String> columnInfos) {
        StringBuffer buffer = new StringBuffer();
        int i = 0;
        for (String columnInfo : columnInfos) {
            if (columnInfo == null || columnInfo.equals("")) {
                return;
            }
            if (i == 0) {
                buffer.append(columnInfo.toUpperCase());
                i++;
            } else {
                buffer.append(",").append(columnInfo.toUpperCase());
            }
        }
        allColumns = buffer.toString();
    }

    private void initEntity(Class<?> entity) {
        Field[] subfields = entity.getDeclaredFields();
        Field[] supfields = entity.getSuperclass().getDeclaredFields();
        Field[] fields = new Field[subfields.length + supfields.length];
        System.arraycopy(subfields, 0, fields, 0, subfields.length);
        System.arraycopy(supfields, 0, fields, subfields.length, supfields.length);
        initPropsMap(fields);

        setEntitySimpleName(entity.getSimpleName());
        setEntityName(entity.getName());
        Table table = entity.getAnnotation(Table.class);
        tableName = table.name();
    }

    private void initAllProp(List<String> props) {
        StringBuffer buffer = new StringBuffer();
        int j = 0;
        for (String prop : props) {
            if (j == 0) {
                buffer.append("#{").append(prop).append("}");
            } else {
                buffer.append(",").append("#{").append(prop).append("}");
            }
            j++;
        }

        this.setAllProps(buffer.toString());

    }

    private void initPropsMap(Field[] fields) {
        if (fields == null) {
            return;
        }
        for (Field field : fields) {
            entityPropMap.put(field.getName().toUpperCase(), field.getName());
        }
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getAllProps() {
        return allProps;
    }

    public void setAllProps(String allProps) {
        this.allProps = allProps;
    }

    public String getAllColumns() {
        return allColumns;
    }

    public void setAllColumns(String allColumns) {
        this.allColumns = allColumns;
    }

    public List<ResultMap> getResultMaps() {
        return resultMaps;
    }

    public void setResultMaps(List<ResultMap> resultMaps) {
        this.resultMaps = resultMaps;
    }

    public String getMapperPath() {
        return mapperPath;
    }

    public String getMapperFileName() {
        return mapperFileName;
    }

    public String getMapperSqlFilePath() {
        String path = "src/main/java/" + mapperPath.replace(".", "/");
        exists(path);
        return path + "/" + mapperFileName + ".xml";
    }

    public String getMapperJavaFilePath() {
        String path = "src/main/java/" + mapperPath.replace(".", "/");
        exists(path);
        return path + "/" + mapperFileName + ".java";
    }

    public String getEntitySimpleName() {
        return entitySimpleName;
    }

    public void setEntitySimpleName(String entitySimpleName) {
        this.entitySimpleName = entitySimpleName;
    }

    public String getMapperName() {
        return mapperName;
    }

    public void setMapperName(String mapperName) {
        this.mapperName = mapperName;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getMapperQueryName() {
        return mapperQueryName;
    }

    public void setMapperQueryName(String mapperQueryName) {
        this.mapperQueryName = mapperQueryName;
    }

    public String getMapperQueryPath() {
        return mapperQueryPath;
    }

    public void setMapperQueryPath(String mapperQueryPath) {
        this.mapperQueryPath = mapperQueryPath;
    }

    public String getMapperQueryFileName() {
        return mapperQueryFileName;
    }

    public void setMapperQueryFileName(String mapperQueryFileName) {
        this.mapperQueryFileName = mapperQueryFileName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServicePath() {
        return servicePath;
    }

    public void setServicePath(String servicePath) {
        this.servicePath = servicePath;
    }

    public String getServiceFileName() {
        return serviceFileName;
    }

    public void setServiceFileName(String serviceFileName) {
        this.serviceFileName = serviceFileName;
    }

    public String getServiceQueryName() {
        return serviceQueryName;
    }

    public void setServiceQueryName(String serviceQueryName) {
        this.serviceQueryName = serviceQueryName;
    }

    public String getServiceQueryPath() {
        return serviceQueryPath;
    }

    public void setServiceQueryPath(String serviceQueryPath) {
        this.serviceQueryPath = serviceQueryPath;
    }

    public String getServiceQueryFileName() {
        return serviceQueryFileName;
    }

    public void setServiceQueryFileName(String serviceQueryFileName) {
        this.serviceQueryFileName = serviceQueryFileName;
    }

    public void setMapperPath(String mapperPath) {
        this.mapperPath = mapperPath;
    }

    public void setMapperFileName(String mapperFileName) {
        this.mapperFileName = mapperFileName;
    }

    public String getMapperParamJavaFilePath() {
        String path = "src/main/java/" + mapperQueryPath.replace(".", "/");
        exists(path);
        return path + "/" + mapperQueryFileName + ".java";
    }

    public String getServiceJavaFilePath() {
        String path = "src/main/java/" + servicePath.replace(".", "/");
        exists(path);
        return path + "/" + serviceFileName + ".java";
    }

    public String getServiceQueryJavaFilePath() {
        String path = "src/main/java/" + serviceQueryPath.replace(".", "/");
        exists(path);
        return path + "/" + serviceQueryFileName + ".java";
    }

    public String getControllerJavaFilePath() {
        String path = "src/main/java/" + controllerPath.replace(".", "/");
        exists(path);
        return path + "/" + controllerFileName + ".java";
    }

    public String getViewFilePath(String viewName) {
        String path = "src/main/webapp/WEB-INF/templates/" + module + "/"
                      + getEntitySimpleName().replace("DO", "").toLowerCase();
        exists(path);
        return path + "/" + viewName;
    }

    private void exists(String path) {
        File file = new File(path);
        // 判断文件夹是否存在,如果不存在则创建文件夹
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public String getControllerRequestPath() {
        return controllerRequestPath;
    }

    public void setControllerRequestPath(String controllerRequestPath) {
        this.controllerRequestPath = controllerRequestPath;
    }

    public String getControllerFileName() {
        return controllerFileName;
    }

    public void setControllerFileName(String controllerFileName) {
        this.controllerFileName = controllerFileName;
    }

    public String getControllerPath() {
        return controllerPath;
    }

    public void setControllerPath(String controllerPath) {
        this.controllerPath = controllerPath;
    }

    public String getViewListString() {
        List<ResultMap> resultMaps = getResultMaps();
        ViewListTemplate template = new ViewListTemplate(resultMaps);
        return template.getViewListString();
    }

    public String getViewAddString() {
        List<ResultMap> resultMaps = getResultMaps();
        ViewAddTemplate template = new ViewAddTemplate(resultMaps,
                                                       "/" + getEntitySimpleName().replace("DO", "").toLowerCase());
        return template.getViewAddString();
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

}
