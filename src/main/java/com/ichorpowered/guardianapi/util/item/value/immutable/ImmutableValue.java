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
package com.ichorpowered.guardianapi.util.item.value.immutable;

import com.ichorpowered.guardianapi.util.item.value.BaseValue;

import java.util.function.Function;

/**
 * Represents a type of {@link BaseValue} that is immutable. Simply put, the
 * underlying value cannot be changed without creating a new {@link ImmutableValue}.
 *
 * @param <E> the type of type
 * @author SpongePowered
 */
public interface ImmutableValue<E> extends BaseValue<E> {

    /**
     * Creates a new {@link ImmutableValue} with the given <code>E</code> typed
     * value.
     *
     * @param value The value to replace
     * @return a new value container
     */
    ImmutableValue<E> with(E value);

    /**
     * Retrieves the underlying value for this {@link ImmutableValue} and
     * applies the given {@link Function} onto that value, after which, the
     * product is sent to a new {@link ImmutableValue} replacing this one.
     *
     * @param function The function to apply onto the existing value
     * @return a new value container
     */
    ImmutableValue<E> transform(Function<E, E> function);
}
