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
package com.ichorpowered.guardian.api;

import com.ichorpowered.guardian.api.detection.DetectionRegistry;
import com.ichorpowered.guardian.api.event.GuardianEvent;
import com.ichorpowered.guardian.api.event.GuardianListener;
import com.ichorpowered.guardian.api.heuristic.HeuristicRegistry;
import com.ichorpowered.guardian.api.module.ModuleRegistry;
import com.ichorpowered.guardian.api.penalty.PenaltyRegistry;
import com.ichorpowered.guardian.api.sequence.SequenceManager;
import net.kyori.event.SimpleEventBus;

/**
 * Represents an accessor to registries for
 * this cheat detection system.
 */
public interface Guardian extends GuardianBasic {

    /**
     * Returns the event bus.
     *
     * @return the event bus
     */
    SimpleEventBus<GuardianEvent, GuardianListener> getEventBus();

    /**
     * Returns the detection registry.
     *
     * @return the detection registry
     */
    DetectionRegistry getDetectionRegistry();

    /**
     * Returns the heuristic registry.
     *
     * @return the heuristic registry
     */
    HeuristicRegistry getHeuristicRegistry();

    /**
     * Returns the module registry.
     *
     * @return the module registry
     */
    ModuleRegistry getModuleRegistry();

    /**
     * Returns the penalty registry.
     *
     * @return the penalty registry
     */
    PenaltyRegistry getPenaltyRegistry();

    /**
     * Returns the sequence manager.
     *
     * @return the sequence manager
     */
    SequenceManager getSequenceManager();

}
