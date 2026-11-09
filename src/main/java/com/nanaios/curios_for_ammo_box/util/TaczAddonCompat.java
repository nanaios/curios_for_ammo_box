package com.nanaios.curios_for_ammo_box.util;

import net.minecraft.world.entity.player.Inventory;

/**
 * TACZ-addon (taczaddon) との互換処理。
 * <p>
 * taczaddon のクラスはバージョンによってパッケージが変わる
 * (1.2.0 で com.mafuyu404.taczaddon.init から com.mafuyu404.taczaddon.storage に移動した) ので、
 * コンパイル時には参照せず、クラス名で見分ける。
 */
public final class TaczAddonCompat {
    private static final String PACKAGE_PREFIX = "com.mafuyu404.taczaddon.";
    private static final String VIRTUAL_INVENTORY_SUFFIX = ".VirtualInventory";

    private TaczAddonCompat() {
    }

    /**
     * taczaddon の VirtualInventory かどうか。
     * <p>
     * taczaddon 1.2.0 は、tacz の ClientAmmoCount.get が数えるインベントリを、
     * プレイヤーのインベントリ・Curios スロット・バックパックの中身を集めた VirtualInventory に差し替える。
     */
    public static boolean isVirtualInventory(Inventory inventory) {
        String name = inventory.getClass().getName();
        return name.startsWith(PACKAGE_PREFIX) && name.endsWith(VIRTUAL_INVENTORY_SUFFIX);
    }
}
