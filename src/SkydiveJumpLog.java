/**
 * {@code SkydiveJumpLogKernel} enhanced with secondary methods.
 */
public interface SkydiveJumpLog extends SkydiveJumpLogKernel {

    /**
     * Reports the average altitude across all jumps in {@code this}.
     *
     * @return the average altitude
     * @requires jumpCount() > 0
     * @ensures averageAltitude = totalAltitude() / jumpCount()
     */
    double averageAltitude();

    /**
     * Reports the highest altitude recorded in {@code this}.
     *
     * @return the highest recorded altitude
     * @requires jumpCount() > 0
     * @ensures highestAltitude is the greatest altitude recorded in this log
     */
    int highestAltitude();

    /**
     * Reports whether {@code this} has reached the A-license jump milestone.
     *
     * @return true iff this log has at least 25 jumps
     * @ensures hasReachedALicense = (jumpCount() >= 25)
     */
    boolean hasReachedALicense();
}
