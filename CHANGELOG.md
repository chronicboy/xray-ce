## [1.0.0] - 2026-04-28

### Features
- **Xray Vision:** Selective block rendering for ores, chests, and spawners.
- **Fullbright:** Maximum brightness override during Xray mode.
- **Gloom Bypass:** Suppresses BTW Gloom effects (insanity/darkness) while Xray is active.
- **Toggle Keybind:** Instant toggle using the `X` key.
- **Server Enforcement:** Implemented `isRequiredClientAndServer = true` to ensure mod parity between client and server.
- **Optimized Rendering:** O(1) block filtering using static boolean arrays for zero performance impact.

### Technical
- **Mixin Integration:**
  - `RenderBlocks`: Intercepts `renderBlockByRenderType` for selective visibility.
  - `Block`: Bypasses `shouldSideBeRendered` to show buried blocks.
  - `EntityPlayer`: Forces `gloomLevel` to 0.
- **Performance:** Replaced string-based block lookups with ID-based array checks.
