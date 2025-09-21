package cn.xiaomanmc.mods.realms.entity;

import cn.xiaomanmc.mods.realms.permission.Permission;

import java.util.Set;

public class PermissionEntity {
    public static abstract class PermissionEntityType {
        public static final int PLAYER = 1;
        public static final int EVERYONE = 0;
        public static final int TEAM = 2;
    }

    private final int entityType;

    private final String entityName;

    private final Set<Permission> permissions;

    public PermissionEntity(int entityType, String entityName, Set<Permission> permissions) {
        this.entityType = entityType;
        this.entityName = entityName;
        this.permissions = permissions;
    }

    public void addPermission(Permission permission) {
        this.permissions.add(permission);
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public int getEntityType() {
        return entityType;
    }

    public String getEntityName() {
        return entityName;
    }

}
