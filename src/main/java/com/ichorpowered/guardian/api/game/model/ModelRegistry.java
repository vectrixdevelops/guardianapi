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

import com.ichorpowered.guardian.api.game.GameReference;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.List;
import java.util.Optional;

/**
 * The frame registry provides a way to virtually bind
 * groups of components in a frame to represent a game object.
 * The game object could literally be anything that can be
 * uniquely identified.
 *
 * The frame registry can also bulk clone components from
 * one frame to another, populating the target frame with
 * the source frames values. Note that the target game object
 * should already have been bound first before cloning to.
 * This will also overwrite any existing values in the target
 * frame.
 *
 * Rebinding frames can be done by unbinding and then binding
 * again.
 */
public interface ModelRegistry {

    /**
     * Create the {@link Model} for the representing game
     * object reference.
     *
     * @param gameReference the game object reference
     * @param <T> the frame type
     * @return a new or existing frame for this game reference
     */
    @NonNull <T extends Model> T create(@NonNull String id, @NonNull GameReference<?> gameReference);

    /**
     * Create the {@link Model} for the representing game
     * object reference.
     *
     * @param gameReference the game object reference
     * @param <T> the frame type
     * @return a new or existing frame for this game reference
     */
    @NonNull <T extends Model> T create(@NonNull String id, @NonNull GameReference<?> gameReference, @NonNull List<String> defaultComponents);

    /**
     * Get the {@link Model} for the representing game object
     * reference, if present.
     *
     * @param gameReference the game object reference
     * @param <T> the frame type
     * @return an existing frame for this game reference, if present
     */
    @NonNull <T extends Model> Optional<T> get(@NonNull GameReference<?> gameReference);

    /**
     * Remove the {@link Model} from the representing game object
     * reference and return it, if present.
     *
     * @param gameReference the game object reference
     * @param <T> the frame type
     * @return an existing frame for this game referenced that has been removed, if present
     */
    @NonNull <T extends Model> Optional<T> remove(@NonNull GameReference<?> gameReference);

    /**
     * Clones the {Value}s from the other {@link Model} and adds
     * them to a new one representing the game object reference.
     *
     * @param gameReference the game object reference
     * @param otherFrame the other frame
     * @param <T> the frame type
     * @return a new or existing frame for this game referenced with overwriting other frame values
     */
    @NonNull <T extends Model> T clone(@NonNull String id, @NonNull GameReference<?> gameReference, @NonNull T otherFrame);

}
