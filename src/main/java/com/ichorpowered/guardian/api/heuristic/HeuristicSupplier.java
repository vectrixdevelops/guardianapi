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
package com.ichorpowered.guardian.api.heuristic;

import com.ichorpowered.guardian.api.detection.Detection;
import com.ichorpowered.guardian.api.report.Report;
import com.ichorpowered.guardian.api.report.Summary;

/**
 * Supplier for registered heuristics in running and acquiring
 * the result.
 *
 * @param <P> the plugin container type
 * @param <E> the detection owner type
 * @param <F> the detection configuration type
 */
@FunctionalInterface
public interface HeuristicSupplier<P, E, F> {

    /**
     * Applies a plugin container, {@link Detection} and {@link Summary}
     * to this operation to add a {@link Report} to the existing {@link Summary}
     * to improve accuracy of the final evaluation.
     *
     * @param pluginContainer the plugin container
     * @param detection the detection
     * @param summary the summary
     * @return the updated summary
     */
    Summary<E, F> apply(P pluginContainer, Detection<E, F> detection, Summary<E, F> summary);

}
