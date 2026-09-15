---
name: Construct Modern
colors:
  surface: '#f8f9ff'
  surface-dim: '#d3dae8'
  surface-bright: '#f8f9ff'
  surface-container-lowest: '#ffffff'
  surface-container-low: '#eef4ff'
  surface-container: '#e7eefc'
  surface-container-high: '#e1e9f6'
  surface-container-highest: '#dbe3f1'
  on-surface: '#141c26'
  on-surface-variant: '#45474d'
  inverse-surface: '#29313b'
  inverse-on-surface: '#e9f1ff'
  outline: '#75777e'
  outline-variant: '#c5c6ce'
  surface-tint: '#525e79'
  primary: '#020e26'
  on-primary: '#ffffff'
  primary-container: '#17243c'
  on-primary-container: '#7f8ba8'
  inverse-primary: '#bac6e6'
  secondary: '#914c00'
  on-secondary: '#ffffff'
  secondary-container: '#fd9432'
  on-secondary-container: '#673400'
  tertiary: '#000e27'
  on-tertiary: '#ffffff'
  tertiary-container: '#112442'
  on-tertiary-container: '#7a8caf'
  error: '#ba1a1a'
  on-error: '#ffffff'
  error-container: '#ffdad6'
  on-error-container: '#93000a'
  primary-fixed: '#d7e2ff'
  primary-fixed-dim: '#bac6e6'
  on-primary-fixed: '#0e1b33'
  on-primary-fixed-variant: '#3a4761'
  secondary-fixed: '#ffdcc4'
  secondary-fixed-dim: '#ffb77f'
  on-secondary-fixed: '#2f1500'
  on-secondary-fixed-variant: '#6f3900'
  tertiary-fixed: '#d7e3ff'
  tertiary-fixed-dim: '#b5c7ed'
  on-tertiary-fixed: '#061b39'
  on-tertiary-fixed-variant: '#354767'
  background: '#f8f9ff'
  on-background: '#141c26'
  surface-variant: '#dbe3f1'
  surface-canvas: '#F6F4EF'
  surface-card: '#FFFFFF'
  text-main: '#20252C'
  accent-hover: '#D96F0D'
  status-success: '#2D8A60'
  status-info: '#3B82F6'
  status-warning: '#F59E0B'
  status-danger: '#EF4444'
  status-draft: '#9CA3AF'
typography:
  display-lg:
    fontFamily: Sora
    fontSize: 48px
    fontWeight: '700'
    lineHeight: 56px
    letterSpacing: -0.02em
  display-lg-mobile:
    fontFamily: Sora
    fontSize: 32px
    fontWeight: '700'
    lineHeight: 40px
    letterSpacing: -0.01em
  headline-xl:
    fontFamily: Sora
    fontSize: 36px
    fontWeight: '700'
    lineHeight: 44px
    letterSpacing: -0.015em
  headline-xl-mobile:
    fontFamily: Sora
    fontSize: 26px
    fontWeight: '700'
    lineHeight: 34px
    letterSpacing: -0.01em
  headline-lg:
    fontFamily: Sora
    fontSize: 28px
    fontWeight: '600'
    lineHeight: 36px
    letterSpacing: -0.01em
  headline-md:
    fontFamily: Sora
    fontSize: 22px
    fontWeight: '600'
    lineHeight: 30px
  headline-sm:
    fontFamily: Sora
    fontSize: 18px
    fontWeight: '600'
    lineHeight: 26px
  title-md:
    fontFamily: Inter
    fontSize: 16px
    fontWeight: '600'
    lineHeight: 24px
  body-lg:
    fontFamily: Inter
    fontSize: 18px
    fontWeight: '400'
    lineHeight: 28px
  body-md:
    fontFamily: Inter
    fontSize: 15px
    fontWeight: '400'
    lineHeight: 24px
  body-sm:
    fontFamily: Inter
    fontSize: 13px
    fontWeight: '400'
    lineHeight: 20px
  label-md:
    fontFamily: Inter
    fontSize: 14px
    fontWeight: '600'
    lineHeight: 20px
    letterSpacing: 0.01em
  label-sm:
    fontFamily: Inter
    fontSize: 11px
    fontWeight: '600'
    lineHeight: 16px
    letterSpacing: 0.05em
