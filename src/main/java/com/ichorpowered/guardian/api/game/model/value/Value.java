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
package com.ichorpowered.guardian.api.game.model.value;

import com.google.inject.assistedinject.Assisted;
import com.ichorpowered.guardian.api.game.model.value.key.Key;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Optional;
import java.util.function.Function;

/**
 * Represents a containable value.
 *
 * @param <E> the element type
 */
public interface Value<E> {

    @NonNull Key<E> getKey();

    /**
     * Returns the contained value. If that value is not
     * present, the {@link Value#getDefault()} value is returned.
     *
     * @return the contained value
     */
    @NonNull E get();

    /**
     * Returns the default value.
     *
     * @return the default value
     */
    @NonNull E getDefault();

    /**
     * Returns the directly contained value. If that value is not
     * present, it will return an {@link Optional#empty()}.
     *
     * @return the directly contained value
     */
    @NonNull Optional<E> getDirect();

    /**
     * Returns true if the value is presumed to exist.
     *
     * @return true if the value is contained
     */
    @NonNull boolean isEmpty();

    /**
     * Sets the underlying value to the provided {@code value}.
     *
     * @param value the value to add
     * @return this value container
     */
    @NonNull Value<E> set(@NonNull E value);

    /**
     * Attempts to transform the underlying value based on the provided
     * {@link Function} such that the result of {@link Function#apply(Object)}
     * will replace the underlying value.
     *
     * @param function the function to apply on the existing value
     * @return this value container
     */
    @NonNull Value<E> transform(@NonNull Function<E, E> function);

    /**
     * A factory for creating a new {@link Value}.
     */
    interface Factory {

        /**
         * Creates a new {@link Value} with the specified
         * properties.
         *
         *
         * @return the new value
         */
        @NonNull Value create(@NonNull @Assisted("key") Key key,
                              @NonNull @Assisted("defaultElement") Object defaultElement);

    }

}
