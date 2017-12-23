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
package com.ichorpowered.guardianapi.content.transaction;

import com.google.common.reflect.TypeToken;

import java.util.Set;

/**
 * Represents a key that can be associated to
 * a content value.
 */
public interface ContentKey {

    /**
     * Returns the content key identifier.
     *
     * @return the content key identifier
     */
    String getId();

    /**
     * Returns the content key name.
     *
     * @return the content key name
     */
    String getName();

    /**
     * Returns the content key element type.
     *
     * @return the content key element type
     */
    TypeToken<?> getElementType();

    /**
     * Returns the set of assignments.
     *
     * @return the set of assignments
     */
    Set<? extends ContentAssignment> getAssignments();

}
