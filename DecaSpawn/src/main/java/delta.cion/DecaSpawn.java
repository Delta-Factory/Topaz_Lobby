package delta.cion;

import delta.cion.api.plugins.TopazPlugin;

public class DecaSpawn extends TopazPlugin {

	@Override
	public void onEnable() {
		getLogger().info("Plugin started!");
	}

	@Override
	public void onDisable() {
		getLogger().info("Disabling plugin!");
	}
}
