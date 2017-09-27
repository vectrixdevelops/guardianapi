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
package com.ichorpowered.guardian.api.phase;

import javax.annotation.Nonnull;

/**
 * Represents a way to filter phase instances.
 */
public interface PhaseFilter {

    /**
     * Includes a single class to the filter
     * and returns this.
     *
     * @param include an accepted class
     * @return this filter
     */
    @Nonnull
    PhaseFilter include(@Nonnull Class<?> include);

    /**
     * Includes a collection of classes to the
     * filter and returns this.
     *
     * @param includeAll a collection of accepted classes
     * @return this filter
     */
    @Nonnull
    PhaseFilter include(@Nonnull Class<?>... includeAll);

    /**
     * Excludes a single class to the filter
     * and returns this.
     *
     * @param exclude a denied class
     * @return this filter
     */
    @Nonnull
    PhaseFilter exclude(@Nonnull Class<?> exclude);

    /**
     * Excludes a collection of classes to the
     * filter and returns this.
     *
     * @param excludeAll a collection of denied classes
     * @return this filter
     */
    @Nonnull
    PhaseFilter exclude(@Nonnull Class<?>... excludeAll);

    /**
     * Returns {@code true} if this phase class
     * can pass through the filter, {code false}
     * if it cannot.
     *
     * @param phaseClass the phase instance class
     * @return the filter result
     */
    boolean accept(@Nonnull Class<?> phaseClass);

}
