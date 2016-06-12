package org.mybatis.ext.matedata;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

public class MapperFactory {

    private String               inputEncoding          = "UTF-8";
    private String               outputEncoding         = "UTF-8";

    private String               MAPPER_SQL             = "mapper_sql.vm";
    private String               MAPPER_JAVA            = "mapper_java.vm";
    private String               MAPPER_PARAM_JAVA      = "mapper_query_java.vm";

    private String               SERVICE_JAVA           = "service_java.vm";
    private String               SERVICE_QUERY_JAVA     = "service_query_java.vm";

    private String               CONTROLLER_JAVA        = "controller_java.vm";

    private Boolean              createSql              = true;
    private Boolean              createJava             = true;
    private Boolean              createMapperParamJava  = true;
    private Boolean              createServiceJava      = true;
    private Boolean              createServiceQueryJava = true;
    private Boolean              createControllerJava   = false;
    private Boolean              createViewList         = false;

    private Properties           properties;

    private MapperContextFactoty mapperContextFactoty;

    private Properties getProperties() {
        properties = new Properties();
        properties.setProperty(Velocity.INPUT_ENCODING, inputEncoding);
        properties.setProperty(Velocity.OUTPUT_ENCODING, outputEncoding);
        properties.setProperty("file.resource.loader.class",
                               "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        // 也可以用下面方法指定一个绝对路径，不过这样要求你所有的模板都放在该路径下，是有局限的
        URL url = MapperFactory.class.getClassLoader().getResource("");
        properties.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, url.getPath());

        return properties;
    }

    public void build(String entityPackage,String module) {
        List<MapperContext> contexts = mapperContextFactoty.create(entityPackage,module);

        for (MapperContext mapperContext : contexts) {
            VelocityContext velocityContext = new VelocityContext();

            mergerModel2(mapperContext, velocityContext);

            if (createSql) {
                create(velocityContext, MAPPER_SQL, mapperContext.getMapperSqlFilePath());
            }
            if (createJava) {
                create(velocityContext, MAPPER_JAVA, mapperContext.getMapperJavaFilePath());
            }
            if (createMapperParamJava) {
                create(velocityContext, MAPPER_PARAM_JAVA, mapperContext.getMapperParamJavaFilePath());
            }
            if (createServiceJava) {
                create(velocityContext, SERVICE_JAVA, mapperContext.getServiceJavaFilePath());
            }
            if (createServiceQueryJava) {
                create(velocityContext, SERVICE_QUERY_JAVA, mapperContext.getServiceQueryJavaFilePath());
            }
            if (createControllerJava) {
                create(velocityContext, CONTROLLER_JAVA, mapperContext.getControllerJavaFilePath());
            }
            if (createViewList) {
                create(mapperContext.getViewFilePath("list.htm"), mapperContext.getViewListString());
                create(mapperContext.getViewFilePath("add.htm"), mapperContext.getViewAddString());

            }
        }
    }

    private void mergerModel2(MapperContext mapperContext, VelocityContext velocityContext) {
        Map<String, Object> map = new HashMap<String, Object>();

        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(mapperContext.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();

                // 过滤class属性
                if (!key.equals("class")) {
                    // 得到property对应的getter方法
                    Method getter = property.getReadMethod();
                    Object value = getter.invoke(mapperContext);

                    map.put(key, value);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Set<String> keys = map.keySet();
        for (String key : keys) {
            velocityContext.put(key, map.get(key));
        }
    }

    private void create(VelocityContext velocityContext, String sourceFile, String targetFile) {
        FileWriter file;
        try {
            Velocity.init(getProperties());
            Template template = Velocity.getTemplate(sourceFile);
            file = new FileWriter(targetFile);
            template.merge(velocityContext, file);
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void create(String targetFile, String context) {
        FileWriter file;
        try {
            file = new FileWriter(targetFile);
            file.write(context);
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public MapperContextFactoty getMapperContextFactoty() {
        return mapperContextFactoty;
    }

    public void setMapperContextFactoty(MapperContextFactoty mapperContextFactoty) {
        this.mapperContextFactoty = mapperContextFactoty;
    }

    public void setCreateSql(Boolean createSql) {
        this.createSql = createSql;
    }

    public void setCreateJava(Boolean createJava) {
        this.createJava = createJava;
    }

    public void setCreateMapperParamJava(Boolean createMapperParamJava) {
        this.createMapperParamJava = createMapperParamJava;
    }

    public void setCreateServiceJava(Boolean createServiceJava) {
        this.createServiceJava = createServiceJava;
    }

    public void setCreateServiceQueryJava(Boolean createServiceQueryJava) {
        this.createServiceQueryJava = createServiceQueryJava;
    }

    public void setCreateControllerJava(Boolean createControllerJava) {
        this.createControllerJava = createControllerJava;
    }

}
