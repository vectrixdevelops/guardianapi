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
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.ichorpowered.guardian.api;

import com.google.inject.assistedinject.Assisted;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Represents the platform version and implementation
 * version that the game is seen to be running.
 */
public interface GuardianPlatform {

    /**
     * May return the running platform name.
     *
     * @return the running platform name
     */
    @NonNull String getPlatformName();

    /**
     * May return the running platform version.
     *
     * @return the running platform version
     */
    @NonNull String getPlatformVersion();

    /**
     * May return the running game version.
     *
     * @return the running game
     */
    @NonNull String getGameVersion();

    /**
     * Returns the implementation version.
     *
     * @return the implementation version
     */
    @NonNull String getVersion();

    /**
     * Returns the release candidate.
     *
     * @return the release candidate
     */
    @NonNull String getReleaseCandidate();

    /**
     * A factory for creating a new {@link GuardianPlatform}.
     */
    interface Factory {

        /**
         * Creates a new {@link GuardianPlatform} with the
         * specified properties.
         *
         * @param platformName the platform name
         * @param platformVersion the platform version
         * @param gameVersion the game version
         * @param version the version
         * @param releaseCandidate the release candidate
         * @return the new guardian platform
         */
        @NonNull GuardianPlatform create(@NonNull @Assisted("platformName") String platformName,
                                         @NonNull @Assisted("platformVersion") String platformVersion,
                                         @NonNull @Assisted("gameVersion") String gameVersion,
                                         @NonNull @Assisted("version") String version,
                                         @NonNull @Assisted("releaseCandidate") String releaseCandidate);

    }

}
