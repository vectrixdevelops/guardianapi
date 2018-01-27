/*
 * MIT License
 *
 * Copyright (c) 2018 Connor Hartley
 * Copyright (c) 2018 SpongePowered
 * Copyright (c) 2018 contributors
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
import com.ichorpowered.guardianapi.detection.stage.StageCycle;
import org.slf4j.Logger;

/**
 * Represents a detection.
 */
public interface Detection {

    /**
     * Returns this detections identifier.
     *
     * @return this detections identifier
     */
    String getId();

    /**
     * Returns this detections name.
     *
     * @return this detections name
     */
    String getName();

    /**
     * Returns this detections logger.
     *
     * @return this detections logger
     */
    Logger getLogger();

    /**
     * Returns this detections stage cycle.
     *
     * @return this detections stage cycle
     */
    StageCycle getStageCycle();

    /**
     * Returns this detections content container.
     *
     * @return this detections content container
     */
    ContentContainer getContentContainer();

    /**
     * Returns this detections content loader.
     *
     * @return this detections content loader
     */
    DetectionContentLoader getContentLoader();

    /**
     * Returns this detections owner plugin.
     *
     * @return this detections owner plugin.
     */
    Object getPlugin();

}
