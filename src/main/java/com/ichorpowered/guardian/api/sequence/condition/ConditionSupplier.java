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
package com.ichorpowered.guardian.api.sequence.condition;

import com.ichorpowered.guardian.api.detection.DetectionConfiguration;
import com.ichorpowered.guardian.api.entry.EntityEntry;
import com.ichorpowered.guardian.api.report.Summary;
import com.ichorpowered.guardian.api.sequence.capture.CaptureContainer;

import javax.annotation.Nonnull;

/**
 * Supplier of an operation for acquiring
 * the summary over a set of conditions.
 *
 * @param <E> the check detections owner type
 * @param <F> the check detections configuration type
 * @param <T> the event type
 */
@FunctionalInterface
public interface ConditionSupplier<E, F extends DetectionConfiguration, T> {

    /**
     * Returns the result of applying this condition
     * to its arguments.
     *
     * @param entry the entity entry
     * @param event the event
     * @param captureContainer the capture container
     * @param summary the summary
     * @param lastActionTime the last action time
     * @return the summary
     */
    @Nonnull
    Summary<E, F> apply(@Nonnull EntityEntry entry, @Nonnull T event,
                        @Nonnull CaptureContainer captureContainer, @Nonnull Summary<E, F> summary,
                        long lastActionTime);

}
