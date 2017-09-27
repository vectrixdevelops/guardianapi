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
package com.ichorpowered.guardian.api.detection.penalty;

import java.util.Set;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Represents a registry for punishments.
 */
public interface PenaltyRegistry extends Iterable<Penalty> {

    /**
     * Inserts the {@link Penalty} into this registry.
     *
     * @param pluginContainer the plugin that registered the heuristic
     * @param key the penalty class
     * @param penalty the penalty
     * @param <C> the plugin container type
     */
    <C> void put(@Nonnull C pluginContainer, @Nonnull Class<? extends Penalty> key,
                 @Nonnull Penalty penalty);

    /**
     * Returns the {@link Penalty} that is represented by its key.
     *
     * @param key the penalty key
     * @return the penalty, or {@code null} if the penalty is not contained in this registry
     */
    @Nullable
    Penalty get(@Nonnull Class<? extends Penalty> key);

    /**
     * Returns the key that represents its {@link Penalty}.
     *
     * @param penalty the penalty
     * @return the penalty key, or {@code null} if the penalty is not contained in this registry
     */
    @Nullable
    Class<? extends Penalty> key(@Nonnull Penalty penalty);

    /**
     * Returns a set of keys that are contained inside this registry.
     *
     * @return a set of penalty keys
     */
    @Nonnull
    Set<Class<? extends Penalty>> keySet();

}
