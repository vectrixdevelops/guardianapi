/*
 * MIT License
 *
 * Copyright (c) 2018 Connor Hartley
 * Copyright (c) 2018 SpongePowered
 * Copyright (c) 2018 contributors
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

import com.ichorpowered.guardianapi.util.item.value.BaseValue;

import java.util.Optional;
import java.util.Set;

import javax.annotation.Nonnull;

/**
 * Represents the capture container for storing
 * relevant data from the captures.
 */
public interface CaptureContainer {

    /**
     * Inserts the {@link Capture} into this registry,
     * if it doesn't exist already.
     *
     * @param item the capture item
     * @param <E> the capture element type
     * @param <V> the capture value type
     */
    <E, V extends BaseValue<E>> void offerIfEmpty(@Nonnull V item);

    /**
     * Inserts the {@link Capture} into this registry.
     *
     * @param item the capture item
     * @param <E> the capture element type
     * @param <V> the capture value type
     */
    <E, V extends BaseValue<E>> void offer(@Nonnull V item);

    /**
     * Merges values from another {@link CaptureContainer} into this.
     *
     * @param captureContainer another capture container
     * @return this capture container
     */
    @Nonnull
    CaptureContainer merge(@Nonnull CaptureContainer captureContainer);

    /**
     * Returns the {@link Capture} element that is represented by its key.
     *
     * @param key the capture key
     * @param <E> the capture element type
     * @param <V> the capture value type
     * @return the capture element optional, or {@link Optional#empty()} if the capture element is not contained in this registry
     */
    <E, V extends BaseValue<E>> Optional<E> get(@Nonnull CaptureKey<V> key);

    /**
     * Returns the {@link Capture} that is represented by its {@link CaptureKey}.
     *
     * @param key the capture key
     * @param <E> the capture element type
     * @param <V> the capture value type
     * @return the capture value optional, or {@link Optional#empty()} if the capture is not contained in this registry
     */
    @Nonnull
    <E, V extends BaseValue<E>> Optional<V> getValue(@Nonnull CaptureKey<V> key);

    /**
     * Returns a set of keys that are contained inside this registry.
     *
     * @return a set of capture keys
     */
    @Nonnull
    Set<String> keySet();

}
