/**
 * SkydiveJumpLog enhanced with secondary methods.
 */
public interface SkydiveJumpLog extends SkydiveJumpLogKernel {

    /**
     * Returns average altitude.
     *
     * @return average altitude
     */
    double averageAltitude();

    /**
     * Returns highest altitude.
     *
     * @return highest altitude
     */
    int highestAltitude();

    /**
     * Returns whether A-license is reached.
     *
     * @return true if at least 25 jumps
     */
    boolean hasReachedALicense();
}
