import components.standard.Standard;

/**
 * Kernel interface for SkydiveJumpLog.
 */
public interface SkydiveJumpLogKernel extends Standard<SkydiveJumpLog> {

    /**
     * Records one jump.
     *
     * @param altitude
     *            the jump altitude
     * @updates this
     * @requires altitude > 0
     * @ensures one jump with the given altitude is added to this log
     */
    void recordJump(int altitude);

    /**
     * Reports the number of jumps.
     *
     * @return number of jumps
     * @ensures jumpCount = number of jumps in this log
     */
    int jumpCount();

    /**
     * Reports the last jump altitude.
     *
     * @return last jump altitude
     * @requires jumpCount() > 0
     * @ensures lastJumpAltitude = altitude of most recent jump
     */
    int lastJumpAltitude();

    /**
     * Reports total altitude.
     *
     * @return total altitude
     * @ensures totalAltitude = sum of all jump altitudes
     */
    int totalAltitude();

    /**
     * Reports highest jump altitude.
     *
     * @return highest altitude
     * @requires jumpCount() > 0
     * @ensures highestAltitude = highest altitude recorded
     */
    int highestAltitude();
}
