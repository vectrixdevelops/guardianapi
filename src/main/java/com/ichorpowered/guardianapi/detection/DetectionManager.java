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
package com.ichorpowered.guardianapi.detection;

import com.ichorpowered.guardianapi.detection.stage.model.StageModel;

import java.util.Optional;

/**
 * Represents a manager for detections.
 */
public interface DetectionManager {

    /**
     * Provides a detection instance for the submitted
     * detection class.
     *
     * @param detectionClass the detection class
     * @param detection the detection
     * @return this detection manager
     */
    DetectionManager provideDetection(Class<? extends Detection> detectionClass, Detection detection);

    /**
     * Provides a stage model instance for its class.
     *
     * @param stageModelClass the stage mode class
     * @param stageModel the stage model
     * @return this detection manager
     */
    DetectionManager provideStageModel(Class<? extends StageModel> stageModelClass, StageModel stageModel);

    /**
     * Returns a {@link DetectionBuilder} that when
     * submitted provides the results to the registered
     * detection.
     *
     * @param detectionClass the detection class
     * @return a detection builder
     */
    Optional<DetectionBuilder> provider(Class<? extends Detection> detectionClass);

    /**
     * Returns an {@link Optional} that may contain
     * a detection represented by the identifier specified.
     *
     * @param id the detection identifier
     * @return the detection if present
     */
    Optional<? extends Detection> getDetection(String id);

    /**
     * Returns an {@link Optional} that may contain
     * a detection represented by the class specified.
     *
     * @param detectionClass the detection class
     * @return the detection if present
     */
    Optional<? extends Detection> getDetection(Class<? extends Detection> detectionClass);

    /**
     * Returns an {@link Optional} that may contain
     * a stage model represented by the identifier specified.
     *
     * @param id the stage model identifier
     * @return the stage model if present
     */
    Optional<? extends StageModel> getStageModel(String id);

    /**
     * Returns an {@link Optional} that may contain
     * a stage model represented by the class specified.
     *
     * @param stageModelClass the stage model class
     * @return the stage model if present
     */
    Optional<? extends StageModel> getStageModel(Class<? extends StageModel> stageModelClass);

}
