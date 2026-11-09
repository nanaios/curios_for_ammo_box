# Changelog

<!--
「## <バージョン>」の節が、そのバージョンの更新履歴として Modrinth・CurseForge・GitHub Releases に
公開されます（.github/workflows/publish.yml）。見出しは gradle.properties の mod_version と同じ文字列に
してください。リリースするときは「## Unreleased」をそのバージョンに書き換えます。
1.2.0 までの履歴は Modrinth・CurseForge の各バージョンのページにあります。
-->

## Unreleased

- Fixed a crash with TACZ-addon 1.2.0 (`ClassMetadataNotFoundException: com.mafuyu404.taczaddon.init.VirtualInventory$ItemHandler`).
- Fixed ammo in curio slots being counted twice in the HUD ammo count when TACZ-addon 1.2.0 is installed.

## 1.2.1

- Fixed a crash on startup with TaCZ 1.2.0.
- TaCZ 1.2.0 or later is now required. If you stay on an older TaCZ, keep using version 1.2.0 of this mod.
