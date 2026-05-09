package net.kdt.pojavlaunch.prefs.screens;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.preference.PreferenceCategory;

import git.cryonix.launcher.R;
import net.kdt.pojavlaunch.Tools;
import net.kdt.pojavlaunch.contracts.OpenDocumentWithExtension;
import net.kdt.pojavlaunch.prefs.CustomSeekBarPreference;
import net.kdt.pojavlaunch.prefs.LauncherPreferences;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class LauncherPreferenceControlFragment extends LauncherPreferenceFragment {
    private boolean mGyroAvailable = false;
    private final ActivityResultLauncher<Object> mMousePicker =
            registerForActivityResult(new OpenDocumentWithExtension("png"), this::importMouseCursor);

    @Override
    public void onCreatePreferences(Bundle b, String str) {
        // Get values
        int longPressTrigger = LauncherPreferences.PREF_LONGPRESS_TRIGGER;
        int prefButtonSize = (int) LauncherPreferences.PREF_BUTTONSIZE;
        int mouseScale = (int) (LauncherPreferences.PREF_MOUSESCALE * 100);
        int gyroSampleRate = LauncherPreferences.PREF_GYRO_SAMPLE_RATE;
        float mouseSpeed = LauncherPreferences.PREF_MOUSESPEED;
        float gyroSpeed = LauncherPreferences.PREF_GYRO_SENSITIVITY;
        float joystickDeadzone = LauncherPreferences.PREF_DEADZONE_SCALE;


        //Triggers a write for some reason which resets the value
        addPreferencesFromResource(R.xml.pref_control);

        CustomSeekBarPreference seek2 = requirePreference("timeLongPressTrigger",
                CustomSeekBarPreference.class);
        seek2.setValue(longPressTrigger);
        seek2.setSuffix(" ms");

        CustomSeekBarPreference seek3 = requirePreference("buttonscale",
                CustomSeekBarPreference.class);
        seek3.setValue(prefButtonSize);
        seek3.setSuffix(" %");

        CustomSeekBarPreference seek4 = requirePreference("mousescale",
                CustomSeekBarPreference.class);
        seek4.setValue(mouseScale);
        seek4.setSuffix(" %");

        CustomSeekBarPreference seek6 = requirePreference("mousespeed",
                CustomSeekBarPreference.class);
        seek6.setValue((int)(mouseSpeed *100f));
        seek6.setSuffix(" %");

        CustomSeekBarPreference deadzoneSeek = requirePreference("gamepad_deadzone_scale",
                CustomSeekBarPreference.class);
        deadzoneSeek.setValue((int) (joystickDeadzone * 100f));
        deadzoneSeek.setSuffix(" %");


        Context context = getContext();
        if(context != null) {
            mGyroAvailable = Tools.deviceSupportsGyro(context);
        }
        PreferenceCategory gyroCategory =  requirePreference("gyroCategory",
                PreferenceCategory.class);
        gyroCategory.setVisible(mGyroAvailable);
        requirePreference("custom_mouse_picker").setOnPreferenceClickListener(preference -> {
            mMousePicker.launch(null);
            return true;
        });
        requirePreference("custom_mouse_reset").setOnPreferenceClickListener(preference -> {
            File cursorFile = getCustomCursorFile();
            if(cursorFile.isFile()) cursorFile.delete();
            LauncherPreferences.DEFAULT_PREF.edit().putString("customMousePath", "").apply();
            LauncherPreferences.PREF_CUSTOM_MOUSE_PATH = "";
            return true;
        });

        CustomSeekBarPreference gyroSensitivitySeek = requirePreference("gyroSensitivity",
                CustomSeekBarPreference.class);
        gyroSensitivitySeek.setValue((int) (gyroSpeed*100f));
        gyroSensitivitySeek.setSuffix(" %");

        CustomSeekBarPreference gyroSampleRateSeek = requirePreference("gyroSampleRate",
                CustomSeekBarPreference.class);
        gyroSampleRateSeek.setValue(gyroSampleRate);
        gyroSampleRateSeek.setSuffix(" ms");
        computeVisibility();
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences p, String s) {
        super.onSharedPreferenceChanged(p, s);
        computeVisibility();
    }

    private void computeVisibility(){
        requirePreference("timeLongPressTrigger").setVisible(!LauncherPreferences.PREF_DISABLE_GESTURES);
        requirePreference("gyroSensitivity").setVisible(LauncherPreferences.PREF_ENABLE_GYRO);
        requirePreference("gyroSampleRate").setVisible(LauncherPreferences.PREF_ENABLE_GYRO);
        requirePreference("gyroInvertX").setVisible(LauncherPreferences.PREF_ENABLE_GYRO);
        requirePreference("gyroInvertY").setVisible(LauncherPreferences.PREF_ENABLE_GYRO);
        requirePreference("gyroSmoothing").setVisible(LauncherPreferences.PREF_ENABLE_GYRO);
    }

    private File getCustomCursorFile() {
        return new File(Tools.DIR_DATA, "custom_mouse_cursor.png");
    }

    private void importMouseCursor(Uri uri) {
        if(uri == null) return;
        File targetFile = getCustomCursorFile();
        try(InputStream inputStream = requireContext().getContentResolver().openInputStream(uri);
            FileOutputStream outputStream = new FileOutputStream(targetFile)) {
            if(inputStream == null) throw new IOException("Cannot open cursor image");
            byte[] buffer = new byte[8192];
            int read;
            while((read = inputStream.read(buffer)) != -1) outputStream.write(buffer, 0, read);
            LauncherPreferences.DEFAULT_PREF.edit().putString("customMousePath", targetFile.getAbsolutePath()).apply();
            LauncherPreferences.PREF_CUSTOM_MOUSE_PATH = targetFile.getAbsolutePath();
            Toast.makeText(requireContext(), R.string.preference_custom_mouse_title, Toast.LENGTH_SHORT).show();
        }catch (IOException e) {
            Tools.showError(requireContext(), e);
        }
    }

}
