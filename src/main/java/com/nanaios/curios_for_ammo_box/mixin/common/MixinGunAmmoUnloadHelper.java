package com.nanaios.curios_for_ammo_box.mixin.common;

import com.nanaios.curios_for_ammo_box.util.ItemHandlerWithCurios;
import com.tacz.guns.util.GunAmmoUnloadHelper;
import net.minecraftforge.items.IItemHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

/// tacz 1.2.0 で追加された「銃から弾薬を取り出す」機能で、
/// 取り出した弾薬を curios スロットの弾薬箱にも戻せるようにする
@Mixin(value = GunAmmoUnloadHelper.class, remap = false)
public class MixinGunAmmoUnloadHelper {

    @ModifyVariable(method = "returnToAmmoBoxes", at = @At("HEAD"), argsOnly = true)
    private static IItemHandler wrapItemHandlerForReturnToAmmoBoxes(IItemHandler itemHandler) {
        return ItemHandlerWithCurios.create(itemHandler);
    }
}
