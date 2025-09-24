package cn.xiaomanmc.mods.realms;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Realms implements ModInitializer {

    public static final String MODID = "realms";
    private static final Logger LOGGER = LoggerFactory.getLogger(MODID);

    @Override
    public void onInitialize() {
        LOGGER.info("Hello World!");
    }
}
