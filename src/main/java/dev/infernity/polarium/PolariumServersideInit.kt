package dev.infernity.polarium

import com.mojang.logging.LogUtils
import dev.infernity.polarium.items.PolariumItems
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.event.Event
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents.ServerStarted
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents.ServerStopped
import net.minecraft.server.MinecraftServer
import net.minecraft.util.Identifier
import net.minecraft.world.World
import org.slf4j.Logger

class PolariumServersideInit : ModInitializer {
    override fun onInitialize() {
        PolariumItems.register()
        PolymerResourcePackUtils.addModAssets(MOD_ID)
        // PolymerResourcePackUtils.markAsRequired();
        LOGGER.info("Hello from Polarium!")
        val id = id("early_reload")
        ServerLifecycleEvents.SERVER_STARTED.addPhaseOrdering(id, Event.DEFAULT_PHASE)
        ServerLifecycleEvents.SERVER_STARTED.register(ServerStarted { s: MinecraftServer ->
            overworld = s.overworld
        })
        ServerLifecycleEvents.SERVER_STARTED.addPhaseOrdering(id, Event.DEFAULT_PHASE)
        ServerLifecycleEvents.SERVER_STOPPED.register(ServerStopped { s: MinecraftServer? ->
            overworld = null
        })
    }

    companion object {
        const val MOD_ID: String = "polarium"
        val LOGGER: Logger = LogUtils.getLogger()

        var overworld: World? = null
            private set

        fun id(path: String?): Identifier {
            return Identifier(MOD_ID, path)
        }

        fun id(): Identifier {
            return Identifier(MOD_ID, "default")
        }
    }
}
