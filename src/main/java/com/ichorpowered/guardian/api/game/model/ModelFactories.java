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
package com.ichorpowered.guardian.api.game.model;

import com.ichorpowered.guardian.api.game.model.value.GameValue;
import com.ichorpowered.guardian.api.game.model.value.key.GameKey;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Optional;

public interface ModelFactories {

    /**
     * Creates a new physical {@link GameValue} with the
     * specified properties.
     *
     * @param component the owning component
     * @param gameKey the value gameKey
     * @param <E> the value type
     * @return the new value, if present
     */
    @NonNull <E> Optional<GameValue<E>> createValue(@NonNull Component component,
                                                    @NonNull GameKey<E> gameKey);

    @NonNull <E> Optional<GameValue<E>> createValue(@NonNull Component component,
                                                    @NonNull GameKey<E> gameKey,
                                                    @NonNull E element);

}
