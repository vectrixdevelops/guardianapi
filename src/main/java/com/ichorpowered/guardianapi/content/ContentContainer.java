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
package com.ichorpowered.guardianapi.content;

import com.google.common.collect.ImmutableMap;
import com.ichorpowered.guardianapi.content.key.ContentKey;
import com.ichorpowered.guardianapi.util.item.value.BaseValue;

import java.util.Optional;
import java.util.Set;

/**
 * Represents a container for content data.
 */
public interface ContentContainer extends Iterable<BaseValue<?>> {

    /**
     * Offers the content to be stored in this container under
     * the {@link ContentKey}.
     *
     * @param key the key
     * @param value the value
     * @param <E> the value type
     */
    <E extends BaseValue<?>> void offer(ContentKey<E> key, E value);

    /**
     * Attempts to offer the content to be stored in this
     * container under the {@link ContentKey}.
     *
     * @param key the key
     * @param value the value
     */
    void attempt(ContentKey key, BaseValue<?> value);

    /**
     * Returns a value for retrieving
     * the content that may be stored in this container under
     * the {@link ContentKey}.
     *
     * @param key the key
     * @param <E> the value type
     * @return the single value result
     */
    <E extends BaseValue<?>> Optional<E> get(ContentKey<E> key);

    /**
     * Returns the underlying map for this container.
     *
     * @return the underlying map
     */
    ImmutableMap<ContentKey<?>, ?> getMap();

    /**
     * Returns a set of keys that are stored in this
     * container.
     *
     * @return the set stored keys
     */
    Set<ContentKey<?>> getKeys();

    /**
     * Returns a set of values that are stored in this
     * container.
     *
     * @return the set of stored values
     */
    Set<?> getValues();

    /**
     * Returns a set of keys that may be stored in this
     * container, or offered to this container.
     *
     * @return the set of possible keys
     */
    Set<ContentKey<?>> getPossibleKeys();

    /**
     * Returns an {@link Optional} that may contain a
     * {@link ContentLoader} if present.
     *
     * @return a possible content loader
     */
    Optional<ContentLoader> getContentLoader();

}
