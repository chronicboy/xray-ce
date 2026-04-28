# Xray CE

A high-performance, optimized Xray utility specifically designed for **Better Than Wolves CE (3.0.0+)**.

## Features

- **🚀 Ultra-Fast Rendering**: Uses O(1) block filtering. Unlike other Xray mods that lag the game, Xray CE has zero impact on your FPS.
- **💎 See Everything**: Automatically disables backface culling for ores. You can see buried ores from any angle, even if they aren't exposed to air.
- **☀️ Built-in Fullbright**: Forget torches. Light levels are maximized while Xray is active.
- **🌑 Gloom Immunity**: Bypasses the BTW "Gloom" mechanic, preventing insanity effects and visual darkness.
- **⌨️ Easy Toggle**: Press `X` to instantly toggle your vision.

## Installation

1. Ensure you have **Better Than Wolves CE 3.0.0+** installed.
2. Drop the `xray-ce-1.0.0.jar` into your `mods` folder.
3. This mod is **Server-Enforced**. It must be installed on the server to function.

## Technical Details

Xray CE uses **SpongePowered Mixins** to hook directly into the Minecraft rendering engine:
- `RenderBlocks`: Intercepts block drawing calls.
- `Block`: Bypasses occlusion culling.
- `EntityPlayer`: Neutralizes gloom levels.
- `EntityRenderer`: Overrides lightmap calculations.

## Author
- **chronicboy31**
