/**
 * {@code SkydiveJumpLogKernel} enhanced with secondary methods.
 */
public abstract class SkydiveJumpLogSecondary implements SkydiveJumpLog {

    @Override
    public double averageAltitude() {
        assert this.jumpCount() > 0 : "Violation of: jumpCount() > 0";
        return (double) this.totalAltitude() / this.jumpCount();
    }

    @Override
    public int highestAltitude() {
        assert this.jumpCount() > 0 : "Violation of: jumpCount() > 0";
        return this.lastJumpAltitude();
    }

    @Override
    public boolean hasReachedALicense() {
        return this.jumpCount() >= 25;
    }

    @Override
    public String toString() {
        return "Jumps: " + this.jumpCount() + ", Last: "
                + this.lastJumpAltitude() + ", Total: " + this.totalAltitude();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof SkydiveJumpLog)) {
            return false;
        }
        SkydiveJumpLog other = (SkydiveJumpLog) obj;
        return this.jumpCount() == other.jumpCount()
                && this.totalAltitude() == other.totalAltitude()
                && this.lastJumpAltitude() == other.lastJumpAltitude();
    }
}
