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
package com.ichorpowered.guardian.api.phase;

import com.ichorpowered.guardian.api.util.key.NamedTypeKey;

import java.util.Set;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public interface PhaseRegistry {

    /**
     * Inserts the {@link PhaseViewer} into the registry.
     *
     * @param pluginContainer the plugin that registered the phase viewer
     * @param key the phase viewer key
     * @param phaseViewer the phase viewer
     * @param <C> the plugin container type
     * @param <T> the phase viewer key type
     */
    <C, T> void put(@Nonnull C pluginContainer, @Nonnull NamedTypeKey<T> key,
                    @Nonnull PhaseViewer<T> phaseViewer);

    /**
     * Retruns the {@link PhaseViewer} that is represented by its key.
     *
     * @param key the phase viewer key
     * @param <T> the phase viewer key type
     * @return the phase viewer
     */
    @Nonnull
    <T> PhaseViewer<T> expect(@Nonnull NamedTypeKey<T> key);

    /**
     * Returns the {@link PhaseViewer} that is represented by its key.
     *
     * @param key the phase viewer key
     * @return the phase viewer
     */
    @Nullable
    PhaseViewer get(@Nonnull NamedTypeKey key);

    /**
     * Returns the key that represents its {@link PhaseViewer}.
     *
     * @param phaseViewer the phase viewer
     * @return the phase viewer key
     */
    @Nullable
    NamedTypeKey key(@Nonnull PhaseViewer phaseViewer);

    /**
     * Returns a set of keys that are contained inside this registry.
     *
     * @return a set of phase viewer keys
     */
    @Nonnull
    Set<NamedTypeKey> keySet();

}
