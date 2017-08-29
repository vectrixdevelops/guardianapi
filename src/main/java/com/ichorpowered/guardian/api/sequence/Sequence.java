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

import com.ichorpowered.guardian.api.detection.DetectionConfiguration;
import com.ichorpowered.guardian.api.entry.EntityEntry;
import com.ichorpowered.guardian.api.report.Summary;
import com.ichorpowered.guardian.api.sequence.action.Action;
import com.ichorpowered.guardian.api.sequence.capture.CaptureRegistry;

/**
 * Represents a sequence of {@link Action}s that can be
 * run in a chain.
 *
 * @param <E> the check detections owner type
 * @param <F> the check detections configuration type
 */
public interface Sequence<E, F extends DetectionConfiguration> {

    /**
     * Returns the result of applying the
     * player and event to the sequence.
     *
     * @param entry the entity entry
     * @param event the event
     * @param <T> the event type
     * @return the result
     */
    <T> boolean apply(EntityEntry entry, T event);

    /**
     * Returns the {@link Summary} for this sequence.
     *
     * @return the summary
     */
    Summary<E, F> getSummary();

    /**
     * Returns the {@link CaptureRegistry} for this sequence.
     *
     * @return the capture registry
     */
    CaptureRegistry getCaptureRegistry();

    /**
     * Returns the {@link SequenceBlueprint} for this sequence.
     *
     * @return the sequence blueprint
     */
    SequenceBlueprint<E, F> getSequenceBlueprint();

    /**
     * Returns {code true} if the sequence is running and
     * {@code false} if it is not.
     *
     * @return the sequence running state
     */
    boolean isRunning();

    /**
     * Returns {@code true} if the sequence has been cancelled
     * and {@code false} if it has not.
     *
     * @return the sequence cancel state
     */
    boolean isCancelled();

    /**
     * Returns {@code true} if the sequence has been running
     * past the expiry time and {@code false} if it has not.
     *
     * @return the sequence expiry state
     */
    boolean isExpired();

    /**
     * Returns {@code true} if the sequence has finished
     * running its actions and {@code false} if it has not.
     *
     * @return the sequence finish state
     */
    boolean isFinished();

}
