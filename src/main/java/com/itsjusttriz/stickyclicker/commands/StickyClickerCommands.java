package com.itsjusttriz.stickyclicker.commands;

import com.itsjusttriz.stickyclicker.StickyClickerCore;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraftforge.fml.ModList;

public class StickyClickerCommands {
    public StickyClickerCommands(CommandDispatcher<CommandSourceStack> dispatcher)
    {
        LiteralArgumentBuilder<CommandSourceStack> mainCommand = Commands.literal("sc")
            .then(Commands.literal("test").executes(this::testCommand))
            .then(Commands.literal("help").executes(this::helpCommand))
            .then(
                Commands.literal("set")
                        .then(Commands.literal("left").executes(this::triggerLeft))
                        .then(Commands.literal("right").executes(this::triggerRight))
            )
            .then(Commands.literal("off").executes(this::triggerOff)
        );
        dispatcher.register(mainCommand);
    }


    public int testCommand(CommandContext<CommandSourceStack> ctx)
    {
         ctx.getSource().sendSystemMessage(Component.nullToEmpty("Hello World"));
        return 0;
    }

    public int helpCommand(CommandContext<CommandSourceStack> ctx)
    {
        String VERSION = ModList.get().getModContainerById(StickyClickerCore.MOD_ID).get().getModInfo().getVersion().toString();
        ctx.getSource().sendSystemMessage(Component.nullToEmpty("Version: "+ VERSION));
        return 0;
    }

    int triggerLeft(CommandContext<CommandSourceStack> ctx)
    {
        StickyClickerCore.setKeyBinding("left");
        return 0;
    }

    int triggerRight(CommandContext<CommandSourceStack> ctx)
    {
        StickyClickerCore.setKeyBinding("right");
        return 0;
    }

    int triggerOff(CommandContext<CommandSourceStack> ctx)
    {
        StickyClickerCore.setKeyBinding("off");
        return 0;
    }
}
