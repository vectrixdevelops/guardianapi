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
package com.ichorpowered.guardianapi.util.item.value;

import com.ichorpowered.guardianapi.util.item.key.Key;

import java.util.Optional;

/**
 * Represents a value associated with a {@link Key}.
 *
 * @param <E> the value type
 * @author SpongePowered
 */
public interface BaseValue<E> {

    /**
     * Returns the contained value. If that value is not
     * present, the {@link #getDefault()} value is returned.
     *
     * @return the contained value
     */
    E get();

    /**
     * Returns true if the value is presumed to exist.
     *
     * @return true if the value is contained
     */
    boolean exists();

    /**
     * Returns true if the value is immutable.
     *
     * @return true if the value is immutable
     */
    boolean isImmutable();

    /**
     * Returns the default value.
     *
     * @return the default value
     */
    E getDefault();

    /**
     * Returns the directly contained value. If that value is not
     * present, it will return an {@link Optional#empty()}.
     *
     * @return the directly contained value
     */
    Optional<E> getDirect();

    /**
     * Returns the key associated with this {@link BaseValue}.
     *
     * @return the associated key
     */
    Key<? extends BaseValue<E>> getKey();

}
