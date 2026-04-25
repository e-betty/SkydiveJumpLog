/**
 * SkydiveJumpLogKernel enhanced with secondary methods.
 */
public interface SkydiveJumpLog extends SkydiveJumpLogKernel {

    /**
     * Reports average jump altitude.
     *
     * @return average altitude
     * @requires jumpCount() > 0
     * @ensures averageAltitude = totalAltitude() / jumpCount()
     */
    double averageAltitude();

    /**
     * Reports whether the A-license milestone has been reached.
     *
     * @return true iff this log has at least 25 jumps
     * @ensures hasReachedALicense = (jumpCount() >= 25)
     */
    boolean hasReachedALicense();
}
