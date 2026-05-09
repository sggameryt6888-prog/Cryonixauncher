package net.kdt.pojavlaunch.modloaders.modpacks.models;

import org.jetbrains.annotations.Nullable;

/**
 * Search filters, passed to APIs
 */
public class SearchFilters {
    public static final String TYPE_MODPACK = "modpack";
    public static final String TYPE_MOD = "mod";
    public static final String TYPE_RESOURCEPACK = "resourcepack";
    public static final String TYPE_SHADER = "shader";

    public boolean isModpack;
    public String projectType = TYPE_MODPACK;
    public String name;
    @Nullable public String mcVersion;

    public void setProjectType(String projectType) {
        this.projectType = projectType;
        this.isModpack = TYPE_MODPACK.equals(projectType);
    }
}
