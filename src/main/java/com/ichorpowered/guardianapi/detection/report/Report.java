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
package com.ichorpowered.guardianapi.detection.report;

import com.ichorpowered.guardianapi.event.origin.Origin;

import java.util.Set;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Represents a brief report created by a
 * single operation that can be provided
 * as evidence to the final summary.
 */
public interface Report {

    /**
     * Inserts the property into this report.
     *
     * @param key the property key
     * @param value the property value
     * @param <T> the property type
     */
    <T> void put(@Nonnull String key, @Nullable T value);

    /**
     * Returns the property that is represented by its key.
     *
     * @param key the property key
     * @param <T> the property type
     * @return the property
     * @throws IllegalArgumentException if the specified arguments are not of the correct type
     */
    @Nullable
    <T> T get(@Nonnull String key) throws IllegalArgumentException;

    /**
     * Returns a set of keys contained inside this report.
     *
     * @return a set of property keys
     */
    @Nonnull
    Set<String> keySet();

    /**
     * Returns the {@link Origin} of this {@link Report}.
     *
     * @return the summary origin
     */
    @Nonnull
    Origin getOrigin();

}
