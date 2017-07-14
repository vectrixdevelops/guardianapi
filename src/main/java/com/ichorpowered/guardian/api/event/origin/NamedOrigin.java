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
package com.ichorpowered.guardian.api.event.origin;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class NamedOrigin {

    /**
     * Returns a new {@link NamedOrigin} under the {@code name} and {@code value}
     * parameters.
     *
     * @param name the name of the origin
     * @param value the object
     * @return a new named origin
     */
    public static NamedOrigin of(String name, Object value) {
        return new NamedOrigin(name, value);
    }

    private final String name;
    private final Object object;

    private NamedOrigin(String name, Object value) {
        this.name = name;
        this.object = value;
    }

    /**
     * Gets the name of this {@link NamedOrigin}.
     *
     * @return the name of this origin
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the {@link Object} of this {@link NamedOrigin}.
     *
     * @return the object
     */
    public Object getOriginObject() {
        return this.object;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.name, this.object);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final NamedOrigin other = (NamedOrigin) obj;
        return Objects.equal(this.name, other.name)
                && Objects.equal(this.object, other.object);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", this.name)
                .add("object", this.object)
                .toString();
    }

}
