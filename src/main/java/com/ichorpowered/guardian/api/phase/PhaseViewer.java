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
package com.ichorpowered.guardian.api.phase;

import com.ichorpowered.guardian.api.detection.Detection;
import com.ichorpowered.guardian.api.detection.DetectionConfiguration;

/**
 * Represents a way to view registered phases.
 *
 * @param <T> the phase key type
 */
public interface PhaseViewer<T> {

    /**
     * Returns the creation or reference to
     * the next phase instance.
     *
     * @param detection the detection
     * @param <E> the detection owner type
     * @param <F> the detection configuration type
     * @return the phase instance
     */
    <E, F extends DetectionConfiguration> T getOrCreatePhase(Detection<E, F> detection);

    /**
     * Returns the next phase instance class.
     *
     * @return the phase instance class
     */
    Class<? extends T> getPhaseClass();

    /**
     * Switches to the next phase in the viewer.
     */
    void next();

    /**
     * Returns the state which this phase is in.
     *
     * @return the phase state
     */
    PhaseState getPhaseState();

    /**
     * Returns the current index of phases that
     * have been acquired in this view.
     *
     * @return the current phase index
     */
    int index();

    /**
     * Returns the amount of phases in this
     * view.
     *
     * @return the amount of phases
     */
    int size();

}
