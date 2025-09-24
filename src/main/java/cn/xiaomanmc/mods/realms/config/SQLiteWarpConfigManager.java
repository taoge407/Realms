package cn.xiaomanmc.mods.realms.config;

import cn.xiaomanmc.mods.realms.entity.Warp;

import java.sql.SQLException;

//todo
public class SQLiteWarpConfigManager implements WarpConfigManager{

    private SQLiteDBManager dbManager;

    public SQLiteWarpConfigManager() {
        dbManager = new SQLiteDBManager();
    }

    @Override
    public Warp loadByName(String name) {
        return null;
    }

    @Override
    public void save(Warp warp) throws SQLException {

    }
}
