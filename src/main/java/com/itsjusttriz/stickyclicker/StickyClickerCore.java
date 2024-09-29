package com.itsjusttriz.stickyclicker;

import com.itsjusttriz.stickyclicker.commands.StickyClickerCommands;
import com.mojang.logging.LogUtils;
import net.minecraft.world.InteractionHand;
import net.minecraftforge.client.event.RegisterClientCommandsEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

import java.util.HashMap;

@Mod(StickyClickerCore.MOD_ID)
public class StickyClickerCore
{
    public static final String MOD_ID = "stickyclicker";
    public static final Logger logger = LogUtils.getLogger();

    HashMap<String, String> KEY_MAP = new HashMap<>()
    {{
        put("left", "key.attack");
        put("right", "key.use");
    }};

    private static String keyBind = null;

    public StickyClickerCore()
    {
        MinecraftForge.EVENT_BUS.register(this);
    }

    public static String getKeyBinding() {
        return keyBind;
    }

    public static void setKeyBinding(String keyBinding) {
        keyBind = keyBinding;
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        logger.info("Loading StickyClicker...");
    }


    @SubscribeEvent
    public void onCommandsRegister(RegisterClientCommandsEvent event)
    {
        new StickyClickerCommands(event.getDispatcher());
    }

    @SubscribeEvent
    public void onTick(TickEvent.PlayerTickEvent event)
    {
        switch (keyBind)
        {
            case "left":
                break;
            case "right":
                break;
            default:
                break;
        }
    }
}
