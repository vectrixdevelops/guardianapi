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
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.ichorpowered.guardian.api.detection;

import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import tech.ferus.util.config.ConfigFile;

import java.nio.file.Path;

import javax.annotation.Nonnull;

/**
 * Represents a configuration for a {@link Detection}
 * that contains settings to modify properties used
 * in the {@link DetectionChain}.
 */
public interface DetectionConfiguration {

    /**
     * Loads the configuration from disk into
     * memory.
     */
    void load();

    /**
     * Returns the {@link ConfigFile} that was
     * loaded from disk in memory.
     *
     * @return the configuration
     */
    @Nonnull
    ConfigFile<CommentedConfigurationNode> getStorage();

    /**
     * Returns the location on disk to where
     * the configuration is located.
     *
     * @return the config location on disk
     */
    @Nonnull
    Path getLocation();

}
