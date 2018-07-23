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
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.ichorpowered.guardian.api.game.model.component;

import com.google.common.collect.ImmutableList;
import com.google.inject.assistedinject.Assisted;
import com.ichorpowered.guardian.api.game.model.Model;
import com.ichorpowered.guardian.api.game.model.value.Value;
import com.ichorpowered.guardian.api.game.model.value.key.ValueKey;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.List;
import java.util.Optional;

/**
 * Represents a container for values associated with
 * game object behaviour or data.
 */
public interface Component {

    /**
     * Returns the assigned string id for this {@link Component}.
     *
     * @return the id this component is assigned
     */
    @NonNull String getKey();

    /**
     * Returns the {@link Model} this {@link Component} belongs
     * to.
     *
     * @return the model this component belongs to
     */
    @NonNull Model getModel();

    /**
     * Gets the value based on the value key. Contains
     * the underlying value if it is present in the storage
     * adapter, if not returns an empty value container.
     *
     * @param key the value key
     * @param <E> the value type
     * @return the value container, if present
     */
    @NonNull <E> Optional<Value<E>> getValue(@NonNull ValueKey<E> key);

    /**
     * Sets the value based on the value key. Inserts the
     * element as the underlying value into the adapter and
     * value container.
     *
     * @param key the value key
     * @param element the element
     * @param <E> the element type
     * @return the add value container, if present
     */
    @NonNull <E> Optional<Value<E>> setValue(@NonNull ValueKey<E> key, E element);

    /**
     * Removes the value based on the node type, node key and
     * type token. Removes the underlying value from the adapter
     * and value container.
     *
     * @param key the value key
     * @param <E> the value type
     * @return the empty value container, if present
     */
    @NonNull <E> Optional<Value<E>> removeValue(@NonNull ValueKey<E> key);

    /**
     * Returns an {@link ImmutableList} of default {@link String}s.
     *
     * @return the default values
     */
    @NonNull ImmutableList<String> defaultKeys();

    /**
     * Returns an {@link ImmutableList} of {@link ValueKey}s contained
     * inside this {@link Component}.
     *
     * @return the currently stored component values
     */
    @NonNull ImmutableList<ValueKey<?>> keys();

    /**
     * A factory for creating a new {@link Component}.
     */
    interface Factory {

        /**
         * Create a new {@link Component} with the specified
         * properties.
         *
         * @param id the identifying key
         * @param model the owning model
         * @param defaultValues the default keys
         * @return the new component
         */
        @NonNull Component create(@NonNull @Assisted String id,
                                  @NonNull @Assisted Model model,
                                  @NonNull @Assisted List<String> defaultValues);

    }

}
