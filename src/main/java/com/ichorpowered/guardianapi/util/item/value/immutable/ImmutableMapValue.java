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

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableSet;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Represents a specialized type of {@link ImmutableValue} as the "elements" are
 * {@link Map.Entry}. Usually, this type of value is used to represent
 * a particular "type" of "key" that is associated to a particular "value".
 *
 * @param <K> the type of the key
 * @param <V> the type of the value
 * @author SpongePowered
 */
public interface ImmutableMapValue<K, V> extends ImmutableValue<Map<K, V>> {

    /**
     * Gets the size of this map.
     *
     * @return the size of this map
     */
    int size();

    /**
     * Associates the provided key to the provided value in the new map. If
     * there already exists a value for the provided key, the value is
     * replaced.
     *
     * @param key the key to associate to the value
     * @param value the value associated with the key
     * @return the new value, for chaining
     */
    ImmutableMapValue<K, V> with(K key, V value);

    @Override
    ImmutableMapValue<K, V> with(Map<K, V> value);

    /**
     * Associates all provided {@link Map.Entry} along with all pre-existing
     * map entries in a new {@link ImmutableMapValue}.
     *
     * @param map the map of key values to set
     * @return the new value, for chaining
     */
    ImmutableMapValue<K, V> withAll(Map<K, V> map);

    /**
     * Creates a new {@link ImmutableMapValue} without the provided key and the
     * associated value.
     *
     * @param key the key to exclude the association
     * @return the new value, for chaining
     */
    ImmutableMapValue<K, V> without(K key);

    /**
     * Creates a new {@link ImmutableMapValue} without the provided keys and
     * their associated values.
     *
     * @param keys the keys to exclude
     * @return the new value, for chaining
     */
    ImmutableMapValue<K, V> withoutAll(Iterable<K> keys);

    /**
     * Creates a new {@link ImmutableMapValue} such that all entries are
     * filtered by the provided {@link Predicate}, any that return
     * {@code true} are retained in the new value. Elements that return
     * <code>true</code> from {@link Predicate#test(Object)} are kept, and
     * those that return <code>false</code> are excluded.
     *
     * @param predicate the predicate to filter
     * @return the new value, for chaining
     */
    ImmutableMapValue<K, V> withoutAll(Predicate<Map.Entry<K, V>> predicate);

    /**
     * Checks if the provided key is contained within this map.
     *
     * @param key the key to check
     * @return true if the key is contained
     */
    boolean containsKey(K key);

    /**
     * Checks if the provided value is contained within this map.
     *
     * @param value the value to check
     * @return true if the value is contained
     */
    boolean containsValue(V value);

    /**
     * Gets an {@link ImmutableSet} of all keys contained in this map value.
     *
     * @return the set of keys
     */
    ImmutableSet<K> keySet();

    /**
     * Retrieves an {@link ImmutableSet} of the {@link Map.Entry}s contained
     * within this map value.
     *
     * @return the immutable set of entries
     */
    ImmutableSet<Map.Entry<K, V>> entrySet();

    /**
     * Retrieves an {@link ImmutableCollection} of all available values within
     * this map.
     *
     * @return the collection of values
     */
    ImmutableCollection<V> values();

    @Override
    ImmutableMapValue<K, V> transform(Function<Map<K, V>, Map<K, V>> function);
}
