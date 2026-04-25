/**
 * Secondary methods for SkydiveJumpLog.
 */
public abstract class SkydiveJumpLogSecondary implements SkydiveJumpLog {

    /**
     * Number of jumps required for an A-license.
     */
    private static final int A_LICENSE_JUMPS = 25;

    @Override
    public double averageAltitude() {
        assert this.jumpCount() > 0 : "Violation of: jumpCount() > 0";

        double avg = (double) this.totalAltitude() / this.jumpCount();

        return avg;
    }

    @Override
    public boolean hasReachedALicense() {
        boolean reached = this.jumpCount() >= A_LICENSE_JUMPS;

        return reached;
    }

    @Override
    public String toString() {
        String result = "Jumps: " + this.jumpCount() + ", Total altitude: "
                + this.totalAltitude();

        if (this.jumpCount() > 0) {
            result = result + ", Last altitude: " + this.lastJumpAltitude()
                    + ", Highest altitude: " + this.highestAltitude();
        }

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;

        if (obj instanceof SkydiveJumpLog) {
            SkydiveJumpLog other = (SkydiveJumpLog) obj;

            equal = this.jumpCount() == other.jumpCount()
                    && this.totalAltitude() == other.totalAltitude();

            if (equal && this.jumpCount() > 0) {
                equal = this.lastJumpAltitude() == other.lastJumpAltitude()
                        && this.highestAltitude() == other.highestAltitude();
            }
        }

        return equal;
    }
}
