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
package com.ichorpowered.guardian.api.detection.check;

import com.ichorpowered.guardian.api.detection.DetectionConfiguration;

import java.util.NoSuchElementException;
import java.util.Set;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Represents a registry for checks.
 */
public interface CheckRegistry extends Iterable<Check> {

    /**
     * Inserts the {@link Check} into this registry.
     *
     * @param pluginContainer the plugin that registered the check
     * @param key the check class
     * @param check the check
     * @param <C> the plugin container type
     */
    <C> void put(@Nonnull C pluginContainer, @Nonnull Class<? extends Check> key,
                 @Nonnull Check check);

    /**
     * Returns the {@link Check} that is represented by its key.
     *
     * @param key the check key
     * @param <E> the check detections owner type
     * @param <F> the check detections configuration type
     * @return the check
     * @throws NoSuchElementException if the check is not contained in this registry
     */
    @Nonnull
    <E, F extends DetectionConfiguration> Check<E, F> expect(@Nonnull Class<? extends Check<E, F>> key) throws NoSuchElementException;

    /**
     * Returns the {@link Check} that is represented by its key.
     *
     * @param key the check key
     * @return the check, or {@code null} if the check is not contained inside this registry
     */
    @Nullable
    Check get(@Nonnull Class<? extends Check> key);

    /**
     * Returns the key that represents its {@link Check}.
     *
     * @param check the check
     * @return the check key, or {@code null} if the check is not contained inside this registry
     */
    @Nullable
    Class<? extends Check> key(@Nonnull Check check);

    /**
     * Returns a set of keys that are contained inside this registry.
     *
     * @return a set of check keys
     */
    @Nonnull
    Set<Class<? extends Check>> keySet();

}
