package cn.xiaomanmc.mods.realms.permission;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WarpPermission implements Permission{

    private final List<String> permissionKnotList = new ArrayList<>();

    public WarpPermission(String warpName, String permissionName) {
        permissionKnotList.add("warp");
        permissionKnotList.add(warpName);
        Arrays.stream(permissionName.split("\\.")).iterator().forEachRemaining((knot) -> permissionKnotList.add(knot));
    }

    @Override
    public List<String> getPermissionKnotList() {
        return permissionKnotList;
    }
}
