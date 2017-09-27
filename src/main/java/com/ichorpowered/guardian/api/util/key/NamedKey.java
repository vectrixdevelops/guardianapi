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
package com.ichorpowered.guardian.api.util.key;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Represents a simple way of acquiring a complex named key.
 */
public class NamedKey {

    private final String key;

    /**
     * Returns a new {@link NamedKey}.
     *
     * @param id the key
     * @return a new named key
     */
    @Nonnull
    public static NamedKey of(@Nonnull String id) {
        return new NamedKey(id);
    }

    private NamedKey(@Nonnull String id) {
        this.key = id;
    }

    /**
     * Returns the key that this represents.
     *
     * @return the key
     */
    @Nonnull
    public String getName() {
        return this.key;
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (object == null) {
            return false;
        }

        if (object instanceof NamedKey) {
            return ((NamedKey) object).getName().equals(this.key);
        }

        return object.equals(this);
    }

}
