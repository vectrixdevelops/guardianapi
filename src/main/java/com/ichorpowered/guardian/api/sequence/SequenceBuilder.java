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

import com.ichorpowered.guardian.api.detection.Check;
import com.ichorpowered.guardian.api.sequence.action.Action;
import com.ichorpowered.guardian.api.sequence.action.ActionBlueprint;
import com.ichorpowered.guardian.api.sequence.action.ActionBuilder;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Represents a builder to create a {@link Sequence} with.
 */
public interface SequenceBuilder {

    /**
     * Returns a new {@link ActionBuilder} for an
     * event, by its class.
     *
     * @param clazz the event class
     * @param <T> the event type
     * @return the action builder
     */
    @Nonnull
    <T> ActionBuilder<T> action(@Nullable Class<T> clazz);

    /**
     * Returns a new {@link ActionBuilder} for an
     * event, by its {@link ActionBlueprint}.
     *
     * @param blueprint the action blueprint
     * @param <T> the event type
     * @return the action builder
     */
    @Nonnull
    <T> ActionBuilder<T> action(@Nullable ActionBlueprint<T> blueprint);

    /**
     * Returns a new {@link ActionBuilder} for an
     * event, by its {@link Action}.
     *
     * @param action the action
     * @param <T> the event type
     * @return the action builder
     */
    @Nonnull
    <T> ActionBuilder<T> action(@Nullable Action<T> action);

    /**
     * Returns a new {@link SequenceBlueprint} for
     * creating new {@link Sequence}s with.
     *
     * @param check the check
     * @param <E> the checks detection owner type
     * @param <F> the checks detection configuration type
     * @return the sequence blueprint
     */
    @Nonnull
    <E, F> SequenceBlueprint<E, F> build(Check<E, F> check);

}
