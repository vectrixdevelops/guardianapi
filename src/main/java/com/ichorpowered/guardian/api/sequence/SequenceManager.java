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
package com.ichorpowered.guardian.api.sequence;

import com.ichorpowered.guardian.api.entry.EntityEntry;

import java.util.UUID;
import java.util.function.Predicate;

import javax.annotation.Nonnull;

/**
 * Represents a way to manage sequences.
 *
 * @param <T> the event type
 */
public interface SequenceManager<T> {

    /**
     * Invokes a sequence check passing on the
     * player and event.
     *
     * @param entry the entity entry
     * @param event the event
     */
    void invoke(@Nonnull EntityEntry entry, @Nonnull T event);

    /**
     * Invokes a sequence check if the predicate
     * for the provided sequence passes with the
     * player and event.
     *
     * @param entry the entity entry
     * @param event the event
     * @param predicate the predicate test
     */
    void invokeFor(@Nonnull EntityEntry entry, @Nonnull T event, @Nonnull Predicate<Sequence> predicate);

    /**
     * Removes sequences that contain this event class
     * as its trigger.
     *
     * @param entry the entity entry
     * @param eventClass the event class
     */
    void removeFor(@Nonnull EntityEntry entry, @Nonnull Class<? extends T> eventClass);

    /**
     * Stops invocation of sequences that contain
     * this event class as its trigger.
     *
     * @param entry the entity entry
     * @param eventClass the event class
     * @param removeExisting removes running sequences with this trigger
     * @return the block id
     */
    UUID closeFor(@Nonnull EntityEntry entry, @Nonnull Class<? extends T> eventClass, boolean removeExisting);

    /**
     * Opens invocation of sequences that contain
     * this event class as its trigger.
     *
     * @param id the block id
     * @param entry the entity entry
     * @param eventClass the event class
     */
    void openFor(@Nonnull UUID id, @Nonnull EntityEntry entry, @Nonnull Class<? extends T> eventClass);

    /**
     * Cleans up discontinued sequences.
     *
     * <p>If set to {@code force}, it will remove
     * all the existing sequences regardless whether
     * the sequences have stopped.</p>
     *
     * @param force the option to forcefully remove
     */
    void clean(boolean force);

    /**
     * Cleans up discontinued sequences for a player.
     *
     * <p>If set to {@code force}, it will remove
     * all the sequences from the player regardless
     * whether the sequences have stopped.</p>
     *
     * @param entry the entity entry
     * @param force the option to forcefully remove
     */
    void clean(@Nonnull EntityEntry entry, boolean force);

}
