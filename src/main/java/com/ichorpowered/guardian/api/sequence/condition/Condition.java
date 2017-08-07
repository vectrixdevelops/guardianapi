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

import com.ichorpowered.guardian.api.sequence.Sequence;

/**
 * Represents an operation used to
 * gather and calculate data in a {@link Sequence}
 * chain.
 *
 * @param <T> the event type
 */
public interface Condition<T> {

    /**
     * Returns the interface that allows you
     * to apply the condition operation.
     *
     * @param <E> the check detections owner type
     * @param <F> the check detections configuration type
     * @return the condition operation
     */
    <E, F> ConditionSupplier<E, F, T> get();

    /**
     * Returns the type of condition this has
     * been set to be.
     *
     * @return the type of condition of this
     */
    Type getType();

    enum Type {

        /**
         * A condition that runs on the success of an
         * action.
         */
        SUCCESS,

        /**
         * A condition that runs on the failure of an
         * action.
         */
        FAIL,

        /**
         * A condition that runs normally on an action.
         */
        NORMAL

    }

}
