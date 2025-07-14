package delta.cion;

import delta.cion.api.plugins.TopazPlugin;
import net.minestom.server.extras.velocity.VelocityProxy;

public class DecaVelocity extends TopazPlugin {

	private static TopazPlugin instance;

	public static TopazPlugin getInstance() {
		return instance;
	}

	private static String getVelocityToken() {
		return getInstance().getConfig().getString("velocity-token");
	}

	private static void enableVelocity() {
		String token = getVelocityToken();
		if (token != null && !token.isBlank()) VelocityProxy.enable(token);
		getInstance().getLogger().error("Velocity token is null!");
	}

	@Override
	public void onEnable() {
		instance = this;
		saveDefaultConfig();

		getLogger().info("Trying to start Velocity!");
		enableVelocity();
	}

	@Override
	public void onDisable() {

	}
}
