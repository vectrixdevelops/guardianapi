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

import com.ichorpowered.guardian.api.util.key.NamedTypeKey;

/**
 * Manages manipulation of phases and their states.
 */
public interface PhaseManipulator {

    /**
     * Switches to the next phase and returns it.
     *
     * @param phaseKey the phase key
     * @param <T> the phase key type
     * @return the next phase
     */
    <T> T next(NamedTypeKey<T> phaseKey);

    /**
     * Returns {@code true} if there is a phase to switch to
     * next, returns {@code false} if there is not.
     *
     * @param phaseKey the phase key
     * @param <T> the phase key type
     * @return possible phase to switch to
     */
    <T> boolean hasNext(NamedTypeKey<T> phaseKey);

    /**
     * Returns the {@link PhaseViewer} state.
     *
     * @param phaseKey the phase key
     * @param <T> the phase key type
     * @return the phase viewer state
     */
    <T> PhaseState getViewerState(NamedTypeKey<T> phaseKey);

    /**
     * Returns the size of the phases for this phase key.
     *
     * @param phaseKey the phase key
     * @param <T> the phase key type
     * @return the size of phases under this phase key
     */
    <T> int size(NamedTypeKey<T> phaseKey);

    /**
     * Returns the size of all the phases combined.
     *
     * @return size of all phase types
     */
    int size();

}
