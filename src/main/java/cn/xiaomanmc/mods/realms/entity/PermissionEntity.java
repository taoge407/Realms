package cn.xiaomanmc.mods.realms.entity;

import cn.xiaomanmc.mods.realms.permission.Permission;

import java.util.Set;
import java.util.UUID;

public class PermissionEntity {
    public static abstract class PermissionEntityType {
        public static final int PLAYER = 1;
        public static final int EVERYONE = 0;
        public static final int TEAM = 2;
    }

    private final int entityType;

    private final UUID UUID;

    public PermissionEntity(int entityType, UUID UUID) {
        this.entityType = entityType;
        this.UUID = UUID;
    }

    public int getEntityType() {
        return entityType;
    }

    public UUID getUUID() {
        return UUID;
    }

}
