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
     */
    void recordJump(int altitude);

    /**
     * Returns number of jumps.
     *
     * @return number of jumps
     */
    int jumpCount();

    /**
     * Returns last jump altitude.
     *
     * @return last jump altitude
     */
    int lastJumpAltitude();

    /**
     * Returns total altitude.
     *
     * @return total altitude
     */
    int totalAltitude();
}