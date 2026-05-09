package net.kdt.pojavlaunch.fragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import net.kdt.pojavlaunch.Tools;
import net.kdt.pojavlaunch.contracts.OpenDocumentWithExtension;
import net.kdt.pojavlaunch.skins.SkinPreviewView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import git.cryonix.launcher.R;

public class SkinManagerFragment extends Fragment {
    public static final String TAG = "SkinManagerFragment";
    private SkinPreviewView mSkinPreviewView;

    private final ActivityResultLauncher<Object> mSkinPicker =
            registerForActivityResult(new OpenDocumentWithExtension("png"), this::importSkin);

    public SkinManagerFragment() {
        super(R.layout.fragment_skin_manager);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mSkinPreviewView = view.findViewById(R.id.skin_preview);
        Button importButton = view.findViewById(R.id.skin_import_button);
        importButton.setOnClickListener(v -> mSkinPicker.launch(null));
        loadSavedSkin();
    }

    private File getSkinFile() {
        return new File(Tools.DIR_DATA, "cryonix_skin.png");
    }

    private void loadSavedSkin() {
        File skinFile = getSkinFile();
        if(!skinFile.isFile()) return;
        Bitmap bitmap = BitmapFactory.decodeFile(skinFile.getAbsolutePath());
        if(bitmap != null) mSkinPreviewView.setSkinBitmap(bitmap);
    }

    private void importSkin(Uri uri) {
        if(uri == null) return;
        try(InputStream inputStream = requireContext().getContentResolver().openInputStream(uri)) {
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            if(bitmap == null) throw new IOException("Invalid PNG");
            File skinFile = getSkinFile();
            try(FileOutputStream outputStream = new FileOutputStream(skinFile)) {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
            }
            mSkinPreviewView.setSkinBitmap(bitmap);
            Toast.makeText(requireContext(), R.string.skin_manager_saved, Toast.LENGTH_SHORT).show();
        }catch (IOException e) {
            Tools.showError(requireContext(), e);
            Toast.makeText(requireContext(), R.string.skin_manager_failed, Toast.LENGTH_LONG).show();
        }
    }
}
