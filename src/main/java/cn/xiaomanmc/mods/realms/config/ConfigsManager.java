package cn.xiaomanmc.mods.realms.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ConfigsManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigsManager.class);

    private static final Map<String, ConfigFileManager<?>> configFileManagersPool = new HashMap<>();
    private static final ConfigFileManager<CommonConfig> commonConfigConfigFileManager = new ConfigFileManager<>(new CommonConfig());

    static {
        configFileManagersPool.put(commonConfigConfigFileManager.getConfigName(), commonConfigConfigFileManager);
    }

    public void loadAll() {
        for (String configName: configFileManagersPool.keySet()) {
            ConfigFileManager<?> configFileManager = configFileManagersPool.get(configName);
            try {
                configFileManager.load();
            } catch (IOException e) {
                LOGGER.error("Could not load config file from {}", configFileManager.getConfigName(), e);
            }
        }


    }

}
