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
package com.ichorpowered.guardian.api.game.model.value.key;

import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

import java.util.Map;

@SuppressWarnings({"unused", "WeakerAccess"})
public final class Keys {

    // Entity Bounds

    public static Key<Double> PLAYER_WIDTH = DummyObjectProvider.createExtendedFor(Key.class, "player_width");

    public static Key<Double> PLAYER_HEIGHT = DummyObjectProvider.createExtendedFor(Key.class, "player_height");

    public static Key<Double> RAY_TRACE_STEP = DummyObjectProvider.createExtendedFor(Key.class, "ray_trace_step");

    public static Key<Integer> JOIN_PING = DummyObjectProvider.createExtendedFor(Key.class, "join_ping");

    public static Key<Double> AVERAGE_PING = DummyObjectProvider.createExtendedFor(Key.class, "average_ping");

    // Horizontal Movement

    public static Key<Double> WALK_SPEED = DummyObjectProvider.createExtendedFor(Key.class, "walk_speed");

    public static Key<Double> SNEAK_SPEED = DummyObjectProvider.createExtendedFor(Key.class, "sneak_speed");

    public static Key<Double> SPRINT_SPEED = DummyObjectProvider.createExtendedFor(Key.class, "sprint_speed");

    public static Key<Double> FLIGHT_SPEED = DummyObjectProvider.createExtendedFor(Key.class, "flight_speed");

    // Vertical Movement

    public static Key<Double> LIFT_SPEED = DummyObjectProvider.createExtendedFor(Key.class, "lift_speed");

    // Material Movement

    public static Key<Map<String, Double>> MATTER_HORIZONTAL_DISTANCE = DummyObjectProvider.createExtendedFor(Key.class, "matter_horizontal_distance");

    public static Key<Map<String, Double>> MATERIAL_HORIZONTAL_DISTANCE = DummyObjectProvider.createExtendedFor(Key.class, "material_horizontal_distance");

    // Potion Movement

    public static Key<Map<String, Double>> EFFECT_HORIZONTAL_DISTANCE = DummyObjectProvider.createExtendedFor(Key.class, "effect_horizontal_distance");

    public static Key<Map<String, Double>> EFFECT_VERTICAL_DISTANCE = DummyObjectProvider.createExtendedFor(Key.class, "effect_vertical_distance");

}
