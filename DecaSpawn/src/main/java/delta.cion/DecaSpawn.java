package delta.cion;

import delta.cion.api.plugins.TopazPlugin;

public class DecaSpawn extends TopazPlugin {

	private static TopazPlugin instance;

	public static TopazPlugin getInstance() {
		return instance;
	}

	@Override
	public void onEnable() {
		instance = this;
		getLogger().info("Plugin started!");
	}

	@Override
	public void onDisable() {
		getLogger().info("Disabling plugin!");
	}
}
