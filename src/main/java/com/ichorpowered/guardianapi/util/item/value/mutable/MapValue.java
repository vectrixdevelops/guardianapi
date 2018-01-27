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

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableSet;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;


/**
 * Represents a specialized type of {@link Value}, as the "elements" are
 * {@link Map.Entry}s. Usually, this type of value is used to represent
 * a particular "type" of "key" that is associated to a particular "value".
 *
 * @param <K> the type of the key
 * @param <V> the type of the value
 * @author SpongePowered
 */
public interface MapValue<K, V> extends Value<Map<K, V>> {

    /**
     * Gets the size of this map.
     *
     * @return the size of this map
     */
    int size();

    /**
     * Associates the provided key to the provided value. If there already
     * exists a value for the provided key, the value is replaced.
     *
     * @param key the key to associate to the value
     * @param value the value associated with the key
     * @return this map value, for chaining
     */
    MapValue<K, V> put(K key, V value);

    /**
     * Associates all provided {@link Map.Entry} to this map value.
     *
     * @param map the map of key values to set
     * @return this map value, for chaining
     */
    MapValue<K, V> putAll(Map<K, V> map);

    /**
     * Removes the association of the provided key to the value currently
     * associated.
     *
     * @param key the key to remove
     * @return this map value, for chaining
     */
    MapValue<K, V> remove(K key);

    /**
     * Removes all key value associations of the provided keys.
     *
     * @param keys the keys to remove
     * @return this map value, for chaining
     */
    MapValue<K, V> removeAll(Iterable<K> keys);

    /**
     * Applies the {@link Predicate} to all {@link Map.Entry} within this
     * {@link MapValue}. Any entries that are false will be removed from the
     * map value.
     *
     * @param predicate the predicate to filer
     * @return this map value, for chaining
     */
    MapValue<K, V> removeAll(Predicate<Map.Entry<K, V>> predicate);

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
    MapValue<K, V> transform(Function<Map<K, V>, Map<K, V>> function);
}
