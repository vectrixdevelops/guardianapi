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

import com.ichorpowered.guardian.api.detection.DetectionConfiguration;
import com.ichorpowered.guardian.api.detection.check.Check;
import com.ichorpowered.guardian.api.sequence.Sequence;
import com.ichorpowered.guardian.api.sequence.SequenceBlueprint;
import com.ichorpowered.guardian.api.sequence.condition.ConditionSupplier;

/**
 * Represents a builder to create {@link Action}s with.
 *
 * @param <E> the checks detection owner type
 * @param <F> the checks detection configuration type
 * @param <T> the event type
 */
public interface ActionBuilder<E, F extends DetectionConfiguration, T> {

    /**
     * Returns this {@link ActionBuilder} and adds the
     * {@code condition} to the builder.
     *
     * @param condition the condition
     * @return this builder
     */
    ActionBuilder<E, F, T> condition(ConditionSupplier<E, F, T> condition);

    /**
     * Returns this {@link ActionBuilder} and adds the
     * delay {@code time} to the builder.
     *
     * @param time the delay period
     * @return this builder
     */
    ActionBuilder<E, F, T> delay(int time);

    /**
     * Returns this {@link ActionBuilder} and adds the
     * expire {@code time} to the builder.
     *
     * @param time the expire period
     * @return this builder
     */
    ActionBuilder<E, F, T> expire(int time);

    /**
     * Returns this {@link ActionBuilder} and adds the
     * success {@code condition} to the builder.
     *
     * @param condition the condition
     * @return this builder
     */
    ActionBuilder<E, F, T> success(ConditionSupplier<E, F, T> condition);

    /**
     * Returns this {@link ActionBuilder} and adds the
     * failure {@code condition} to the builder.
     *
     * @param condition the condition
     * @return this builder
     */
    ActionBuilder<E, F, T> failure(ConditionSupplier<E, F, T> condition);

    /**
     * Returns a new {@link ActionBuilder} for an
     * event, by its class.
     *
     * @param clazz the event class
     * @param <K> the event type
     * @return the action builder
     */
    <K> ActionBuilder<E, F, K> action(Class<K> clazz);

    /**
     * Returns a new {@link ActionBuilder} for an
     * event, by its {@link ActionBlueprint}.
     *
     * @param blueprint the action blueprint
     * @param <K> the event type
     * @return the action builder
     */
    <K> ActionBuilder<E, F, K> action(ActionBlueprint<K> blueprint);

    /**
     * Returns a new {@link ActionBuilder} for an
     * event, by its {@link Action}.
     *
     * @param action the action
     * @param <K> the event type
     * @return the action builder
     */
    <K> ActionBuilder<E, F, K> action(Action<K> action);

    /**
     * Returns a new {@link SequenceBlueprint} for
     * creating new {@link Sequence}s with.
     *
     * @param check the check
     * @return the sequence blueprint
     */
    SequenceBlueprint<E, F> build(Check<E, F> check);


}
