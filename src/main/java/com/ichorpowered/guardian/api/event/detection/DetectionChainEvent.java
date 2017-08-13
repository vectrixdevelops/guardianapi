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
package com.ichorpowered.guardian.api.event.detection;

import com.ichorpowered.guardian.api.detection.DetectionChain;
import com.ichorpowered.guardian.api.entry.EntityEntry;
import com.ichorpowered.guardian.api.event.GuardianEvent;
import com.ichorpowered.guardian.api.report.Summary;

/**
 * The event that is fired when a detection chain
 * has started, changed a phase, or finished.
 */
public interface DetectionChainEvent extends GuardianEvent {

    /**
     * Returns the entity entry that the
     * {@link DetectionChain} is running for.
     *
     * @return the entity entry
     */
    EntityEntry getEntityEntry();

    /**
     * Returns the {@link Summary} that was
     * updated during the {@link DetectionChain}.
     *
     * @param <E> the check detections owner type
     * @param <F> the check detections configuration type
     * @return the summary
     */
    <E, F> Summary<E, F> getSummary();

    /**
     * The event that is fired when a detection chain
     * has started.
     */
    interface Start extends DetectionChainEvent {

    }

    /**
     * The event that is fired when a detection chain
     * has changed its phase.
     */
    interface PhaseChange extends DetectionChainEvent {

    }

    /**
     * The event that is fired when a detection chain
     * has ended.
     */
    interface End extends DetectionChainEvent {

    }

}
