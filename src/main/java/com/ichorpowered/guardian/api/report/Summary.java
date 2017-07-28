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
package com.ichorpowered.guardian.api.report;

import com.ichorpowered.guardian.api.detection.Detection;
import com.ichorpowered.guardian.api.event.origin.Origin;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Represents a group of reports that have
 * been carried through a chain of operations
 * to produce an accurate outcome for the specific
 * player.
 *
 * @param <E> the detection owner type
 * @param <F> the detection configuration type
 * @param <P> the player type
 */
public interface Summary<E, F, P> extends Iterable<Report> {

    /**
     * Returns the plugin that owns the detection
     * that created this summary.
     *
     * @return the detection owner
     */
    @Nonnull
    E getOwner();

    /**
     * Returns the {@link Detection} that owns this summary.
     *
     * @return the summary owner
     */
    @Nonnull
    Detection<E, F, P> getDetection();

    /**
     * Inserts a {@link Report} into a map, for summary.
     *
     * <p>If there is an existing report under that key,
     * it will be overwritten.</p>
     *
     * @param key the report class
     * @param report the report
     * @param <T> the report type
     */
    <T extends Report> void set(@Nonnull Class<T> key, @Nonnull Report report);

    /**
     * Returns an immutable copy of the {@link Report} that is represented
     * by its key.
     *
     * @param key the report class
     * @param <T> the report type
     * @return the report, or {@code null} if the report is not contained in this summary
     */
    @Nullable
    <T extends Report> T view(@Nonnull Class<T> key);

    /**
     * Returns the {@link Origin} of this {@link Summary}.
     *
     * @return the summary origin
     */
    @Nonnull
    Origin getOrigin();

}
