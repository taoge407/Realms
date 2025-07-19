package cn.xiaomanmc.mods.realms.config;

public class CommonConfig {

    private String configVersion = "V1";

    private Double perBlockCost = 0.5;

    private Double createWarpCost = 10.0;

    public CommonConfig() {}

    public CommonConfig(String configVersion, Double perBlockCost, Double createWarpCost) {
        this.configVersion = configVersion;
        this.perBlockCost = perBlockCost;
        this.createWarpCost = createWarpCost;
    }

    public String getConfigVersion() {
        return configVersion;
    }

    public void setConfigVersion(String configVersion) {
        this.configVersion = configVersion;
    }

    public Double getPerBlockCost() {
        return perBlockCost;
    }

    public void setPerBlockCost(Double perBlockCost) {
        this.perBlockCost = perBlockCost;
    }

    public Double getCreateWarpCost() {
        return createWarpCost;
    }

    public void setCreateWarpCost(Double createWarpCost) {
        this.createWarpCost = createWarpCost;
    }
}
