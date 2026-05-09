# CryonixLauncher UI - Quick Setup & Customization Guide

## 📋 What Was Changed

### 1. **Layout Files Updated**
- **`layout-land/fragment_launcher.xml`** - Landscape optimized view (Primary)
- **`layout/fragment_launcher.xml`** - Portrait fallback view

### 2. **Drawable Resources Created** (8 new files)
- `gradient_blue_cyan.xml` - Header accent line
- `gradient_cyan_green.xml` - Accent dividers
- `badge_background.xml` - Subtitle badge styling
- `button_nav_background.xml` - Navigation button styling
- `card_background_dark.xml` - Card container styling
- `spinner_background.xml` - Dropdown selector styling
- `button_primary_gradient.xml` - Primary action buttons
- `button_play_gradient.xml` - Main play button (prominent)

### 3. **Resource Files Created** (2 new files)
- `colors_lunar_theme.xml` - Complete color palette
- `strings_ui_theme.xml` - Localization-ready strings

## 🎨 Customization Guide

### Change Accent Colors

Edit `colors_lunar_theme.xml`:
```xml
<!-- Change cyan accent to different color -->
<color name="cyan_primary">#YOUR_HEX_COLOR</color>

<!-- Change green accent -->
<color name="green_accent">#YOUR_HEX_COLOR</color>
```

### Change Button Gradients

Edit the gradient files in `drawable/`:

**For Edit Profile Button** (`button_primary_gradient.xml`):
```xml
<gradient
    android:startColor="#NEW_COLOR_1"
    android:endColor="#NEW_COLOR_2" />
```

**For Play Button** (`button_play_gradient.xml`):
```xml
<gradient
    android:startColor="#NEW_COLOR_1"
    android:centerColor="#NEW_COLOR_2"
    android:endColor="#NEW_COLOR_3" />
```

### Change Background Colors

Edit `fragment_launcher.xml` files - find lines like:
```xml
android:background="#0f1419"  <!-- Change this HEX code -->
```

### Modify Sidebar Width (Landscape)
In `layout-land/fragment_launcher.xml`:
```xml
<View
    android:id="@+id/sidebar_background"
    android:layout_width="@dimen/_260sdp"  <!-- Change 260 to desired width -->
```

### Adjust Button Heights & Paddings
In `dimens.xml` (or inline):
```xml
android:layout_height="@dimen/_48sdp"  <!-- Height in SDP units -->
android:padding="@dimen/_16sdp"        <!-- Padding in SDP units -->
```

## 🔧 Common Tasks

### Add New Button to Sidebar
1. Copy an existing button XML in the sidebar ScrollView
2. Change `android:id`, `android:text`, `android:drawableStart`, and `app:layout_constraintTop_toBottomOf`
3. Update the drawable resources with a new icon

### Change Header Title Color
Find `launcher_title` TextView:
```xml
android:textColor="#FFFFFF"  <!-- Change to new color -->
```

### Modify Section Headers Styling
Find section title TextViews (like "CONTROLS", "UTILITIES"):
```xml
android:textSize="@dimen/_9ssp"     <!-- Change font size -->
android:letterSpacing="0.1"          <!-- Adjust spacing -->
android:textColor="#7a8ebd"          <!-- Change color -->
```

### Adjust Gradient Angles
In gradient drawables:
```xml
<gradient
    android:angle="45"  <!-- 0=left-right, 45=diagonal, 90=top-bottom -->
```

## 📱 Orientation Handling

- **Landscape layout**: Fixed sidebar + dynamic content
- **Portrait layout**: Full-width scrollable content
- Breakpoints auto-handled by Android

To force only landscape:
In `AndroidManifest.xml`, find your activity:
```xml
<activity
    android:screenOrientation="landscape"
    ... />
```

## 🎯 Performance Tips

1. All drawables are **XML-based** (lightweight, no PNGs)
2. Use the **same drawable** for multiple components when possible
3. Avoid too many constraints for ViewGroup performance
4. ScrollView is optimized for smooth scrolling

## 🐛 Troubleshooting

### Buttons not showing correctly
- Check if drawable resources are in `res/drawable/`
- Verify XML syntax with `get_errors` tool
- Clear build cache: `Build > Clean Project`

### Colors look different on device
- Check device theme (Light/Dark)
- Verify color hex codes are correct
- Test on multiple devices/SDK levels

### Layout looks cramped
- Increase sidebar width: change `_260sdp` to `_300sdp`
- Adjust padding: change `@dimen/_16sdp` values
- Modify button heights

### Gradient not appearing
- Verify `angle` attribute is set
- Check `startColor`, `endColor` are valid hex
- Ensure file is in `drawable/`, not `drawable-land/`

## 📦 File Structure
```
app_pojavlauncher/
├── src/main/
│   ├── AndroidManifest.xml
│   ├── res/
│   │   ├── drawable/
│   │   │   ├── gradient_blue_cyan.xml
│   │   │   ├── gradient_cyan_green.xml
│   │   │   ├── badge_background.xml
│   │   │   ├── button_nav_background.xml
│   │   │   ├── card_background_dark.xml
│   │   │   ├── spinner_background.xml
│   │   │   ├── button_primary_gradient.xml
│   │   │   └── button_play_gradient.xml
│   │   ├── layout/
│   │   │   └── fragment_launcher.xml (portrait)
│   │   ├── layout-land/
│   │   │   └── fragment_launcher.xml (landscape)
│   │   └── values/
│   │       ├── colors_lunar_theme.xml
│   │       └── strings_ui_theme.xml
```

## 🚀 Next Steps

1. **Animations**: Add fade, slide animations to buttons
2. **Ripple Effects**: Add `?attr/selectableItemBackground` to buttons
3. **Dark Mode Toggle**: Create alternate color scheme
4. **Custom Fonts**: Add Google Fonts for typography
5. **Icon Set**: Replace placeholder icons with branded set

## 📞 Support

For layout issues, check:
- `UI_DESIGN_DOCUMENTATION.md` - Full design specs
- `colors_lunar_theme.xml` - All color definitions
- `strings_ui_theme.xml` - All text labels

---

**Last Updated**: May 8, 2026
**Design System**: Lunar Dark Mode + Cyan/Green Accents
**API Level**: 21+

