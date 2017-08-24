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
package com.ichorpowered.guardian.api.sequence.capture;

import com.ichorpowered.guardian.api.detection.Detection;
import com.ichorpowered.guardian.api.detection.DetectionConfiguration;
import com.ichorpowered.guardian.api.entry.EntityEntry;

/**
 * Represents a system of capturing data
 * in the period of a sequence for a
 * specific purpose to contribute to
 * data analysis.
 *
 * @param <E> the check detections owner type
 * @param <F> the check detections configuration type
 */
public interface Capture<E, F extends DetectionConfiguration> {

    /**
     * Represents a method of starting the data
     * collection process.
     *
     * <p>This should only be called once each time
     * at the beginning of a player sequence.</p>
     *
     * @param entry the entity entry
     * @param captureContainer the capture container
     */
    void start(EntityEntry entry, CaptureContainer captureContainer);

    /**
     * Represents a method of updating the data
     * collection.
     *
     * @param entry the entity entry
     * @param captureContainer the capture container
     */
    void update(EntityEntry entry, CaptureContainer captureContainer);

    /**
     * Represents a method of stopping the data
     * collection process.
     *
     * <p>This should only be called once each time
     * at the end of a player sequence.</p>
     *
     * @param entry the entity entry
     * @param captureContainer the capture container
     */
    void stop(EntityEntry entry, CaptureContainer captureContainer);

    /**
     * Returns the plugin owner of this capture.
     *
     * @return the plugin owner
     */
    E getOwner();

    /**
     * Returns the detection that owns this capture.
     *
     * @return the capture detection
     */
    Detection<E, F> getDetection();

}
