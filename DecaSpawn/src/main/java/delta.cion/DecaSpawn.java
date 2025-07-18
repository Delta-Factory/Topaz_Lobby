package delta.cion;

import delta.cion.api.plugins.TopazPlugin;
import delta.cion.listeners.PlayerConnect;

public class DecaSpawn extends TopazPlugin {

	private static TopazPlugin instance;

	public static TopazPlugin getInstance() {
		return instance;
	}

	@Override
	public void onEnable() {
		instance = this;
		saveDefaultConfig();
		getEventNode().addListener(new PlayerConnect());
	}
}
