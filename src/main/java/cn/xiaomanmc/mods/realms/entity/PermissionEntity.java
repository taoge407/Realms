package cn.xiaomanmc.mods.realms.entity;

public class PermissionEntity {
    public static final int PLAYER = 1;
    public static final int EVERYONE = 0;
    public static final int TEAM = 2;

    private final int entityType;

    private final String entityName;

    public PermissionEntity(int entityType, String entityName) {
        this.entityType = entityType;
        this.entityName = entityName;
    }
    public int getEntityType() {
        return entityType;
    }

    public String getEntityName() {
        return entityName;
    }
}
