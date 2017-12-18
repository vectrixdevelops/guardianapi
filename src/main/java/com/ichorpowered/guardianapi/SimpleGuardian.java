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
package com.ichorpowered.guardianapi;

import com.ichorpowered.guardianapi.util.ImplementationException;

/**
 * Represents the methods that are accessible during
 * any state.
 */
public class SimpleGuardian {

    private static Object INSTANCE;

    /**
     * Sets the instance of the implementation.
     *
     * @param instance the implementation
     * @param <T> the implementation type
     */
    public static <T extends Guardian> void setInstance(final T instance) {
        INSTANCE = instance;
    }

    /**
     * Returns the instance of the implementation from
     * a class if present.
     *
     * @param <T> the implementation class type
     * @return possible implementation instance
     * @throws ImplementationException possible exception
     */
    public static <T extends Guardian> T getInstance() throws ImplementationException {
        if (INSTANCE == null) {
            throw new ImplementationException("Instance has not been initialized yet!");
        } else if (!Guardian.class.isAssignableFrom(INSTANCE.getClass())) {
            throw new ImplementationException("Instance is invalid!");
        }

        return (T) INSTANCE;
    }

}
