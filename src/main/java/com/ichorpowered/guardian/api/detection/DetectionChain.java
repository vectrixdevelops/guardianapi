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
package com.ichorpowered.guardian.api.detection;

import java.util.List;

import javax.annotation.Nonnull;

/**
 * Represents the chain of processes to run through
 * for each detection.
 */
public interface DetectionChain {

    /**
     * Adds a process to the detection chain.
     *
     * @param pluginContainer the plugin that adds this process
     * @param processType the process type
     * @param clazz the process class
     * @param <C> the plugin type
     */
    <C> void add(@Nonnull C pluginContainer, @Nonnull ProcessType processType,
                 @Nonnull Class<?> clazz);

    /**
     * Gets a list of processes from the detection
     * chain.
     *
     * @param processType the process type
     * @param <T> the plugin type
     * @return the process list
     */
    <T> List<Class<? extends T>> get(@Nonnull ProcessType processType);

    enum ProcessType {
        CHECK,
        HEURISTIC,
        PENALTY
    }

}
