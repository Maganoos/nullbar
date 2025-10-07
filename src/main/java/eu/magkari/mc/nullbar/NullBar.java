package eu.magkari.mc.nullbar;

import net.fabricmc.api.ClientModInitializer;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import org.lwjgl.glfw.GLFW;

public class NullBar implements ClientModInitializer {
	public static boolean show = false;

	@Override
	public void onInitializeClient() {
		KeyBinding bind = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"key.nullbar.show",
				GLFW.GLFW_KEY_LEFT_ALT,
                KeyBinding.Category.MISC
		));
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
            show = bind.isPressed();
		});
	}
}