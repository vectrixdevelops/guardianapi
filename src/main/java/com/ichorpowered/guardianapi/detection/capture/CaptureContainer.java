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
package com.ichorpowered.guardianapi.detection.capture;

import com.ichorpowered.guardianapi.util.Transform;
import com.ichorpowered.guardianapi.util.key.NamedKey;
import com.ichorpowered.guardianapi.util.key.NamedTypeKey;

import java.util.Optional;
import java.util.Set;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Represents the capture container for storing
 * relevant data from the captures.
 */
public interface CaptureContainer {

    /**
     * Inserts the {@link Capture} into this registry,
     * if it doesn't exist already.
     *
     * <p>The capture key must be a unique key and is
     * recommended to use the class name and a custom
     * name.</p>
     *
     * @param key the capture key
     * @param value the capture value
     * @param <T> the capture value type
     */
    <T> void putOnce(@Nonnull String key, @Nullable T value);

    /**
     * Inserts the {@link Capture} into this registry,
     * if it doesn't exist already.
     *
     * @param key the capture key
     * @param value the capture value
     * @param <T> the capture value type
     */
    <T> void putOnce(@Nonnull NamedTypeKey<T> key, @Nullable T value);

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
    <T> void put(@Nonnull NamedTypeKey<T> key, @Nonnull T value);

    /**
     * Merges values from another {@link CaptureContainer} into this.
     *
     * @param captureContainer another capture container
     * @return this capture container
     */
    @Nonnull
    CaptureContainer merge(@Nonnull CaptureContainer captureContainer);

    /**
     * Transforms the {@link Capture} in this registry.
     *
     * <p>The capture key must be a unique key and is
     * recommended to use the class name and a custom
     * name.</p>
     *
     * @param key the capture key
     * @param transform the capture transformer
     * @param defaultValue the default value in case the original value does not exist
     * @param <T> the capture value type
     */
    <T> void transform(@Nonnull String key, @Nullable Transform<T> transform, @Nonnull T defaultValue);

    /**
     * Transforms the {@link Capture} in this registry.
     *
     * @param key the capture key
     * @param transform the capture transformer
     * @param defaultValue the default value in case the original value does not exist
     * @param <T> the capture value
     */
    <T> void transform(@Nonnull NamedTypeKey<T> key, @Nonnull Transform<T> transform, @Nonnull T defaultValue);

    /**
     * Returns the {@link Capture} that is represented by its key.
     *
     * @param key the capture key
     * @param <T> the capture value type
     * @return the capture value optional, or {@link Optional#empty()} if the capture is not contained in this registry
     */
    @Nonnull
    <T> Optional<T> get(@Nonnull String key);

    /**
     * Returns the {@link Capture} that is represented by its {@link NamedKey}.
     *
     * @param key the capture key
     * @param <T> the capture value type
     * @return the capture value optional, or {@link Optional#empty()} if the capture is not contained in this registry
     */
    @Nonnull
    <T> Optional<T> get(@Nonnull NamedTypeKey<T> key);

    /**
     * Returns a set of keys that are contained inside this registry.
     *
     * @return a set of capture keys
     */
    @Nonnull
    Set<String> keySet();

}
