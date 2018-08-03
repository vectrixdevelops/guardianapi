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
package com.ichorpowered.guardian.api.game.model;

import com.google.inject.assistedinject.Assisted;
import com.ichorpowered.guardian.api.game.GameReference;
import com.ichorpowered.guardian.api.game.model.value.Value;
import com.ichorpowered.guardian.api.game.model.value.key.Key;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Represents a container for components associated
 * with game object behaviour or data.
 */
public interface Model {

    @NonNull String getId();

    /**
     * Return the game reference this {@link Model}
     * represents.
     *
     * @param <T> the reference type
     * @return the game reference
     */
    @NonNull <T> GameReference<T> getGameReference();

    @NonNull <E> List<Value<E>> offer(@NonNull Key<E> key, E element);

    @NonNull <E> List<Value<E>> offer(@NonNull Set<String> components, @NonNull Key<E> key, E element);

    @NonNull <E> List<Value<E>> request(@NonNull Key<E> key);

    @NonNull <E> List<Value<E>> request(@NonNull Set<String> components, @NonNull Key<E> key);

    @NonNull <E> Optional<Value<E>> requestFirst(@NonNull Key<E> key);

    @NonNull <E> Optional<Value<E>> requestFirst(@NonNull String component, @NonNull Key<E> key);

    /**
     * Creates a new {@link Component} that matches the class type.
     *
     * @param id the component id
     * @return the new component
     */
    @NonNull Component createComponent(@NonNull String id);

    /**
     * Returns the {@link Component} that matches the type.
     *
     * @param id the component id
     * @return the component, if present
     */
    @NonNull Optional<Component> getComponent(@NonNull String id);

    /**
     * Clones the {@link Component} that matches the type
     * and overwrites it with the specified {@link Component}
     * values.
     *
     * @param id the component id
     * @param component the other component
     * @return the cloned component
     */
    @NonNull Component cloneComponent(@NonNull String id, @NonNull Component component);

    /**
     * Removes the {@link Component} that matches the type
     * from this frame container.
     *
     * @param id the component id
     * @return the removed component, if present
     */
    @NonNull Optional<Component> removeComponent(@NonNull String id);

    /**
     * Returns an immutable {@link List} of default {@link Component}s.
     *
     * @return the default components
     */
    @NonNull List<Component> getDefaultComponents();

    /**
     * Returns an immutable {@link List} of {@link Component}s contained
     * inside this {@link Model}.
     *
     * @return the currently stored frame components
     */
    @NonNull List<Component> getComponents();

    /**
     * A factory for creating a new {@link Model}.
     */
    interface Factory {

        /**
         * Create a new {@link Model} with the specified
         * properties.
         *
         * @param gameReference the game reference
         * @param defaultComponents the default components
         * @return the new frame
         */
        @NonNull Model create(@NonNull @Assisted String id,
                              @NonNull @Assisted GameReference<?> gameReference,
                              @NonNull @Assisted("defaultComponents") List<String> defaultComponents);

    }

}
