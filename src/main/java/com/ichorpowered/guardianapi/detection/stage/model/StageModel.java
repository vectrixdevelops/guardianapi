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

import java.util.Optional;

/**
 * Represents a particular model a stage takes part
 * in. Stages can be registered and retrieved from here.
 *
 * @param <T> the stage model type
 */
public interface StageModel<T extends Stage> extends Iterable<T> {

    /**
     * Registers a stage into this model.
     *
     * @param stage the stage
     * @return this model
     */
    StageModel register(T stage);

    /**
     * Unregisters a stage from this model.
     *
     * @param stageClass the stage class
     * @return this model
     */
    StageModel unregister(Class<? extends T> stageClass);

    /**
     * Unregisters a stage from this model.
     *
     * @param stage the stage
     * @return this model
     */
    StageModel unregister(T stage);

    /**
     * Returns an {@link Optional} that may contain
     * the {@link Stage} for the specified stage class.
     *
     * @param stageClass the stage class
     * @return the optionally present stage
     */
    Optional<? extends T> get(Class<? extends T> stageClass);

}
