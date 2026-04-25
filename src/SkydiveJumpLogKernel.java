import components.standard.Standard;

/**
 * Skydive jump log kernel component with primary methods.
 */
public interface SkydiveJumpLogKernel extends Standard<SkydiveJumpLog> {

    /**
     * Records one jump with the given altitude.
     *
     * @param altitude
     *            the jump altitude
     * @updates this
     * @requires altitude > 0
     * @ensures this has one additional jump recorded with altitude
     */
    void recordJump(int altitude);

    /**
     * Reports the number of jumps in {@code this}.
     *
     * @return the number of recorded jumps
     * @ensures jumpCount = number of jumps in this log
     */
    int jumpCount();

    /**
     * Reports the altitude of the most recent jump in {@code this}.
     *
     * @return the last recorded jump altitude
     * @requires jumpCount() > 0
     * @ensures lastJumpAltitude = altitude of the most recent jump
     */
    int lastJumpAltitude();

    /**
     * Reports the total altitude across all jumps in {@code this}.
     *
     * @return the total altitude
     * @ensures totalAltitude = sum of all recorded jump altitudes
     */
    int totalAltitude();
}
