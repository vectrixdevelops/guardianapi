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
package com.ichorpowered.guardianapi.content;

import com.ichorpowered.guardianapi.content.transaction.ContentKey;

import java.util.List;
import java.util.Map;

public class ContentKeys {

    /**
     * The {@link ContentKey} that represents an
     * undefined or empty value.
     */
    public static ContentKey<?> UNDEFINED;

    ///////    Check     ///////

    /**
     * The {@link ContentKey} that represents the
     * analysis time for a detection check.
     */
    public static ContentKey<Double> ANALYSIS_TIME;

    /**
     * The {@link ContentKey} that represents the
     * occasional requirement for a check to have a
     * base analysis value.
     */
    public static ContentKey<Double> ANALYSIS_INTERCEPT;

    /**
     * The {@link ContentKey} that represents the
     * analysis minimum tick rate.
     */
    public static ContentKey<Double> ANALYSIS_MINIMUM_TICK;

    /**
     * The {@link ContentKey} that represents the
     * analysis maximum tick rate.
     */
    public static ContentKey<Double> ANALYSIS_MAXIMUM_TICK;

    ///////    Capture   ///////

    // **   Control Movement Keys   **

    /**
     * The {@link ContentKey} that represents lift
     * movement speed.
     */
    public static ContentKey<Double> MOVEMENT_LIFT_SPEED;

    /**
     * The {@link ContentKey} that represents sneak
     * movement speed.
     */
    public static ContentKey<Double> MOVEMENT_SNEAK_SPEED;

    /**
     * The {@link ContentKey} that represents walk
     * movement speed.
     */
    public static ContentKey<Double> MOVEMENT_WALK_SPEED;

    /**
     * The {@link ContentKey} that represents sprint
     * movement speed.
     */
    public static ContentKey<Double> MOVEMENT_SPRINT_SPEED;

    /**
     * The {@link ContentKey} that represents fly
     * movement speed.
     */
    public static ContentKey<Double> MOVEMENT_FLY_SPEED;

    // **    Material Keys    **

    /**
     * The {@link ContentKey} that represents
     * material types that modify movement speed.
     *
     * <p>e.g
     *      grass: 1.052
     * </p>
     */
    public static ContentKey<Map> MOVEMENT_MATERIAL_SPEED;

    /**
     * The {@link ContentKey} that represents
     * materials matter type that modify movement speed.
     *
     * <p>Matter speed values can be overridden by specific
     * materials in the material node.</p>
     *
     * <p>e.g
     *      gas: 1.065
     * </p>
     */
    public static ContentKey<Map> MOVEMENT_MATTER_SPEED;

    // **    Effect Movement Keys    **

    /**
     * The {@link ContentKey} that represents
     * effects that modify movement speed and their
     * modifier values.
     *
     * <p>e.g
     *      speed: 0.1,
     *      jump: 0.02
     * </p>
     */
    public static ContentKey<Map> MOVEMENT_EFFECT_SPEED;

    /**
     * The {@link ContentKey} that represents
     * effects that modify movement lift and their
     * modifier values.
     *
     * <p>e.g
     *      jump: 3.18
     * </p>
     */
    public static ContentKey<Map> MOVEMENT_EFFECT_LIFT;

    // **    Player Model    **

    /**
     * The {@link ContentKey} that represents
     * the players bounding box width.
     */
    public static ContentKey<Double> BOX_PLAYER_WIDTH;

    /**
     * The {@link ContentKey} that represents
     * the players bounding box height.
     */
    public static ContentKey<Double> BOX_PLAYER_HEIGHT;

    /**
     * The {@link ContentKey} that represents
     * a value that can be added to the height
     * and width of the players bounding box to
     * be used in some detections where their may
     * need to be a less precise value.
     */
    public static ContentKey<Double> BOX_PLAYER_SAFETY;

    // **    Blacklist    **

    /**
     * The {@link ContentKey} that represents
     * a list of blacklisted equipment that will
     * block certain detection sequences from running
     * for players found with it equipped.
     */
    public static ContentKey<List> EQUIPMENT_BLACKLIST;

    /**
     * The {@link ContentKey} that represents
     * a list of blacklisted items that will
     * block certain detection sequences from running
     * for players found with it in their inventory.
     */
    public static ContentKey<List> ITEM_BLACKLIST;

}
