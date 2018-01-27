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
package com.ichorpowered.guardianapi.content;

import com.ichorpowered.guardianapi.content.key.ContentKey;

import java.util.Set;

/**
 * Represents a way to load and save content from
 * an alternative source.
 */
public interface ContentLoader {

    /**
     * Sets a container to load to or
     * save from.
     *
     * @param contentContainer the content container
     */
    void set(ContentContainer contentContainer);

    /**
     * Loads all the possible keys from the
     * {@link ContentContainer} set.
     */
    void acquireAll();

    /**
     * Loads all the keys specified to the
     * {@link ContentContainer} set.
     *
     * @param contentKeys the content keys
     */
    void acquireAll(Set<ContentKey<?>> contentKeys);

    /**
     * Loads a single key specified to the
     * {@link ContentContainer} set.
     *
     * @param contentKey the content key
     */
    void acquireSingle(ContentKey<?> contentKey);

}
