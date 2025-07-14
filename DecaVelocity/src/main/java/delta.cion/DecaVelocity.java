package delta.cion;

import delta.cion.api.plugins.TopazPlugin;

public class DecaVelocity extends TopazPlugin {

	private static TopazPlugin instance;

	public static TopazPlugin getInstance() {
		return instance;
	}

	@Override
	public void onEnable() {
		instance = this;
		saveDefaultConfig();
	}

	@Override
	public void onDisable() {

	}
}
