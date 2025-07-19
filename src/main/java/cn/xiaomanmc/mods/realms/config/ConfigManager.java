package cn.xiaomanmc.mods.realms.config;

import net.fabricmc.loader.api.FabricLoader;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.nodes.Tag;

import java.io.*;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class ConfigManager<T> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigManager.class);

    /**
     * Fuck Mojang, how to get the fucking runDir?
     */
    public static final Path configFolderPath = FabricLoader.getInstance().getConfigDir();

    public final Path configPath;

    private final String configName;

    private final Class<?> beanClass;
    /*
    Map<String, Object> config = new HashMap<>();
    */

    private T bean;

    public ConfigManager(T type/*, boolean saveValue*/) {
        beanClass = type.getClass();
        //lower first character
        String typeClassName = beanClass.getSimpleName();
        configName = typeClassName.substring(0, 1).toLowerCase() + typeClassName.substring(1);

        configPath = configFolderPath.resolve(configName + ".yml");
    }


    public void load() throws IOException {
        File configFile = configPath.toFile();
        FileReader reader = new FileReader(configFile);
        Yaml yaml = new Yaml();
        /*
        Map<String, Object> loadedConfig = yaml.load(reader);
        config.replaceAll((key, value) -> loadedConfig);

         */
        bean = yaml.load(reader);
    }

    public void save() throws IOException {
        File configFile = configPath.toFile();
        FileWriter writer = new FileWriter(configFile);
        Yaml yaml = new Yaml();
        writer.write(yaml.dumpAs(bean, Tag.MAP, null));
        writer.close();
    }

    public T get() {
        return bean;
    }

    public void set(T bean) {
        this.bean = bean;
    }

    @SuppressWarnings("unchecked")
    private T mapToBean(Map<String, Object> values) throws Exception {
        Method[] methods = beanClass.getMethods();
        Object bean = beanClass.getDeclaredConstructor().newInstance();
        for (Method method: methods) {
            String methodName = method.getName();
            if (methodName.startsWith("get")) {
                String key = methodName.substring(3);
                key = StringUtils.uncapitalize(key);
                method.invoke(bean, values.get(key));
            }
        }
        return (T) bean;
    }

    private Map<String, Object> beanToMap(T bean) {
        Method[] methods = bean.getClass().getMethods();
        Map<String, Object> map = new HashMap<>();
        try {
            for (Method method : methods) {
                String methodName = method.getName();
                if (methodName.startsWith("get")) {
                    String key = methodName.substring(3);
                    key = StringUtils.uncapitalize(key);
                    Object value = method.invoke(bean);
                    map.put(key, value);
                }
            }
        } catch (Exception e) {
            LOGGER.error("Exception in ConfigManager toMapping: ", e);
        }
        return map;
    }

}
