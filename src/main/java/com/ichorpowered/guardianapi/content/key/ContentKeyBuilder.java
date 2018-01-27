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
package com.ichorpowered.guardianapi.content.key;

import com.google.common.reflect.TypeToken;
import com.ichorpowered.guardianapi.content.transaction.ContentAssignment;
import com.ichorpowered.guardianapi.util.item.value.BaseValue;

/**
 * Represents a {@link ContentKey} builder.
 *
 * @param <V> the value type
 */
public interface ContentKeyBuilder<V extends BaseValue> {

    /**
     * Returns this builder and sets the
     * {@link ContentKey} id.
     *
     * @param id the content key id
     * @return this builder
     */
    ContentKeyBuilder<V> id(String id);

    /**
     * Returns this builder and sets the
     * {@link ContentKey} name.
     *
     * @param name the content key name
     * @return this builder
     */
    ContentKeyBuilder<V> name(String name);

    /**
     * Returns this builder and sets the
     * {@link ContentKey} value and element type.
     *
     * @param value the content key value type
     * @param elementToken the content key element type
     * @return this builder
     */
    ContentKeyBuilder<V> type(V value, TypeToken<?> elementToken);

    /**
     * Returns this builder and adds a
     * {@link ContentAssignment} for this key.
     *
     * @param assignment the content assignment
     * @return this builder
     */
    ContentKeyBuilder<V> assignment(ContentAssignment<?> assignment);

    /**
     * Returns a built {@link ContentKey} using
     * this builder.
     *
     * @return the new content key
     */
    ContentKey<V> build();

}
