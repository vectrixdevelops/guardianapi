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

import com.ichorpowered.guardian.api.detection.check.Check;
import com.ichorpowered.guardian.api.detection.check.CheckBlueprint;
import com.ichorpowered.guardian.api.detection.heuristic.Heuristic;

import java.util.Set;

/**
 * Represents the chain of operations to run through
 * for each detection.
 *
 * @param <E> the detection owner type
 * @param <F> the detection configuration type
 */
public interface DetectionChain<E, F extends DetectionConfiguration> {

    /**
     * Returns a set of keys that represents a {@link CheckBlueprint}
     * to use in the chain of operations.
     *
     * @return a set of check keys
     */
    Set<Class<? extends CheckBlueprint<E, F>>> checkKeys();

    /**
     * Returns a set of keys that represents a {@link Heuristic}
     * to use in the chain of operations.
     *
     * @return a set of heuristic keys
     */
    Set<Class<? extends Heuristic>> heuristicKeys();

    interface Builder<E, F extends DetectionConfiguration> {

        /**
         * Inserts a {@link CheckBlueprint} key into the chain to be
         * used in the detection.
         *
         * @param check the check key
         * @return this builder
         */
        Builder<E, F> check(Class<? extends CheckBlueprint<E, F>> check);

        /**
         * Inserts a {@link Heuristic} key into the chain to be
         * used in the detection.
         *
         * @param heuristic the heuristic key
         * @return this builder
         */
        Builder<E, F> heuristic(Class<? extends Heuristic> heuristic);

        /**
         * Returns a new {@link DetectionChain} using the keys
         * this builder has been assigned.
         *
         * @return a detection chain assigned by the builder
         */
        DetectionChain<E, F> build();

    }

}
