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
package com.ichorpowered.guardianapi;

import com.abilityapi.sequenceapi.SequenceManager;
import com.abilityapi.sequenceapi.SequenceRegistry;
import com.ichorpowered.guardianapi.detection.DetectionManager;
import com.ichorpowered.guardianapi.detection.check.CheckModel;
import com.ichorpowered.guardianapi.detection.heuristic.HeuristicModel;
import com.ichorpowered.guardianapi.detection.penalty.PenaltyModel;
import com.ichorpowered.guardianapi.event.GuardianEvent;
import com.ichorpowered.guardianapi.event.GuardianListener;
import net.kyori.event.SimpleEventBus;

/**
 * Represents an accessor to registries for
 * this cheat detection system.
 *
 * @param <T> the event type
 */
public interface Guardian<T> {

    // Sub Systems

    /**
     * Returns the event bus.
     *
     * @return the event bus
     */
    SimpleEventBus<GuardianEvent, GuardianListener> getEventBus();

    // Life Cycle

    /**
     * Returns the plugin state.
     *
     * @return the plugin state
     */
    GuardianState getState();

    // Managers

    /**
     * Returns the detection manager.
     *
     * @return the detection manager
     */
    DetectionManager getDetectionManager();

    /**
     * Returns the sequence manager.
     *
     * @return the sequence manager
     */
    SequenceManager<T> getSequenceManager();

    // Registries

    /**
     * Returns the sequence registry.
     *
     * @return the sequence registry
     */
    SequenceRegistry getSequenceRegistry();

    // Stage Models

    /**
     * Returns the check model.
     *
     * @return the check model
     */
    CheckModel getCheckModel();

    /**
     * Returns the heuristic model.
     *
     * @return the heuristic model
     */
    HeuristicModel getHeuristicModel();

    /**
     * Returns the penalty model.
     *
     * @return the penalty model
     */
    PenaltyModel getPenaltyModel();

}
