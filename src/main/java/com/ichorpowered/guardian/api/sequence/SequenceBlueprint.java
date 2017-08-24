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
package com.ichorpowered.guardian.api.sequence;

import com.ichorpowered.guardian.api.detection.DetectionConfiguration;
import com.ichorpowered.guardian.api.detection.check.Check;
import com.ichorpowered.guardian.api.entry.EntityEntry;

import javax.annotation.Nonnull;

/**
 * Represents a blueprint for creating a {@link Sequence}
 * for {@link Check}.
 *
 * @param <E> the check detections owner type
 * @param <F> the check detections configuration type
 */
public interface SequenceBlueprint<E, F extends DetectionConfiguration> {

    /**
     * Creates a new {@link Sequence} and passes in the player.
     *
     * @param entry the entity entry
     * @return the sequence
     */
    @Nonnull
    Sequence<E, F> create(EntityEntry entry);

    /**
     * Returns the {@link Check} that owns this {@link Sequence}.
     *
     * @return the check
     */
    @Nonnull
    Check<E, F> getCheck();

}
