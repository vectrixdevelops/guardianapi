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
package com.ichorpowered.guardianapi.event.detection;

import com.ichorpowered.guardianapi.detection.report.Summary;
import com.ichorpowered.guardianapi.detection.stage.StageCycle;
import com.ichorpowered.guardianapi.entry.entity.EntityEntry;
import com.ichorpowered.guardianapi.event.GuardianEvent;

import javax.annotation.Nonnull;

/**
 * The event that is fired when a detection chain
 * has started, changed a stage, or finished.
 */
public interface DetectionPhaseEvent extends GuardianEvent {

    /**
     * Returns the entity entry that the
     * {@link StageCycle} is running for.
     *
     * @return the entity entry
     */
    @Nonnull
    EntityEntry getEntityEntry();

    /**
     * Returns the {@link Summary} that was
     * updated during the {@link StageCycle}.
     *
     * @return the summary
     */
    @Nonnull
    Summary getSummary();

}
