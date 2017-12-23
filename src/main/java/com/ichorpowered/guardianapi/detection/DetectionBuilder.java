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

import com.ichorpowered.guardianapi.content.ContentContainer;
import com.ichorpowered.guardianapi.detection.stage.Stage;
import com.ichorpowered.guardianapi.detection.stage.model.StageModel;
import com.ichorpowered.guardianapi.detection.stage.model.StageModelArchetype;
import com.ichorpowered.guardianapi.detection.stage.model.StageModelBuilder;

/**
 * Represents the detection builder.
 */
public interface DetectionBuilder {

    /**
     * Returns this builder and sets the
     * detection identifier.
     *
     * @param id the detection identifier
     * @return this builder
     */
    DetectionBuilder id(String id);

    /**
     * Returns this builder and sets the
     * detection name.
     *
     * @param name the detection name
     * @return this builder
     */
    DetectionBuilder name(String name);

    /**
     * Returns a {@link StageModelBuilder}
     * and sets its submission to act on
     * in the order this method was called in.
     *
     * @param stageModelClass the stage model class
     * @param <T> the stage model type
     * @return a stage model builder
     */
    <T extends Stage> StageModelBuilder<T> stage(Class<? extends StageModel<T>> stageModelClass);

    /**
     * Returns this builder and adds a
     * {@link StageModel} in the order this
     * method was called in.
     *
     * @param stageModelArchetype the stage model archetype
     * @param <T> the stage model type
     * @return this builder
     */
    <T extends Stage> DetectionBuilder stage(StageModelArchetype<T> stageModelArchetype);

    /**
     * Returns this builder and sets the
     * detection content loader.
     *
     * @param contentLoader the detection content loader
     * @return this builder
     */
    DetectionBuilder contentLoader(DetectionContentLoader contentLoader);

    /**
     * Returns this builder and sets the
     * detection content container.
     *
     * @param contentContainer the detection content container
     * @return this builder
     */
    DetectionBuilder content(ContentContainer contentContainer);

    /**
     * Submits this builder to the {@link DetectionManager}
     * and returns it.
     *
     * @param plugin the owning plugin
     * @return the detection manager
     */
    DetectionManager submit(Object plugin);

}
