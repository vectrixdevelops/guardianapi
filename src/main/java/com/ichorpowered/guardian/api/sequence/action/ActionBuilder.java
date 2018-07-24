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
package com.ichorpowered.guardian.api.sequence.action;

import com.ichorpowered.guardian.api.sequence.Sequence;
import com.ichorpowered.guardian.api.sequence.SequenceBlueprint;
import com.ichorpowered.guardian.api.sequence.SequenceContext;
import com.ichorpowered.guardian.api.sequence.action.after.AfterAction;
import com.ichorpowered.guardian.api.sequence.action.after.AfterActionBuilder;
import com.ichorpowered.guardian.api.sequence.action.observe.ObserverAction;
import com.ichorpowered.guardian.api.sequence.action.observe.ObserverActionBlueprint;
import com.ichorpowered.guardian.api.sequence.action.observe.ObserverActionBuilder;
import com.ichorpowered.guardian.api.sequence.action.schedule.ScheduleAction;
import com.ichorpowered.guardian.api.sequence.action.schedule.ScheduleActionBuilder;

public interface ActionBuilder<T> {

    /**
     * Adds a new {@link ObserverAction} to the {@link Sequence}
     * using a {@link Class} from a specific event.
     *
     * @param event the event
     * @return the observer action builder
     */
    ObserverActionBuilder<T> observe(final Class<T> event);

    /**
     * Adds a new {@link ObserverAction} to the {@link Sequence}
     * from a {@link ObserverActionBuilder}.
     *
     * @param actionBlueprint the observer action blueprint
     * @return the observer action builder
     */
    ObserverActionBuilder<T> observe(final ObserverActionBlueprint<T> actionBlueprint);

    /**
     * Adds a new {@link ObserverAction} to the {@link Sequence}.
     *
     * @param action the observer action
     * @return the observer action builder
     */
    ObserverActionBuilder<T> observe(final ObserverAction<T> action);

    /**
     * Adds a new {@link AfterAction} to the {@link Sequence}.
     *
     * @return the after action builder
     */
    AfterActionBuilder<T> after();

    /**
     * Adds a new {@link AfterAction} to the {@link Sequence}.
     *
     * @param afterAction the after action
     * @return the after action builder
     */
    AfterActionBuilder<T> after(final AfterAction afterAction);

    /**
     * Adds a new {@link ScheduleAction} to the {@link Sequence}.
     *
     * @return the schedule action builder
     */
    ScheduleActionBuilder<T> schedule();

    /**
     * Adds a new {@link ScheduleAction} to the {@link Sequence}.
     *
     * @param scheduleAction the schedule action
     * @return the schedule action builder
     */
    ScheduleActionBuilder<T> schedule(final ScheduleAction scheduleAction);

    /**
     * Returns a new {@link SequenceBlueprint} containing
     * the {@link Sequence} of {@link ObserverAction}s and
     * {@link ScheduleAction}s.
     *
     * @param buildContext the sequence context
     * @return the sequence blueprint
     */
    SequenceBlueprint<T> build(final SequenceContext buildContext);

}
