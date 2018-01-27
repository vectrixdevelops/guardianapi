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

import java.util.List;

/**
 * A type of {@link ImmutableCollectionValue} that is backed by a {@link List}.
 * All "with" and "Without" methods are returning new instances as every
 * instance is immutable.
 *
 * @param <E> the type of type of this list value
 * @author SpongePowered
 */
public interface ImmutableListValue<E> extends ImmutableCollectionValue<E, List<E>, ImmutableListValue<E>> {

    /**
     * Gets the desired type at the desired index.
     *
     * @param index the index of the type to return
     * @return the type at the desired index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    E get(int index);

    /**
     * Creates a new {@link ImmutableListValue} with the specified type
     * at the specified position in the list. As well, the type at the
     * provided index is shifted to the right,  increasing its and the elements
     * thereafter their indices by one.
     *
     * @param index the index to add the provided type at
     * @param value the type to add
     * @return the new value, for chaining
     */
    ImmutableListValue<E> with(int index, E value);

    /**
     * Creates a new {@link ImmutableListValue} with the specified elements
     * in the order that they are iterated to the list at the specified index.
     * The type at the provided index and elements thereafter are shifted to
     * the right, increasing their indices by one.
     *
     * @param index the index to add the elements at
     * @param values the elements to add
     * @return the new value, for chaining
     */
    ImmutableListValue<E> with(int index, Iterable<E> values);

    /**
     * Creates a new {@link ImmutableListValue} without the type at the
     * specified index. Shifts any subsequent elements to the left, subtracts
     * one from their indices.
     *
     * @param index the index of the type to exclude
     * @return the new value, for chaining
     */
    ImmutableListValue<E> without(int index);

    /**
     * Creates a new {@link ImmutableListValue} with the desired type at
     * the desired index.
     *
     * @param index the index to replace the type
     * @param element the type to include at the index
     * @return the new value, for chaining
     */
    ImmutableListValue<E> set(int index, E element);

    /**
     * Queries for the index of the provided type. If the type is
     * not contained in this list, -1 is returned.
     *
     * @param element the type to get the index from
     * @return the index of the type, -1 if not available
     */
    int indexOf(E element);
}
