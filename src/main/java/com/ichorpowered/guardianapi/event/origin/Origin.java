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
package com.ichorpowered.guardianapi.event.origin;

import com.abilityapi.sequenceapi.SequenceContext;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.StringJoiner;

import javax.annotation.Nullable;

/**
 * Represents the origin or initiator of an event.
 *
 * <p>This class is heavily based off the Sponge
 * Powered cause class and was designed to do the
 * same thing, but in an abstracted way.</p>
 */
public final class Origin {

    /**
     * Creates a new {@link Builder} to make a new {@link Origin}. Note that the
     * builder requires all objects to be named appropriately and does not
     * accept duplicate names.
     *
     * @return the builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Merges a {@link SequenceContext} into a new {@link Origin}.
     *
     * @param sequenceContext the sequence context
     * @return the builder
     */
    public static Builder merge(SequenceContext sequenceContext) {
        final Origin.Builder origin = Origin.builder();

        origin.source(sequenceContext.getSource());
        origin.owner(sequenceContext.getOwner());

        return origin;
    }

    /**
     * Creates a new {@link Builder} to make a new {@link Origin} with the
     * desired {@link Object} as the root of the cause. Note that the
     * builder requires all objects to be named appropriately and does not
     * accept duplicate names.
     *
     * @param value the value
     * @return the builder
     */
    public static Builder source(Object value) {
        return builder().source(value);
    }

    /**
     * Creates a new {@link Origin} with the provided {@code key} and {@code value}
     * parameters. Note that this is similar to using a {@link #builder()} and
     * chaining {@link Builder#named(String, Object)} consistently.
     *
     * @param key the key
     * @param value the value
     * @return the builder
     */
    public static Origin of(String key, Object value) {
        return new Origin(new NamedOrigin[] { NamedOrigin.of(key, value) });
    }

    /**
     * Creates a single object contained {@link Origin} with the provided
     * {@link NamedOrigin} as the source.
     *
     * @param origin the object of the origin
     * @return the single object origin
     */
    public static Origin of(NamedOrigin origin) {
        return new Origin(new NamedOrigin[] { origin });
    }

    final Object[] origin;
    final String[] names;

    private Map<String, Object> namedObjectMap;
    private ImmutableList<Object> immutableOrigins;

    Origin(NamedOrigin[] origins) {
        final Object[] objects = new Object[origins.length];
        final String[] names = new String[origins.length];
        for (int i = 0; i < origins.length; i++) {
            NamedOrigin anOrigin = origins[i];
            objects[i] = anOrigin.getOriginObject();
            names[i] = anOrigin.getName();
        }
        this.origin = objects;
        this.names = names;
    }

    /**
     * Returns the source {@link Object} of this origin.
     *
     * @return the source object
     */
    public Object getSource() {
        return this.origin[0];
    }

    /**
     * Gets the first <code>T</code> object of this {@link Origin}, if
     * available.
     *
     * @param target the class of the target type
     * @param <T> the type of object being queried for
     * @return the first type of the type, if available
     */
    public <T> Optional<T> first(Class<T> target) {
        for (Object anOrigin : this.origin) {
            if (target.isInstance(anOrigin)) {
                return Optional.of((T) anOrigin);
            }
        }
        return Optional.empty();
    }

    /**
     * Gets the last object instance of the {@link Class} of type
     * <code>T</code>.
     *
     * @param target the class of the target type
     * @param <T> the type of object being queried for
     * @return the last type of the type, if available
     */
    public <T> Optional<T> last(Class<T> target) {
        for (int i = this.origin.length - 1; i >= 0; i--) {
            if (target.isInstance(this.origin[i])) {
                return Optional.of((T) this.origin[i]);
            }
        }
        return Optional.empty();
    }

