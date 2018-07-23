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
package com.ichorpowered.guardian.api.sequence;

import com.ichorpowered.guardian.api.game.GameReference;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.function.Predicate;

public interface SequenceController<T> {

    /**
     * Invokes the observer test with the provided event,
     * {@link GameReference} and {@link SequenceContext}
     * if the predicate returns {@code true}.
     *
     * @param event the event
     * @param gameReference the player reference
     * @param sequenceContext the sequence context
     * @param predicate the predicate
     */
    void invokeObserver(@NonNull T event, @NonNull GameReference<?> gameReference,
                        @NonNull SequenceContext sequenceContext, @NonNull Predicate<Sequence<T>> predicate);

    /**
     * Invokes the scheduler update with the provided
     * {@link SequenceContext} if the predicate returns
     * true.
     *
     * @param gameReference the player reference
     * @param sequenceContext the sequence context
     * @param predicate the predicate
     */
    void invokeScheduler(@NonNull GameReference<?> gameReference, @NonNull SequenceContext sequenceContext,
                         @NonNull Predicate<Sequence<T>> predicate);

    /**
     * Adds the event type and {@link GameReference}
     * to the sequence avoidance list, which skips running
     * {@link Sequence}s under those conditions.
     *
     * @param gameReference the player reference
     * @param eventType the event type
     * @return the id of the avoidance ticket
     */
    @NonNull Long avoidObserver(@NonNull GameReference<?> gameReference, @NonNull Class<? extends T> eventType);

    /**
     * Removes the event type and {@link GameReference}
     * from the sequence avoidance list, which allows
     * {@link Sequence}s under those conditions.
     *
     * @param gameReference the player reference
     * @param eventType the event type
     * @param index the id of the avoidance ticket
     * @return true if it successfully removes, false if it does not
     */
    @NonNull boolean unavoidObserver(@NonNull GameReference<?> gameReference, @NonNull Class<? extends T> eventType, @NonNull Long index);

    void clean(@NonNull boolean force);

    void clean(@NonNull GameReference<?> gameReference, @NonNull boolean force);

}
