# 🎨 CryonixLauncher - Color & Design Quick Reference

## 🎯 Quick Access Color Codes

```
PRIMARY PALETTE:
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
█ #0f1419  ← Main Background (Deep Space Black)
█ #1a1f28  ← Header Background (Dark Grey-Blue)
█ #141820  ← Card Background (Card Grey)
█ #00d9ff  ← Primary Accent (Cyan/Bright Blue)
█ #7cff96  ← Secondary Accent (Neon Green)
█ #ffffff  ← Text Primary (White)
```

## 📐 Key Dimensions

```
HEADER:           60dp (landscape) / 64dp (portrait)
SIDEBAR WIDTH:    260dp (landscape only)
ACCENT BAR:       3dp (glowing line)
BUTTON HEIGHT:    42-48dp
BUTTON RADIUS:    6-8dp
PADDING:          16-24dp standard
DIVIDER HEIGHT:   1dp
ICON SIZE:        24-28dp
```

## 🎨 Gradient Combinations

```
HEADER ACCENT:     #0099ff → #00d9ff (Blue to Cyan)
DIVIDER ACCENT:    #00d9ff → #00ff88 → #7cff96 (Cyan to Green)
BUTTON PRIMARY:    #0099ff (45°) → #00d9ff (Cyan fade)
BUTTON PLAY:      #00d9ff → #00ff88 → #7cff96 (Cyan to Green glow)
```

## 🔘 Button Style Reference

```
┌─────────────────────────────────────┐
│ NAVIGATION BUTTONS                  │
│ ┌─────────────────────────────────┐ │
│ │ Background: #1a1f28             │ │
│ │ Border: 1px #2a3142            │ │
│ │ Text: #e0e0ff                  │ │
│ │ Radius: 6dp                    │ │
│ │ Height: 42dp                   │ │
│ └─────────────────────────────────┘ │
└─────────────────────────────────────┘

┌─────────────────────────────────────┐
│ PRIMARY BUTTONS                     │
│ ┌─────────────────────────────────┐ │
│ │ Background: Blue→Cyan Gradient  │ │
│ │ Text: White                     │ │
│ │ Radius: 6dp                     │ │
│ │ Height: 48dp                    │ │
│ │ Shadow: Optional glow effect    │ │
│ └─────────────────────────────────┘ │
└─────────────────────────────────────┘

┌─────────────────────────────────────┐
│ ⭐ PLAY BUTTON                      │
│ ┌─────────────────────────────────┐ │
│ │ Background: Cyan→Green Gradient │ │
│ │ Text: Black (bold)              │ │
│ │ Radius: 8dp                     │ │
│ │ Height: 56dp                    │ │
│ │ Text Size: 16ssp bold           │ │
│ │ Letter Spacing: 0.08            │ │
│ └─────────────────────────────────┘ │
└─────────────────────────────────────┘
```

## 🎭 Component Styling

```
HEADER:
├─ Background: #1a1f28
├─ Accent Bar: 3dp gradient #0099ff→#00d9ff
├─ Logo Tint: #00d9ff
├─ Title: White, bold, 0.08 letter-spacing
└─ Badge: #0a3a52 bg, #00d9ff border+text

SIDEBAR (Landscape):
├─ Width: 260dp
├─ Background: #141820
├─ Button Style: #1a1f28 + #2a3142 border
├─ Section Title: #7a8ebd, 0.1 letter-spacing
└─ Divider: #2a3142 (1dp)

CARDS:
├─ Background: #151b24
├─ Border: 1px #2a3545
├─ Radius: 8dp
├─ Title Labels: Cyan or Green accent
└─ Padding: 16dp

SPINNER:
├─ Background: #0f1419
├─ Border: 1px #00d9ff
├─ Text: #e0e0ff
├─ Radius: 6dp
└─ Tint: #00d9ff
```

## 📱 Layout Structure

```
LANDSCAPE:
┌────────────────────────────────────────┐
│ ★ HEADER (60dp) [ACCENT BAR 3dp]      │
├────────────────┬──────────────────────┤
│  SIDEBAR       │  CONTENT PANEL       │
│  (260dp)       │  (Dynamic Width)     │
│                │                      │
│  [Buttons]     │  ┌────────────────┐ │
│   • Control    │  │ Welcome Title  │ │
│   • Utils      │  │────────────────│ │
│   • Links      │  │ Version Card   │ │
│                │  │────────────────│ │
│  [Dividers]    │  │ Profile Card   │ │
│                │  │────────────────│ │
│                │  │ [Spacer]       │ │
│                │  │────────────────│ │
│                │  │ ★ PLAY BUTTON │ │
│                │  └────────────────┘ │
└────────────────┴──────────────────────┘

PORTRAIT:
┌──────────────────────────────┐
│ ★ HEADER (64dp)              │
├──────────────────────────────┤
│ Scrollable Content:          │
│ • Welcome + Divider          │
│ • Quick Access (2 col)       │
│ • Controls (Full)            │
│ • Utilities (Full)           │
│ • [Spacer]                   │
├──────────────────────────────┤
│ Version Selector             │
│ Profile Button               │
│ ★ PLAY BUTTON               │
└──────────────────────────────┘
```

