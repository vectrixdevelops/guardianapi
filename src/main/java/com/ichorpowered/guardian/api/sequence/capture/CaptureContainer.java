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
package com.ichorpowered.guardian.api.sequence.capture;

import com.ichorpowered.guardian.api.util.IdentifierKey;
import com.ichorpowered.guardian.api.util.Transform;

import java.util.Set;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Represents the capture container for storing
 * relevant data from the captures.
 */
public interface CaptureContainer {

    /**
     * Inserts the {@link Capture} into this registry.
     *
     * <p>The capture key must be a unique key and is
     * recommended to use the class name and a custom
     * name.</p>
     *
     * @param key the capture key
     * @param value the capture value
     * @param <T> the capture value type
     */
    <T> void put(@Nonnull String key, @Nullable T value);

    /**
     * Inserts the {@link Capture} into this registry.
     *
     * @param key the capture key
     * @param value the capture value
     * @param <T> the capture value type
     */
    <T> void put(@Nonnull IdentifierKey<String> key, @Nonnull T value);

    /**
     * Transforms the {@link Capture} in this registry.
     *
     * <p>The capture key must be a unique key and is
     * recommended to use the class name and a custom
     * name.</p>
     *
     * @param key the capture key
     * @param transform the capture transformer
     * @param <T> the capture value type
     */
    <T> void transform(@Nonnull String key, @Nullable Transform<T> transform);

    /**
     * Transforms the {@link Capture} in this registry.
     *
     * @param key the capture key
     * @param transform the capture transformer
     * @param <T> the capture value
     */
    <T> void transform(@Nonnull IdentifierKey<String> key, @Nonnull Transform<T> transform);

    /**
     * Returns the {@link Capture} that is represented by its key.
     *
     * @param key the capture key
     * @param <T> the capture value type
     * @return the capture value, or {@code null} if the capture is not contained in this registry
     */
    @Nullable
    <T> T get(@Nonnull String key);

    /**
     * Returns the {@link Capture} that is represented by its {@link IdentifierKey}.
     *
     * @param key the capture key
     * @param <T> the capture value type
     * @return the capture value, or {@code null} if the capture is not contained in this registry
     */
    @Nullable
    <T> T get(@Nonnull IdentifierKey<String> key);

    /**
     * Returns the key that represents its {@link Capture}.
     *
     * @param value the capture value
     * @param <T> the capture value type
     * @return the capture key, or {@code null} if the capture is not contained in this registry
     */
    @Nullable
    <T> String key(T value);

    /**
     * Returns a set of keys that are contained inside this registry.
     *
     * @return a set of capture keys
     */
    Set<String> keySet();

}
