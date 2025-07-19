package cn.xiaomanmc.mods.realms.config;

import java.sql.*;

public class SQLiteDBManager {
    private boolean isConnected = false;

    private Connection connection;

    public void load() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:" + ConfigFileManager.configFolderPath.resolve("realms.db"));
        isConnected = true;
    }

    public ResultSet executeWithResult(String command) throws SQLException {
        if (!isConnected) {
            throw new SQLException("the database is not connected!");
        }
        return connection.prepareStatement(command).executeQuery();
    }
}
