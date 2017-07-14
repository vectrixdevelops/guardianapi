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

import com.ichorpowered.guardian.api.detection.Check;
import com.ichorpowered.guardian.api.sequence.Sequence;
import com.ichorpowered.guardian.api.sequence.SequenceBlueprint;
import com.ichorpowered.guardian.api.sequence.condition.Condition;

/**
 * Represents a builder to create {@link Action}s with.
 *
 * @param <T> the event type
 * @param <P> the player type
 */
public interface ActionBuilder<T, P> {

    /**
     * Returns this {@link ActionBuilder} and adds the
     * {@code condition} to the builder.
     *
     * @param condition the condition
     * @return this builder
     */
    ActionBuilder<T, P> condition(Condition<T, P> condition);

    /**
     * Returns this {@link ActionBuilder} and adds the
     * delay {@code time} to the builder.
     *
     * @param time the delay period
     * @return this builder
     */
    ActionBuilder<T, P> delay(int time);

    /**
     * Returns this {@link ActionBuilder} and adds the
     * expire {@code time} to the builder.
     *
     * @param time the expire period
     * @return this builder
     */
    ActionBuilder<T, P> expire(int time);

    /**
     * Returns this {@link ActionBuilder} and adds the
     * success {@code condition} to the builder.
     *
     * @param condition the condition
     * @return this builder
     */
    ActionBuilder<T, P> success(Condition<T, P> condition);

    /**
     * Returns this {@link ActionBuilder} and adds the
     * failure {@code condition} to the builder.
     *
     * @param condition the condition
     * @return this builder
     */
    ActionBuilder<T, P> failure(Condition<T, P> condition);

    /**
     * Returns a new {@link ActionBuilder} for an
     * event, by its class.
     *
     * @param clazz the event class
     * @param <K> the event type
     * @return the action builder
     */
    <K> ActionBuilder<K, P> action(Class<K> clazz);

    /**
     * Returns a new {@link ActionBuilder} for an
     * event, by its {@link ActionBlueprint}.
     *
     * @param blueprint the action blueprint
     * @param <K> the event type
     * @return the action builder
     */
    <K> ActionBuilder<K, P> action(ActionBlueprint<K, P> blueprint);

    /**
     * Returns a new {@link ActionBuilder} for an
     * event, by its {@link Action}.
     *
     * @param action the action
     * @param <K> the event type
     * @return the action builder
     */
    <K> ActionBuilder<K, P> action(Action<K, P> action);

    /**
     * Returns a new {@link SequenceBlueprint} for
     * creating new {@link Sequence}s with.
     *
     * @param check the check
     * @param <E> the checks detection owner type
     * @param <F> the checks detection configuration type
     * @return the sequence blueprint
     */
    <E, F> SequenceBlueprint<E, F, P> build(Check<E, F> check);


}
