package eu.magkari.mc.nullbar.mixin;

import static eu.magkari.mc.nullbar.NullBar.show;

import net.minecraft.client.gui.hud.InGameHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(InGameHud.class)
public class MixinInGameHud {
	@Redirect(
			method = "getCurrentBarType",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/client/gui/hud/InGameHud;shouldShowExperienceBar()Z"
			)
	)
	private boolean showExperienceBarOverride(InGameHud instance) {
        return !show;
    }
}