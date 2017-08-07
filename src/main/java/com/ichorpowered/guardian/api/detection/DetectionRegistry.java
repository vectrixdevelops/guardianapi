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

import java.util.NoSuchElementException;
import java.util.Set;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Represents a registry for detections.
 */
public interface DetectionRegistry extends Iterable<Detection> {

    /**
     * Inserts the {@link Detection} into this registry.
     *
     * @param pluginContainer the plugin that registered the detection
     * @param key the detection class
     * @param detection the detection
     * @param <C> the plugin container type
     */
    <C> void put(@Nonnull C pluginContainer, @Nonnull Class<? extends Detection> key,
             @Nonnull Detection detection);

    /**
     * Returns the {@link Detection} that is represented by its key.
     *
     * @param key the detection key
     * @param <E> the detection owner type
     * @param <F> the detection configuration type
     * @return the detection
     * @throws NoSuchElementException if the detection is not contained in this registry
     */
    @Nonnull
    <E, F> Detection<E, F> expect(@Nonnull Class<? extends Detection<E, F>> key)
            throws NoSuchElementException;

    /**
     * Returns the {@link Detection} that is represented by its key.
     *
     * @param key the detection key
     * @return the detection, or {@code null} if the detection is not contained in this registry
     */
    @Nullable
    Detection get(@Nonnull Class<? extends Detection> key);

    /**
     * Returns the key that represents its {@link Detection}.
     *
     * @param detection the detection
     * @return the detection key, or {@code null} if the detection is not contained in this registry
     */
    @Nullable
    Class<? extends Detection> key(@Nonnull Detection detection);

    /**
     * Returns a set of keys that are contained inside this registry.
     *
     * @return a set of detection keys
     */
    @Nonnull
    Set<Class<? extends Detection>> keySet();

}
