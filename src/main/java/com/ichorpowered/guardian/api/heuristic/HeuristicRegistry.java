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
package com.ichorpowered.guardian.api.heuristic;

import java.util.Set;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Represents a registry for heuristics.
 */
public interface HeuristicRegistry extends Iterable<Heuristic> {

    /**
     * Inserts the {@link Heuristic} into this registry.
     *
     * @param pluginContainer the plugin that registered the heuristic
     * @param key the heuristic class
     * @param heuristic the heuristic
     * @param <C> the plugin container type
     */
    <C> void put(@Nonnull C pluginContainer, @Nonnull Class<? extends Heuristic> key,
             @Nonnull Heuristic heuristic);

    /**
     * Returns the {@link Heuristic} that is represented by its key.
     *
     * @param key the heuristic key
     * @return the heuristic, or {@code null} if the heuristic is not contained in this registry
     */
    @Nullable
    Heuristic get(@Nonnull Class<? extends Heuristic> key);

    /**
     * Returns the key that represents its {@link Heuristic}.
     *
     * @param heuristic the heuristic
     * @return the heuristic key, or {@code null} if the heuristic is not contained in this registry
     */
    @Nullable
    Class<? extends Heuristic> key(@Nonnull Heuristic heuristic);

    /**
     * Returns a set of keys that are contained inside this registry.
     *
     * @return a set of heuristic keys
     */
    @Nonnull
    Set<Class<? extends Heuristic>> keySet();

}
