/*
 * MIT License
 *
 * Copyright (c) 2017 Connor Hartley
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.ichorpowered.guardian.api;

import static com.google.common.base.Preconditions.checkState;

import com.google.inject.Inject;
import com.ichorpowered.guardian.api.game.model.ModelFactories;
import com.ichorpowered.guardian.api.game.model.ModelRegistry;
import com.ichorpowered.guardian.api.game.resource.ResourceFactories;
import com.ichorpowered.guardian.api.storage.DefinitionConfiguration;
import com.ichorpowered.guardian.api.storage.GlobalConfiguration;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.config.DefaultConfig;

import java.nio.file.Path;

/**
 * A static access class, providing core systems that
 * have been initialized.
 */
public final class Guardian {

    @Inject @DefaultConfig(sharedRoot = false) private static Path configPath;
    @Inject private static GuardianPlatform platform;
    @Inject private static GlobalConfiguration globalConfiguration;
    @Inject private static DefinitionConfiguration definitionConfiguration;
    @Inject private static ModelRegistry modelRegistry;
    @Inject private static ModelFactories modelFactories;
    @Inject private static ResourceFactories resourceFactories;

    private static <T> @Nullable T check(@Nullable T instance) {
        checkState(instance != null, "Guardian has not been initialized!");
        return instance;
    }

    public static @Nullable Path getConfigPath() {
        return check(configPath);
    }

    /**
     * Returns the current implementation and game this
     * is currently running on.
     *
     * @return the current implementation and game
     */
    public static @Nullable GuardianPlatform getPlatform() {
        return check(platform);
    }

    /**
     * Returns the current implementations global configuration.
     *
     * @return the global configuration
     */
    public static @Nullable GlobalConfiguration getGlobalConfiguration() {
        return check(globalConfiguration);
    }

    public static @Nullable DefinitionConfiguration getDefinitionConfiguration() {
        return check(definitionConfiguration);
    }

    /**
     * Returns the {@link ModelRegistry} for registering containers
     * that represents physical game behaviours and properties.
     *
     * @return the model registry
     */
    public static @Nullable ModelRegistry getModelRegistry() {
        return check(modelRegistry);
    }

    /**
     * Returns the {@link ModelFactories} for creating containers
     * that represent physical game behaviours and properties.
     *
     * @return the model factories
     */
    public static @Nullable ModelFactories getModelFactories() {
        return check(modelFactories);
    }

    /**
     * Returns the {@link ResourceFactories} for creating containers
     * that represent frequently accessed game objects.
     *
     * @return the resource factories
     */
    public static @Nullable ResourceFactories getResourceFactories() {
        return check(resourceFactories);
    }

}