    /**
     * Gets the object associated with the provided name. Note that
     * all objects in a cause are uniquely named.
     *
     * @param named the name associated with the object cause
     * @param expected the expected class type of the cause object
     * @param <T> the type of the object expected
     * @return the object, if the type is correct and the name was associated
     */
    public <T> Optional<T> get(String named, Class<T> expected) {
        for (int i = 0; i < this.names.length; i++) {
            if (this.names[i].equalsIgnoreCase(named)) {
                final Object object = this.origin[i];
                if (expected.isInstance(object)) {
                    return Optional.of((T) object);
                }
                return Optional.empty();
            }
        }
        return Optional.empty();
    }

    /**
     * Returns whether the target class matches any object of this {@link Origin}.
     *
     * @param target the class of the target type
     * @return true if found, false otherwise
     */
    public boolean containsType(Class<?> target) {
        for (Object anOrigin : this.origin) {
            if (target.isInstance(anOrigin)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Checks if this cause contains of any of the provided {@link Object}. This
     * is the equivalent to checking based on {@link #equals(Object)} for each
     * object in this cause.
     *
     * @param object the object to check if it is contained
     * @return true if the object is contained within this cause
     */
    public boolean contains(Object object) {
        for (Object anOrigin : this.origin) {
            if (anOrigin.equals(object)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns whether there are any objects associated with the provided name.
     *
     * @param named the name associated with a cause object
     * @return true if found, false otherwise
     */
    public boolean containsNamed(String named) {
        for (String name : this.names) {
            if (name.equalsIgnoreCase(named)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (object instanceof Origin) {
            Origin cause = ((Origin) object);
            return Arrays.equals(this.origin, cause.origin);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.origin);
    }

    @Override
    public String toString() {
        String causeString = "Origin[";
        StringJoiner joiner = new StringJoiner(", ");
        for (int i = 0; i < this.origin.length; i++) {
            joiner.add("{Name=" + this.names[i] + ", Object={" + this.origin[i].toString() + "}}");
        }
        return causeString + joiner.toString() + "]";
    }

    public static class Builder {

        List<NamedOrigin> origins = new ArrayList<>();
        Set<String> namesUsed = new HashSet<>();

        Builder() {}

        Builder source(Object value) {
            this.origins.add(NamedOrigin.of("SOURCE", value));
            this.namesUsed.add("SOURCE");
            return this;
        }

        /**
         * Adds the desired {@link Object} with the {@link NamedOrigin} of
         * "owner".
         *
         * @param owner the object to be considered the "owner"
         * @return this builder
         */
        public Builder owner(Object owner) {
            if (!this.namesUsed.contains("OWNER")) {
                this.origins.add(NamedOrigin.of("OWNER", owner));
                this.namesUsed.add("OWNER");
            }
            return this;
        }

        /**
         * Adds the desired {@link NamedOrigin} with validation that the
         * {@link NamedOrigin#getName()} is not already used in this builder.
         *
         * @param origin the named object
         * @return this builder
         */
        public Builder named(NamedOrigin origin) {
            if (!this.namesUsed.contains(origin.getName())) {
                this.origins.add(origin);
                this.namesUsed.add(origin.getName());
            }
            return this;
        }

        /**
         * Adds the desired {@link NamedOrigin} with validation that the
         * {@link NamedOrigin#getName()} is not already used in this builder.
         *
         * @param name the named object
         * @param value the object
         * @return this builder
         */
        public Builder named(String name, Object value) {
            if (!this.namesUsed.contains(name)) {
                this.origins.add(NamedOrigin.of(name, value));
                this.namesUsed.add(name);
            }
            return this;
        }

        /**
         * Constructs a new {@link Origin} with all previously added
         * {@link NamedOrigin} objects.
         *
         * @return the newly constructed cause
         */
        public Origin build() {
            return new Origin(this.origins.toArray(new NamedOrigin[this.origins.size()]));
        }

        /**
         * Clears the {@link NamedOrigin}s from this {@link Builder}.
         *
         * @return this builder
         */
        public Builder reset() {
            this.origins.clear();
            this.namesUsed.clear();
            return this;
        }

    }

}
