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
package com.ichorpowered.guardian.api.game.resource;

import com.google.inject.assistedinject.Assisted;
import com.ichorpowered.guardian.api.game.GameReference;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

/**
 * Represents a container of grouped players
 * that are automatically assigned on addition.
 */
public interface PlayerResource {

    /**
     * Adds a new player reference to the resource
     * container.
     *
     * @param reference the player reference
     * @return this resource
     */
    @NonNull PlayerResource add(GameReference<?> reference);

    /**
     * Adds the new player references to the resource
     * container.
     *
     * @param references the player references
     * @return this resource
     */
    @NonNull PlayerResource add(GameReference<?>[] references);

    /**
     * Returns a {@link Collection} of {@link GameReference}s in
     * the specified group.
     *
     * @param group the group number
     * @return a collection of unique references for this group
     */
    @NonNull Collection<GameReference<?>> get(int group);

    /**
     * Returns the group id {@link Integer}, for the group
     * the player {@link GameReference} is located in.
     *
     * @param reference the player reference
     * @return the group id
     */
    @NonNull Optional<Integer> get(GameReference<?> reference);

    /**
     * Returns the collection of resource entries.
     *
     * @return the resource entries
     */
    @NonNull Collection<Map.Entry<Integer, GameReference<?>>> getAll();

    /**
     * Removes the reference from the group they may
     * be in, returns true if they were removed, false
     * if they could not be found.
     *
     * @param reference the player reference
     * @return true if they could be removed, false if they were not
     */
    @NonNull Boolean remove(GameReference<?> reference);

    /**
     * Removes the reference from the group specified,
     * returns true if they were removed, false if they
     * could not be found.
     *
     * @param reference the player reference
     * @param group the group id
     * @return true if they could be removed, false if they were not
     */
    @NonNull Boolean remove(GameReference<?> reference, int group);

    /**
     * Removes all the player references from the specified group
     * and returns them.
     *
     * @param group the group id
     * @return the player references that have been removed
     */
    @NonNull Collection<GameReference<?>> removeAll(int group);

    /**
     * Removes all groups and their references.
     */
    void clear();

    /**
     * Returns the current container size of
     * groups in this resource.
     *
     * @return the current container size
     */
    @NonNull Integer getContainerSize();

    /**
     * Returns the max container size of
     * groups allowed in this resource.
     *
     * @return the maximum container size
     */
    @NonNull Integer getMaxContainerSize();

    /**
     * Returns the max group size of players
     * allowed.
     *
     * @return the maximum group size
     */
    @NonNull Integer getMaxGroupSize();

    /**
     * Returns the min group size of players
     * allowed.
     *
     * @return the minimum group size
     */
    @NonNull Integer getMinGroupSize();

    /**
     * A factory for creating a new {@link PlayerResource}.
     */
    interface Factory {

        /**
         * Create a new {@link PlayerResource} with the specified
         * properties.
         *
         * @param maxContainerSize the maximum container size
         * @param maxGroupSize the maximum group size
         * @param minGroupSize the minimum group size
         * @return the new player resource
         */
        @NonNull PlayerResource create(@Assisted("maxContainerSize") Integer maxContainerSize,
                                       @Assisted("maxGroupSize") Integer maxGroupSize,
                                       @Assisted("minGroupSize") Integer minGroupSize);

    }

}
