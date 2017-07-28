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
package com.ichorpowered.guardian.api.sequence.action;

import com.ichorpowered.guardian.api.sequence.Condition;
import com.ichorpowered.guardian.api.sequence.Sequence;

import javax.annotation.Nonnull;

/**
 * Represents a set of conditions to run in
 * a {@link Sequence}.
 *
 * @param <T> the event type
 * @param <P> the player type
 */
public interface Action<T, P> {

    /**
     * Inserts a condition to this {@link Action} to
     * be run.
     *
     * @param condition the condition
     */
    void addCondition(@Nonnull Condition<T, P> condition);

    /**
     * Sets this actions delay period.
     *
     * @param time the delay period
     */
    void setDelay(int time);

    /**
     * Sets this actions expire period.
     *
     * @param time the expire period
     */
    void setExpire(int time);

    /**
     * Returns the result of applying this action
     * in the {@link Sequence}.
     *
     * @param player the player
     * @param event the event
     * @param lastActionTime the last action time
     * @return the result
     */
    boolean apply(@Nonnull P player, @Nonnull T event, long lastActionTime);

    /**
     * Returns the result of applying this actions
     * success {@link Condition}s in the {@link Sequence}.
     *
     * @param player the player
     * @param event the event
     * @param lastActionTime the last action time
     * @return the result
     */
    boolean succeed(@Nonnull P player, @Nonnull T event, long lastActionTime);

    /**
     * Returns the result of applying this actions
     * fail {@link Condition}s in the {@link Sequence}.
     *
     * @param player the player
     * @param event the event
     * @param lastActionTime the last action time
     * @return the result
     */
    boolean fail(@Nonnull P player, @Nonnull T event, long lastActionTime);

    /**
     * Returns this actions delay period.
     *
     * @return the delay period
     */
    int getDelay();

    /**
     * Returns this actions expire period.
     *
     * @return the expire period
     */
    int getExpire();

    /**
     * Returns the event this action is representing.
     *
     * @return the representing event
     */
    @Nonnull
    Class<? extends T> getEvent();

}
