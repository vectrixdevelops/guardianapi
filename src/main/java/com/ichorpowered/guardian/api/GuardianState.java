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

/**
 * Represents the life cycle state that the implementation
 * is currently in.
 */
public enum GuardianState {

    /**
     * Represents the state before system initialization
     * takes place and should be used only for pre requisite analysis.
     */
    PRE_INITIALIZATION,

    /**
     * Represents the state where the system should be
     * initialized on.
     *
     * <p>Passing into this state assumes
     * that {@link GuardianState#PRE_INITIALIZATION}
     * analysis was successful.</p>
     */
    INITIALIZATION,

    /**
     * Represents the state after the system has been
     * initialized.
     *
     * <p>All registry elements should be
     * added at this point.</p>
     */
    POST_INITIALIZATION,

    /**
     * Represents the state after registry elements have
     * been added and begin deploying their checks.
     *
     * <p>This state will also run a test chain to check
     * the robustness of each detection.</p>
     */
    STARTING,

    /**
     * Represents the state when everything is running
     * and ready.
     *
     * <p>Registered elements after this state will not
     * run until the registry queue is set to activate
     * new elements. e.g on a reload</p>
     */
    STARTED,

    /**
     * Represents the state when everything is beginning
     * to save and shutdown.
     *
     * <p>Registered elements will be shutdown and the
     * registry queue will not accept any more elements.</p>
     */
    STOPPING,

    /**
     * Represents the state when the registries have been
     * cleared and now the system is uninitialized.
     *
     * <p>System objects will no longer be referenced or
     * usable at this point.</p>
     */
    STOPPED

}
