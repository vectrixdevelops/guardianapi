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
package com.ichorpowered.guardian.api.game.resource;

import com.ichorpowered.guardian.api.game.GameReference;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Optional;

/**
 * Represents a container of grouped players
 * that are automatically assigned on addition.
 */
public interface PlayerResource {

    @NonNull GameReference<?> add(@NonNull GameReference<?> reference);

    @NonNull Optional<GameReference<?>> remove(@NonNull String referenceId);

    @NonNull Optional<GameReference<?>> get(@NonNull String referenceId);

    /**
     * Removes all references.
     */
    void clear();

    /**
     * A factory for creating a new {@link PlayerResource}.
     */
    interface Factory {

        /**
         * Create a new {@link PlayerResource} with the specified
         * properties.
         *
         * @return the new player resource
         */
        @NonNull PlayerResource create();

    }

}
