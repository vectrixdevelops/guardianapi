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
package com.ichorpowered.guardianapi.detection.stage;

import com.ichorpowered.guardianapi.detection.stage.model.StageModel;

import java.util.List;
import java.util.Optional;

/**
 * Represents a way to cycle through the
 * {@link Stage}s.
 */
public interface StageCycle {

    // Iteration

    /**
     * Iterates to the next stage in this model
     * or, if this is the last stage in the model
     * goes to the next model and if this is the
     * last model resets, whilst calling the
     * appropriate events.
     *
     * <p>Returns {@code false} when the cycle is
     * complete. Called again will start the cycle
     * from the beginning.</p>
     *
     * @return the cycle state
     */
    boolean next();

    /**
     * Iterates to the next model whilst calling
     * the appropriate events.
     *
     * <p>Returns {@code false} when the cycle is
     * complete. Called again will start the cycle
     * from the beginning.</p>
     *
     * @return the cycle state
     */
    boolean nextModel();

    /**
     * Returns {@code true} if there exists a next
     * stage element.
     *
     * @return the cycle state
     */
    boolean hasNext();

    // Getters

    /**
     * Returns the current model id from the
     * iterator.
     *
     * @return the current stage model id
     */
    Optional<String> getModelId();

    /**
     * Returns the current model from the iterator.
     *
     * @param <T> the stage model type
     * @return the current stage model
     */
    <T extends Stage> Optional<StageModel<T>> getModel();

    /**
     * Returns the current stage id from the model
     * iterator.
     *
     * @return the current stage id
     */
    Optional<String> getStageId();

    /**
     * Returns the current stage from the model
     * iterator.
     *
     * @param <T> the stage type
     * @return the current stage
     */
    <T extends Stage> Optional<T> getStage();

    /**
     * Returns the size of the items in the model
     * iterator.
     *
     * @return the model iterator size
     */
    int size();

    // Container

    /**
     * Returns all the stage model classes that
     * will be iterated in this cycle.
     *
     * @return the iterable stage models
     */
    List<Class<? extends StageModel<?>>> getAll();

    /**
     * Returns the size of the specified models iterator
     * in this cycle.
     *
     * @param stageModel the stage model
     * @return the model iterator size
     */
    int sizeFor(StageModel<?> stageModel);

    /**
     * Returns the size of all models iterators in this
     * cycle.
     *
     * @return the models iterator size total
     */
    int totalSize();

}
