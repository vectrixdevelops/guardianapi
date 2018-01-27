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
package com.ichorpowered.guardianapi.util.item.value.mutable;

import java.util.Collection;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Represents a {@link Value} that is backed by a {@link Collection} of
 * elements.
 *
 * @param <E> The type of type
 * @param <C> The type of collection, for chaining
 * @param <V> The type of {@linkplain CollectionValue}
 */
public interface CollectionValue<E, C extends Collection<E>, V extends CollectionValue<E, C, V>>
        extends Value<C>, Iterable<E> {

    @Override
    V set(C value);

    @Override
    V transform(Function<C, C> function);

    /**
     * Gets the size of the underlying collection of elements.
     *
     * @return The size
     */
    int size();

    /**
     * Checks if the backed {@link Collection} is empty.
     *
     * @see Collection#isEmpty()
     * @return True if the collection is empty
     */
    boolean isEmpty();

    /**
     * Adds the given {@code type} to this {@link CollectionValue}.
     *
     * @param element The type to add
     * @return This value, for chaining
     */
    V add(E element);

    /**
     * Adds all the given {@link Iterable} {@code elements} to the underlying
     * {@link Collection}.
     *
     * @see Collection#addAll(Collection)
     *
     * @param elements The elements to add
     * @return This value, for chaining
     */
    V addAll(Iterable<E> elements);

    /**
     * Removes the given {@code type} from the backed {@link Collection}.
     *
     * @param element The type to remove
     * @return This value, for chaining
     */
    V remove(E element);

    /**
     * Removes all elements from the {@link Iterable} from the backed
     * {@link Collection}.
     *
     * @param elements The elements to remove
     * @return This value, for chaining
     */
    V removeAll(Iterable<E> elements);

    /**
     * Iterates over all existing elements and removes any elements that
     * {@link Predicate#test(Object)} returns {@code true}.
     *
     * @param predicate The predicate to remove elements
     * @return This value, for chaining
     */
    V removeAll(Predicate<E> predicate);

    /**
     * Checks if the given <code>E</code> type is contained within the backed
     * {@link Collection}.
     *
     * @param element The type to check
     * @return True if the type is contained in this collection
     */
    boolean contains(E element);

    /**
     * Checks if all of the given {@link Iterable} elements are contained
     * within the backed {@link Collection}.
     *
     * @param iterable The iterable elements
     * @return True if all elements are contained in this value
     */
    boolean containsAll(Collection<E> iterable);

    /**
     * Applies a {@link Predicate} to filter the underlying elements in the
     * backed {@link Collection} to create a new {@link CollectionValue}
     * separate from this {@link CollectionValue}. This value is not modified,
     * nor is the underlying {@link Collection}. Elements that return
     * <code>true</code> from {@link Predicate#test(Object)} are kept, and
     * those that return <code>false</code> are excluded.
     *
     * @param predicate The predicate to filter
     * @return This value, for chaining
     */
    V filter(Predicate<? super E> predicate);

    /**
     * Creates a new {@link Collection} of the proper type <code>C</code> with
     * all elements copied to the new collection. Any modifications to the new
     * collection are not reflected to this {@link CollectionValue}. Likewise,
     * no modifications to this {@link CollectionValue} are reflected to the
     * returned {@link Collection}.
     *
     * @return A new collection with all elements copied
     */
    C getAll();
}
