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
package com.ichorpowered.guardian.api.sequence;

import java.util.NoSuchElementException;
import java.util.Set;

import javax.annotation.Nonnull;

/**
 * Represents a registry for sequences.
 */
public interface SequenceRegistry extends Iterable<SequenceBlueprint> {

    /**
     * Inserts the {@link SequenceBlueprint} into this registry.
     *
     * @param pluginContainer the plugin that registered the blueprint
     * @param key the blueprint class
     * @param sequenceBlueprint the blueprint
     * @param <C> the plugin container type
     */
    <C> void put(@Nonnull C pluginContainer, @Nonnull Class<? extends SequenceBlueprint> key,
                 @Nonnull SequenceBlueprint sequenceBlueprint);

    /**
     * Returns the {@link SequenceBlueprint} that is represented by its key.
     *
     * @param key the blueprint key
     * @param <E> the check detections owner type
     * @param <F> the check detections configuration type
     * @return the blueprint
     * @throws NoSuchElementException if the blueprint is not contained in this registry
     */
    <E, F> SequenceBlueprint<E, F> expect(@Nonnull Class<? extends SequenceBlueprint> key) throws NoSuchElementException;

    /**
     * Returns the {@link SequenceBlueprint} that is represented by its key.
     *
     * @param key the blueprint key
     * @return the blueprint, or {@code null} if the blueprint is not contained in this registry
     */
    SequenceBlueprint get(@Nonnull Class<? extends SequenceBlueprint> key);

    /**
     * Returns the key that represents its {@link SequenceBlueprint}.
     *
     * @param sequenceBlueprint the blueprint
     * @return the blueprint key, or {@code null} if they check is not contained in this registry
     */
    Class<? extends SequenceBlueprint> key(@Nonnull SequenceBlueprint sequenceBlueprint);

    /**
     * Returns a set of keys that are contained inside this registry.
     *
     * @return a set of blueprint keys
     */
    Set<Class<? extends SequenceBlueprint>> keySet();

}
