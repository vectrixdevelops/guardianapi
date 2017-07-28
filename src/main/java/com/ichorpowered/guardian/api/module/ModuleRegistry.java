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
package com.ichorpowered.guardian.api.module;

import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

import javax.annotation.Nonnull;

/**
 * Represents a container for module definitions.
 */
public interface ModuleRegistry {

    /**
     * Registers a module definition by class.
     *
     * @param clazz module class
     */
    void registerModule(@Nonnull Class<?> clazz);

    /**
     * Registers a module definition by class path.
     *
     * @param path module class path
     */
    void registerModule(@Nonnull String path);

    /**
     * Returns a set of module wrappers.
     *
     * @param <T> the module wrapper type
     * @return a set of module wrappers
     */
    <T> Set<T> getModules();

    /**
     * Returns a module definition by class, if it
     * is present.
     *
     * @param clazz the module class
     * @param <M> the module type
     * @return the module if present
     */
    <M> Optional<M> getModule(Class<M> clazz);

    /**
     * Returns a module definition by module id,
     * if it is present.
     *
     * @param moduleId the module id
     * @param <M> the module type
     * @return the module if present
     */
    <M> Optional<M> getModule(String moduleId);

    /**
     * Enables each module in the registry based on
     * the outcome of the {@link Predicate} function
     * result.
     *
     * @param predicate a function to decide the modules enable state
     * @param <M> the module type
     */
    <M> void enableModules(Predicate<M> predicate);

    /**
     * Disables each module in the registry based on
     * the outcome of the {@link Predicate} function
     * result.
     *
     * @param predicate a function to decide the modules disable state
     * @param <M> the module type
     */
    <M> void disableModules(Predicate<M> predicate);

}
