package cn.xiaomanmc.mods.realms.entity;

import cn.xiaomanmc.mods.realms.permission.WarpPermission;
import cn.xiaomanmc.mods.realms.permission.WarpPermissions;
import net.minecraft.util.math.Position;

import java.util.*;

public class Warp {
    private Position warpPosition;

    private String warpName;

    private Map<PermissionEntity, List<WarpPermission>> permissions;

    private Warp(Position warpPosition, String warpName, Map<PermissionEntity, List<WarpPermission>> permissions) {
        this.warpPosition = warpPosition;
        this.warpName = warpName;
        this.permissions = permissions;
    }

    public static Warp initNewWarp(Position position, String warpName, UUID owner) {
        Map<PermissionEntity, List<WarpPermission>> permissions = new HashMap<>();
        List<WarpPermission> ownerPermission = new ArrayList<>();
        ownerPermission.add(new WarpPermission(warpName, WarpPermissions.TELEPORT));
        ownerPermission.add(new WarpPermission(warpName, WarpPermissions.DELETE));
        permissions.put(new PermissionEntity(PermissionEntity.PermissionEntityType.PLAYER, owner), ownerPermission);
        return new Warp(position, warpName, permissions);
    }

    public Position getWarpPosition() {
        return warpPosition;
    }

    public String getWarpName() {
        return warpName;
    }

    public Map<PermissionEntity, List<WarpPermission>> getPermissions() {
        return permissions;
    }
}
