package com.nanaios.curios_for_ammo_box.mixin.common;

import com.nanaios.curios_for_ammo_box.util.InventoryWithCurios;
import com.nanaios.curios_for_ammo_box.util.TaczAddonCompat;
import com.tacz.guns.client.gameplay.ClientAmmoCount;
import net.minecraft.world.entity.player.Inventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

// tacz 1.2.0 で、HUD の所持弾数の数え上げが GunHudOverlay.handleInventoryAmmo から ClientAmmoCount.get に移った
@Mixin(value = ClientAmmoCount.class, remap = false)
public class MixinGunHudOverlay {
    @ModifyVariable(method = "get", at = @At("STORE"), name = "inventory")
    private static Inventory wrapInventoryForAmmoHandling(Inventory inventory) {
        // taczaddon が差し替えた VirtualInventory には Curios スロットの中身がもう入っているので、包むと二重に数えてしまう
        if (TaczAddonCompat.isVirtualInventory(inventory)) {
            return inventory;
        }
        return new InventoryWithCurios(inventory);
    }
}
