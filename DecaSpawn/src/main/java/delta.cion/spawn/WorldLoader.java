package delta.cion.spawn;

import delta.cion.DecaSpawn;
import net.minestom.server.MinecraftServer;
import net.minestom.server.coordinate.Pos;
import net.minestom.server.instance.InstanceContainer;
import net.minestom.server.instance.anvil.AnvilLoader;
import org.slf4j.Logger;

import java.io.File;
import java.io.FileFilter;
import java.nio.file.Path;
import java.util.Objects;

public class WorldLoader {

	private final InstanceContainer CONTAINER = MinecraftServer.getInstanceManager().createInstanceContainer();

	private final Logger LOGGER = DecaSpawn.getInstance().getLogger();

	private static final File PLUGIN_DIR = DecaSpawn.getInstance().getPluginDir();
	private static final Path WORLD_PATH = new File(PLUGIN_DIR, "world").toPath();;

	public WorldLoader() {
		if (WORLD_PATH.toFile().isFile() || !WORLD_PATH.toFile().exists()) {
			if (WORLD_PATH.toFile().mkdirs()) LOGGER.error("World directory not found but created");
			DecaSpawn.getInstance().disable();
		}
		if (Objects.requireNonNull(WORLD_PATH.toFile().listFiles(isMCA())).length == 0) {
			LOGGER.error("Spawn files not found!");
			DecaSpawn.getInstance().disable();
		}
	}

	public InstanceContainer getWorld() {
		this.CONTAINER.setChunkLoader(new AnvilLoader(WORLD_PATH));
		return this.CONTAINER;
	}

	public Pos getSpawnPos() {
		Integer[] cords = DecaSpawn.getInstance().getConfig().getIntList("spawn-cords");
		return new Pos(cords[0], cords[1], cords[2]);
	}

	private static FileFilter isMCA() {
		return pathname -> pathname.getName().endsWith(".mca");
	}
}
