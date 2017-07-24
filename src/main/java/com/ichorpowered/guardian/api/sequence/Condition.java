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
package com.ichorpowered.guardian.api.sequence;

import com.ichorpowered.guardian.api.report.Summary;

/**
 * Represents an operation used to
 * gather and calculate data in a {@link Sequence}
 * chain.
 *
 * @param <T> the event type
 * @param <P> the player type
 */
@FunctionalInterface
public interface Condition<T, P> {

    /**
     * Returns the result of applying this condition
     * to its arguments.
     *
     * @param player the player
     * @param event the event
     * @param summary the summary
     * @param lastActionTime the last action time
     * @param <E> the checks detection owner type
     * @param <F> the checks detection configuration type
     * @return the summary
     */
    <E, F> Summary<E, F> apply(P player, T event, Summary<E, F> summary, long lastActionTime);

}
