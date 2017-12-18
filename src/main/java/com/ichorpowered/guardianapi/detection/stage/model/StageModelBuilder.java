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

import com.ichorpowered.guardianapi.detection.DetectionBuilder;
import com.ichorpowered.guardianapi.detection.stage.Stage;

import java.util.function.Predicate;

/**
 * Represents a builder for setting stage iterator options.
 *
 * @param <T> the stage type
 */
public interface StageModelBuilder<T extends Stage> {

    /**
     * Includes the {@link Stage} class to be used
     * in the order this method is called.
     *
     * @param stageClass the stage class
     * @return this stage model builder
     */
    StageModelBuilder<T> include(Class<? extends T> stageClass);

    /**
     * Excludes the {@link Stage} class from being
     * used.
     *
     * @param stageClass the stage class
     * @return this stage model builder
     */
    StageModelBuilder<T> exclude(Class<? extends T> stageClass);

    /**
     * Filters the {@link Stage}s in the
     * {@link StageModel}s and if the predicate
     * returns true, allows them to pass through.
     *
     * @param stagePredicate the stage predicate
     * @return this stage model builder
     */
    StageModelBuilder<T> filter(Predicate<T> stagePredicate);

    /**
     * Sets the minimum amount of stages that will
     * be executed.
     *
     * @param minimum the minimum amount of executable stages
     * @return this stage model builder
     */
    StageModelBuilder<T> min(int minimum);

    /**
     * Sets the maximum amount of stages that will
     * be executed.
     *
     * @param maximum the maximum amount of executable stages
     * @return this stage model builder
     */
    StageModelBuilder<T> max(int maximum);

    /**
     * Appends this stage model builder to the
     * {@link DetectionBuilder} and returns it.
     *
     * @return the detection builder
     */
    DetectionBuilder append();

}
