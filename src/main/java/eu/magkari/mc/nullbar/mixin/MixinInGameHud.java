package eu.magkari.mc.nullbar.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import eu.magkari.mc.nullbar.NullBar;
import net.minecraft.client.gui.hud.InGameHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(InGameHud.class)
public class MixinInGameHud {
    @ModifyExpressionValue(
            method="getCurrentBarType",
            at=@At(value = "INVOKE", target="Lnet/minecraft/client/world/ClientWaypointHandler;hasWaypoint()Z")
    )
    private boolean nullbar$test(boolean o) {
        return NullBar.show && o;
    }
}