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
package com.ichorpowered.guardianapi.util.key;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Represents a simple way of acquiring a complex named key with
 * a type.
 *
 * @param <T> the type
 */
public class NamedTypeKey<T> {

    private final String key;
    private final Class<T> clazz;

    /**
     * Returns a new {@link NamedTypeKey}.
     *
     * @param id the key
     * @param clazz the type class
     * @param <K> the type
     * @return a new named type key
     */
    @Nonnull
    public static <K> NamedTypeKey<K> of(@Nonnull final String id, @Nonnull final Class<K> clazz) {
        return new NamedTypeKey<>(id, clazz);
    }

    private NamedTypeKey(@Nonnull final String id, @Nonnull final Class<T> clazz) {
        this.key = id;
        this.clazz = clazz;
    }

    /**
     * Returns the key name.
     *
     * @return the key name
     */
    @Nonnull
    public final String getName() {
        return this.key;
    }

    /**
     * Returns the key type class.
     *
     * @return the key type class
     */
    @Nonnull
    public final Class<T> getTypeClass() {
        return this.clazz;
    }

    @Override
    public boolean equals(@Nullable final Object object) {
        if (object == null) {
            return false;
        }

        if (object instanceof NamedTypeKey) {
            return ((NamedTypeKey) object).getName().equals(this.key);
        }

        return object.equals(this);
    }

}
