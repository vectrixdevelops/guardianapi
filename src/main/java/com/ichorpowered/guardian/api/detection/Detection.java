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
package com.ichorpowered.guardian.api.detection;

import javax.annotation.Nonnull;

/**
 * Represents a type of cheat or illegal
 * activity, that can be found by running
 * specific checks on players actively.
 *
 * @param <E> the detection owner type
 * @param <F> the detection configuration type
 */
public interface Detection<E, F> {

    /**
     * Returns the plugin that owns this detection.
     *
     * @return the detection owner
     */
    @Nonnull
    E getOwner();

    /**
     * Returns the permission node for the associated target.
     *
     * @param permissionTarget the permission target
     * @return the permission node
     */
    @Nonnull
    String getPermission(@Nonnull String permissionTarget);

    /**
     * Returns the detections configuration.
     *
     * @return the detection configuration
     */
    @Nonnull
    F getConfiguration();

    /**
     * Returns the {@link State} of readiness the detection
     * is in.
     *
     * @return the state of readiness
     */
    @Nonnull
    State getState();

    /**
     * Returns the {@link DetectionChain} of operation keys
     * used for this detection.
     *
     * @return the detection chain
     */
    DetectionChain<E, F> getChain();

    enum State {

        /**
         * Represents the state in which the detections have been initialized
         * and must carry out procedures to get ready for active checking.
         *
         * <p>References must be initialized before {@code State.STARTED} or
         * else checks may try access non-initialized or unready references.</p>
         */
        STARTING,

        /**
         * Represents the state in which the detections have carried out procedures
         * and have been enlisted to undertake active checking.
         *
         * <p>References should be initialized before switching to this state.</p>
         */
        STARTED,

        /**
         * Represents the state in which new active checking is stopped and
         * ending procedures should take place.
         */
        FINISHING,

        /**
         * Represents the state in which the detections have no more active checks
         * and are ready to be removed.
         */
        FINISHED,

        /**
         * Represents the default state when the module has not been initialized
         * or what is set before the module is removed.
         */
        UNDEFINED

    }

}
