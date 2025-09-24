package eu.magkari.mc.nullbar.mixin;

import static eu.magkari.mc.nullbar.NullBar.show;

import net.minecraft.client.gui.hud.InGameHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(InGameHud.class)
public class MixinInGameHud {
    @ModifyVariable(
            method = "getCurrentBarType",
            at = @At(value = "STORE"),
            ordinal = 0)
    private boolean nullbar$showLocator(boolean v) {
        return show && v;
    }
}