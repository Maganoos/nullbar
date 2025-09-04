package eu.magkari.mc.nullbar;

import net.fabricmc.api.ClientModInitializer;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import org.lwjgl.glfw.GLFW;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public class NullBar implements ClientModInitializer {
	public static final String MOD_ID = "nullbar";
	public static boolean show = false;

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	//	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitializeClient() {
		KeyBinding bind = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"key.nullbar.show",
				GLFW.GLFW_KEY_LEFT_ALT,
				"key.categories.misc"
		));
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
            show = bind.isPressed();
		});
	}
}