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
package com.ichorpowered.guardian.api.sequence;

import com.google.gson.reflect.TypeToken;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Map;
import java.util.function.Function;

public interface SequenceContext {

    @NonNull <T> T set(@NonNull String key, @NonNull TypeToken<T> typeToken, @NonNull T element);

    @NonNull <T> T setOnce(@NonNull String key, @NonNull TypeToken<T> typeToken, @NonNull T element);

    @NonNull <T> SequenceContext add(@NonNull String key, @NonNull TypeToken<T> typeToken, @NonNull T element);

    @NonNull <T> SequenceContext transform(@NonNull String key, @NonNull TypeToken<T> typeToken, @NonNull Function<T, T> function);

    @NonNull SequenceContext from(@NonNull SequenceContext sequenceContext);

    @NonNull <T> T get(@NonNull String key, @NonNull TypeToken<T> typeToken);

    @NonNull Map<String, Object> getAll();

    @NonNull <T> T remove(@NonNull String key, @NonNull TypeToken<T> typeToken);

}
