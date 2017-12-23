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
package com.ichorpowered.guardianapi.detection.stage.model;

import com.ichorpowered.guardianapi.detection.stage.Stage;

import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

/**
 * Represents a submission from the {@link StageModelBuilder}.
 *
 * @param <T> the stage model type
 */
public interface StageModelArchetype<T extends Stage> {

    /**
     * Returns the {@link StageModel} class this
     * archetype represents.
     *
     * @return the stage model class
     */
    Class<? extends StageModel<T>> getModelClass();

    /**
     * Returns the model filter containing the
     * includes, excludes and filters.
     *
     * @return the model filter
     */
    Predicate<T> getModelFilter();

    /**
     * Returns the included {@link Stage}s.
     *
     * @return the included stages
     */
    List<Class<? extends T>> getIncludes();

    /**
     * Returns the excluded {@link Stage}s.
     *
     * @return the excluded stages
     */
    Set<Class<? extends T>> getExcludes();

    /**
     * Returns the {@link Predicate} filters.
     *
     * @return the filters
     */
    Set<Predicate<T>> getFilters();

    /**
     * Returns the minimum {@link Stage}s that
     * will be executed.
     *
     * @return the minimum stages
     */
    int getMinimum();

    /**
     * Returns the maximum {@link Stage}s that
     * will be executed.
     *
     * @return the maximum stages
     */
    int getMaximum();

}
