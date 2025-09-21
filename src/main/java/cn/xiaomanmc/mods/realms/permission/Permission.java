package cn.xiaomanmc.mods.realms.permission;

import java.util.List;

public interface Permission {

    List<String> getPermissionKnotList();

    default String toId() {
        StringBuilder sb = new StringBuilder();
        for (String knot: getPermissionKnotList()) {
            sb.append(knot).append(".");
        }
        sb.deleteCharAt(sb.length() -1);
        return sb.toString();
    }
}