## 🎯 Accent Usage

```
CYAN (#00d9ff): Used for...
├─ Header accent bar
├─ Logo tint
├─ Subtitle badge
├─ Section headers (Version)
├─ Spinner borders
└─ Primary button gradients

GREEN (#7cff96): Used for...
├─ Secondary accents
├─ Profile section headers
├─ Divider gradients
└─ Play button gradient (prominent)
```

## 📏 Typography Scale

```
FUNCTION          SIZE  STYLE           LETTER-SPACING
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
Header Title      24ssp Bold            0.08
Welcome Title     28ssp Bold            0.02
Section Headers   9ssp  Bold UPPERCASE  0.1
Body Text         13ssp Regular         0.0
Button Text       16ssp Bold UPPERCASE  0.08
Badge Text        9ssp  Bold            0.05
Labels            12ssp Regular         0.0
```

## 🖼️ File Reference Map

```
DIRECTORY STRUCTURE:
drawable/
├─ gradient_blue_cyan.xml (Header + primary buttons)
├─ gradient_cyan_green.xml (Dividers + highlights)
├─ badge_background.xml (Subtitle badge)
├─ button_nav_background.xml (Sidebar buttons)
├─ card_background_dark.xml (Content cards)
├─ spinner_background.xml (Dropdown selector)
├─ button_primary_gradient.xml (Edit profile)
└─ button_play_gradient.xml (⭐ Main action)

layout/
├─ fragment_launcher.xml (PORTRAIT)
└─ layout-land/fragment_launcher.xml (LANDSCAPE)

values/
├─ colors_lunar_theme.xml (All color definitions)
└─ strings_ui_theme.xml (UI text strings)

DOCUMENTATION:
├─ UI_DESIGN_DOCUMENTATION.md (Full specs)
├─ UI_SETUP_GUIDE.md (Setup & customization)
├─ REDESIGN_SUMMARY.md (Project overview)
├─ IMPLEMENTATION_CHECKLIST.md (Status check)
└─ COLORS_QUICK_REFERENCE.md (This file)
```

## 🔧 Common Customization Values

```
To change accent color:        Edit colors_lunar_theme.xml
To change background:           Edit fragment_launcher.xml lines with #0f1419
To change header color:         Edit fragment_launcher.xml lines with #1a1f28
To change gradient start:       Edit gradient_*.xml files
To change button height:        Edit @dimen/ values
To change sidebar width:        Edit _260sdp to desired width
To change text color:           Edit android:textColor attributes
To change border color:         Edit #2a3142 hex values
```

## ✨ Styling Snapshot

```
┌─────────────────────────────────────────────┐
│  ★ CRYONIX          ⚡BETA                 │  ← Header 60dp
│  ═════════════════════════════════════════  │  ← Accent 3dp
├─────────────────┬───────────────────────────┤
│  CONTROLS       │  READY TO PLAY            │
│  ✓ Customize    │  ┌─────────────────────┐ │
│  ✓ Install JAR  │  │ Select Profile &    │ │
│  ═════════════  │  │ Launch Minecraft    │ │
│  ════════════   │  └─────────────────────┘ │
│  UTILITIES      │  MINECRAFT VERSION       │
│  ✓ Share Logs   │  ┌─────────────────────┐ │
│  ✓ Open Files   │  │ [Version Dropdown ▼]│ │
│  ═════════════  │  └─────────────────────┘ │
│  RESOURCES      │  GAME PROFILE            │
│  ✓ Wiki         │  ┌─────────────────────┐ │
│  ✓ Social       │  │ [Edit Profile Btn]  │ │
│                 │  └─────────────────────┘ │
│                 │  ┌─────────────────────┐ │
│                 │  │ ★ ★ PLAY BUTTON ★ ★│ ← Gradient Glow
│                 │  └─────────────────────┘ │
└─────────────────┴───────────────────────────┘
```

## 🎨 Dark Mode Values (If Toggled)

```
Would apply for light mode (future):
Light Background:    #ffffff or #f5f5f5
Light Header:        #f0f0f0
Light Cards:         #ffffff
Dark Accent:         #0066cc (darker blue)
Text on Light:       #333333 (dark grey)
```

## 🚀 Building & Testing

```
Build:   ./gradlew clean build
Install: ./gradlew installDebug
Test:    Run on landscape device/emulator
Verify:  Check colors match palette above
```

---

**Quick Reference Card v1.0**
**Last Updated**: May 8, 2026
**Theme**: Premium Lunar Dark Mode (Cyan + Green)

