package cn.xiaomanmc.mods.realms.config;

import cn.xiaomanmc.mods.realms.entity.Warp;

import java.sql.SQLException;
import java.util.UUID;

public interface WarpConfigManager {

    Warp loadByName(String name);

    void save(Warp warp) throws SQLException;
}
