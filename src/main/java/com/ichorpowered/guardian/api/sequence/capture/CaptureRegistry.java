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

import java.util.NoSuchElementException;
import java.util.Set;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Represents a registry for captures for a specific
 * player.
 *
 * @param <P> the player type
 */
public interface CaptureRegistry<P> {

    /**
     * Inserts the {@link Capture} into this registry.
     *
     * <p>The capture key must be a unique key and is
     * recommended to use the class name and a custom
     * name.</p>
     *
     * @param pluginContainer the plugin container
     * @param key the capture class
     * @param capture the capture
     * @param <C> the plugin container type
     */
    <C> void put(@Nonnull C pluginContainer, @Nonnull Class<? extends Capture> key,
                                    @Nullable Capture capture);

    /**
     * Returns the {@link Capture} that is represented by its key.
     *
     * @param key the capture key
     * @param <E> the check detection owner type
     * @param <F> the check detection configuration type
     * @return the capture
     * @throws NoSuchElementException if the capture is not contained in this registry
     * @throws IllegalArgumentException if the specific arguments are not of the correct type
     */
    @Nonnull
    <E, F> Capture<E, F, P> expect(@Nonnull Class<? extends Capture<E, F, P>> key)
        throws NoSuchElementException, IllegalArgumentException;

    /**
     * Returns the {@link Capture} that is represented by its key.
     *
     * @param key the capture key
     * @return the capture, or {@code null} if the capture is not contained in this registry
     */
    @Nullable
    Capture get(@Nonnull Class<? extends Capture> key);

    /**
     * Returns the key that represents its {@link Capture}.
     *
     * @param capture the capture
     * @return the capture key, or {@code null} if the capture is not contained in this registry
     */
    @Nullable
    Class<? extends Capture> key(@Nonnull Capture capture);

    /**
     * Returns a set of keys that are contained inside this registry.
     *
     * @return a set of capture keys
     */
    Set<String> keySet();

    /**
     * Returns the player that this registry is used by.
     *
     * @return the player
     */
    P getPlayer();

    /**
     * Returns the {@link CaptureContainer} that contains
     * data collected by the registered {@link Capture}s.
     *
     * @return the data by these registered captures
     */
    CaptureContainer getContainer();

}
