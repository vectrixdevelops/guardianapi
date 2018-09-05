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
public final class GameKeys {

    // Entity Bounds

    public static GameKey<Double> PLAYER_WIDTH = DummyObjectProvider.createExtendedFor(GameKey.class, "player_width");

    public static GameKey<Double> PLAYER_HEIGHT = DummyObjectProvider.createExtendedFor(GameKey.class, "player_height");

    public static GameKey<Double> RAY_TRACE_STEP = DummyObjectProvider.createExtendedFor(GameKey.class, "ray_trace_step");

    public static GameKey<Integer> JOIN_PING = DummyObjectProvider.createExtendedFor(GameKey.class, "join_ping");

    public static GameKey<Double> AVERAGE_PING = DummyObjectProvider.createExtendedFor(GameKey.class, "average_ping");

    // Horizontal Movement

    public static GameKey<Double> WALK_SPEED = DummyObjectProvider.createExtendedFor(GameKey.class, "walk_speed");

    public static GameKey<Double> SNEAK_SPEED = DummyObjectProvider.createExtendedFor(GameKey.class, "sneak_speed");

    public static GameKey<Double> SPRINT_SPEED = DummyObjectProvider.createExtendedFor(GameKey.class, "sprint_speed");

    public static GameKey<Double> FLIGHT_SPEED = DummyObjectProvider.createExtendedFor(GameKey.class, "flight_speed");

    public static GameKey<Double> SPECTATOR_SPEED = DummyObjectProvider.createExtendedFor(GameKey.class, "spectator_speed");

    // Vertical Movement

    public static GameKey<Double> LIFT_SPEED = DummyObjectProvider.createExtendedFor(GameKey.class, "lift_speed");

    // Material Movement

    public static GameKey<Map<String, Double>> MATTER_HORIZONTAL_DISTANCE = DummyObjectProvider.createExtendedFor(GameKey.class, "matter_horizontal_distance");

    public static GameKey<Map<String, Double>> MATERIAL_HORIZONTAL_DISTANCE = DummyObjectProvider.createExtendedFor(GameKey.class, "material_horizontal_distance");

    // Potion Movement

    public static GameKey<Map<String, Double>> EFFECT_HORIZONTAL_DISTANCE = DummyObjectProvider.createExtendedFor(GameKey.class, "effect_horizontal_distance");

    public static GameKey<Map<String, Double>> EFFECT_VERTICAL_DISTANCE = DummyObjectProvider.createExtendedFor(GameKey.class, "effect_vertical_distance");

}