rounded:
  sm: 0.125rem
  DEFAULT: 0.25rem
  md: 0.375rem
  lg: 0.5rem
  xl: 0.75rem
  full: 9999px
spacing:
  gutter: 1.5rem
  gutter-sm: 1rem
  margin: 2rem
  margin-sm: 1rem
  space-xs: 0.25rem
  space-sm: 0.5rem
  space-md: 1rem
  space-lg: 1.5rem
  space-xl: 2.5rem
---

## Brand & Style

This design system establishes a high-density, professional visual framework engineered specifically for construction management, civil contracting, and technical trade platforms. Combining corporate solidity with industrial utility, the aesthetic draws inspiration from architectural blueprints, steel framing, and job site instrumentation.

The interface addresses three key user profiles: site engineers, general contractors, and corporate project owners. The experience balances rugged clarity with refined SaaS ergonomics:
- **Structural Precision:** Crisp outlines, calibrated micro-radii, and deliberate alignment reflect structural engineering principles.
- **High Operational Contrast:** Critical indicators, safety-critical milestones, and action items cut through administrative data with high-visibility hazard amber and industrial navy tones.
- **Architectural Grounding:** Warm neutral paper surfaces reduce harsh glare during field tablet usage while maintaining contrast for tabular project data.

## Colors

The color palette translates the visual landscape of engineering and architecture into digital surfaces:
- **Primary Navy (`#17243C` & `#213352`):** Delivers bedrock stability, evoking structural steel, technical schematics, and enterprise durability. Used for primary navigation, critical headers, and high-priority states.
- **Safety Orange (`#F18A28` & `#D96F0D`):** Derives from high-visibility personal protective equipment (PPE) and construction equipment. Applied strictly to primary actions, interactive hover states, and critical project conversion triggers.
- **Warm Canvas Neutral (`#F6F4EF`):** An architectural bond-paper background that prevents ocular fatigue under harsh sunlight or long-duration estimation sessions.
- **Data & Workflow States:** Direct functional status tokens map cleanly onto the project lifecycle: Draft (`#9CA3AF`), Published/Open (`#3B82F6`), In Review (`#F59E0B`), In Progress (`#2D8A60`), Paused/Blocked (`#EF4444`).

## Typography

The typographic hierarchy couples geometric authority with legible data delivery:
- **Display & Headings (Sora):** Sora’s geometric cuts, open apertures, and industrial rhythm give platform titles, key performance indicators, and category headings an architectural weight.
- **Body & Controls (Inter):** Inter provides maximum optical legibility for dense technical documentation, bill-of-quantities data tables, chat message streams, and dashboard metrics.
- **Numeric & Metric Scannability:** For numerical financial tables, project milestones, and engineering quantities, Inter should be configured with tabular lining numbers (`font-feature-settings: 'tnum' 1`) to preserve vertical column alignment.

## Layout & Spacing

Layouts follow a structured 12-column grid system tuned for dense engineering data and responsive multi-device field usage:
- **Desktop (1200px+):** 12 columns, 24px (`1.5rem`) gutters, and 32px (`2rem`) page outer margins. Content containers max out at 1280px for standard dashboards, with 1440px wide variants for Gantt charts, CAD previews, and site journal logs.
- **Tablet (768px - 1199px):** 8 columns, 16px (`1rem`) gutters, and 24px (`1.5rem`) margins. Multi-column metric cards stack into paired layouts.
- **Mobile (<768px):** 4 columns, 16px (`1rem`) gutters, and 16px (`1rem`) margins. Complex analytical tables switch to structured card lists with swipeable action strips.
- **Rhythm Model:** An 8pt spatial baseline controls all layout flows and structural paddings, keeping cards, toolbars, and inputs vertically aligned.

## Elevation & Depth

