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
package com.ichorpowered.guardian.api.detection.penalty;

import com.ichorpowered.guardian.api.detection.DetectionConfiguration;

import javax.annotation.Nonnull;

/**
 * Represents an operation that can be used
 * at the end of a detection chain to invoke
 * a penalty on a player that has violated
 * a detection check.
 */
public interface Penalty {

    /**
     * Returns the function to test in
     * order to invoke the correct punishment
     * on a player who has violated a detection
     * check.
     *
     * @param <E> the detection owner type
     * @param <F> the detection configuration type
     * @return the penalty predicate
     */
    @Nonnull
    <E, F extends DetectionConfiguration> PenaltyPredicate<E, F> getPredicate();

}
