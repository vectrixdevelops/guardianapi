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

import com.ichorpowered.guardian.api.util.ImplementationException;

/**
 * Represents a way to manage sequences.
 *
 * @param <P> the player type
 * @param <T> the event type
 */
public interface SequenceManager<P, T> {

    /**
     * Invokes a sequence check passing on the
     * player and event.
     *
     * @param player the player
     * @param event the event
     * @throws ImplementationException if invalid arguments are used
     */
    void invoke(P player, T event) throws ImplementationException;

    /**
     * Cleans up discontinued sequences.
     *
     * <p>If set to {@code force}, it will remove
     * all the existing sequences regardless whether
     * the sequences have stopped.</p>
     *
     * @param force the option to forcefully remove
     */
    void clean(boolean force);

    /**
     * Cleans up discontinued sequences for a player.
     *
     * <p>If set to {@code force}, it will remove
     * all the sequences from the player regardless
     * whether the sequences have stopped.</p>
     *
     * @param player the player
     * @param force the option to forcefully remove
     * @throws ImplementationException if invalid arguments are used
     */
    void clean(P player, boolean force) throws ImplementationException;

}