Visual hierarchy favors tactile physical layering over diffuse ambient shadows, reflecting construction material integrity:
- **Ground Floor (Base Canvas):** `#F6F4EF` provides a soft matte substrate.
- **Structural Plates (Level 1):** `#FFFFFF` surfaces with a 1px solid structural border (`rgba(23, 36, 60, 0.08)`) and a subtle downward shear (`box-shadow: 0 1px 3px rgba(23, 36, 60, 0.05)`). Used for cards, tables, and list groups.
- **Raised Equipment (Level 2):** Elevated interactive components, toolbars, and hovering cards receive a crisp 1px border (`rgba(23, 36, 60, 0.12)`) and a directional drop (`box-shadow: 0 4px 12px rgba(23, 36, 60, 0.08)`).
- **Overlays & Command Modals (Level 3):** Modal sheets, image galleries, and flyout sidebars use `box-shadow: 0 16px 32px rgba(23, 36, 60, 0.16)` over a tinted backdrop curtain (`rgba(23, 36, 60, 0.60)`).

## Shapes

The shape system employs calibrated micro-radii to maintain an engineered, heavy-duty appearance:
- **Standard Corners (4px / `0.25rem`):** Applied to primary buttons, input fields, badges, and project checklist selectors. Conveys precision machinery.
- **Structural Containers (8px / `0.5rem`):** Applied to project preview cards, modal sheets, and data table wrappers.
- **Interactive Badges & Avatars:** Status pills retain clean 4px bounds, while profile avatars retain round or square-soft treatments to preserve profile visibility.

## Components

### Buttons
- **Primary Action:** Solid `#F18A28` fill, white `#FFFFFF` text, `font-family: 'Inter'`, font weight 600, 4px border radius. Hover state transitions to `#D96F0D`. Focus ring uses a 2px offset with `#F18A28`.
- **Secondary / Structural:** Navy `#17243C` background with white text for administrative actions, exporting logs, or committing contracts.
- **Outline / Blueprint:** 1.5px solid border in `#213352`, transparent background, `#213352` text. Hover fills with `rgba(33, 51, 82, 0.06)`.

### Form Fields & Technical Inputs
- **Text & Numeric Inputs:** White background, 1px solid border in `#717985` (30% opacity), 4px border radius, 12px vertical padding. Focus state elevates the border to 2px solid `#17243C` with zero shadow blur to retain blueprint crispness.
- **Category Selectors & Units:** Integrated prefix/suffix chips (e.g., `m²`, `kg`, `BRL`) rendered with `#F6F4EF` backgrounds and uppercase Sora label typography.

### Status Indicators & Phase Chips
- **Chips:** Monospaced or high-legibility Inter labels, 11px uppercase, tracking `0.05em`. Backgrounds use tinted 10% opacity fills of the functional status color with a 1px matching border:
  - Draft: `#9CA3AF` fill at 12%, `#717985` text.
  - Published: `#3B82F6` fill at 12%, `#1D4ED8` text.
  - In Review: `#F59E0B` fill at 12%, `#B45309` text.
  - In Progress: `#2D8A60` fill at 12%, `#2D8A60` text.
  - Paused: `#EF4444` fill at 12%, `#B91C1C` text.

### Cards & Project Feed Items
- **Project Card:** `#FFFFFF` background, 1px border (`rgba(23, 36, 60, 0.1)`), 8px radius. Features an image aspect ratio of 16:9 for site photos, a distinct category badge at the top-left, and a bottom utility bar housing the contractor avatar, timeline status, and budget estimate.
- **Interactive States:** Subtle 2px upward translation (`translateY(-2px)`) on hover paired with a border shift to `#17243C` at 35% opacity.

### Selection Controls
- **Checkboxes & Radios:** High-contrast 2px borders using `#17243C`. Checked status fills with `#F18A28` for active field tasks and punch lists, displaying a white checkmark icon.

### Project Activity Journal & Metric Trackers
- **Site Progress Bar:** Stepped progress rails with track height of 6px, track background `rgba(23, 36, 60, 0.08)`, and completed intervals filled in solid `#2D8A60`.
- **Contractor Profile Card:** Features verified trade licensing badges, star ratings rendered in `#F18A28`, and technical competency tags wrapped in soft neutral borders.