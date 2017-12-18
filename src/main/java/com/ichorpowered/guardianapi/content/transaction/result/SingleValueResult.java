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
package com.ichorpowered.guardianapi.content.transaction.result;

import com.ichorpowered.guardianapi.content.ContentContainer;
import com.ichorpowered.guardianapi.content.transaction.ContentKey;

import java.util.Optional;

/**
 * Represents a single value result.
 *
 * @param <E> the element type
 */
public interface SingleValueResult<E> {

    /**
     * Returns false if this content is not
     * yet stored in the container fully or
     * the container is only a virtual one.
     *
     * @return the storage dirtiness
     */
    boolean isDirty();

    /**
     * Returns the key used with this element
     * content.
     *
     * @return the key
     */
    ContentKey getKey();

    /**
     * Returns the element used with this key
     * content.
     *
     * @return the value
     */
    Optional<E> getElement();

    /**
     * Returns the original content container
     * that this key is used for if there is one.
     *
     * @return the original content container
     */
    Optional<ContentContainer> getOriginalContainer();

}
