package com.ichorpowered.guardianapi.detection;

/**
 * Represents a {@link Detection} that is loaded as a module.
 */
public interface DetectionModule extends Detection {

    /**
     * Called after the detection is constructed.
     */
    void onConstruction();

    /**
     * Called before the detection is deconstructed.
     */
    void onDeconstruction();

}
