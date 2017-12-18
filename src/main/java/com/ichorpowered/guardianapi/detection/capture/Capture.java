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
package com.ichorpowered.guardianapi.detection.capture;

import com.ichorpowered.guardianapi.detection.Detection;
import com.ichorpowered.guardianapi.entry.entity.EntityEntry;

import javax.annotation.Nonnull;

/**
 * Represents a system of capturing data
 * in the period of a sequence for a
 * specific purpose to contribute to
 * data analysis.
 */
public interface Capture {

    /**
     * Represents a method of updating the data
     * collection.
     *
     * @param entry the entity entry
     * @param captureContainer the capture container
     */
    void update(@Nonnull EntityEntry entry, @Nonnull CaptureContainer captureContainer);

    /**
     * Returns the detection that owns this capture.
     *
     * @return the capture detection
     */
    @Nonnull
    Detection getDetection();

    /**
     * Returns the owning plugin of this capture.
     *
     * @return the owning plugin
     */
    @Nonnull
    Object getPlugin();

}
