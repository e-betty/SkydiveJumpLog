/**
 * Kernel implementation for SkydiveJumpLog.
 *
 * Convention: jumpCount >= 0, totalAltitude >= 0, lastJumpAltitude >= 0,
 * highestAltitude >= 0. If jumpCount = 0, then totalAltitude = 0,
 * lastJumpAltitude = 0, and highestAltitude = 0.
 *
 * Correspondence: this represents a jump log with jumpCount recorded jumps,
 * totalAltitude total feet of altitude, lastJumpAltitude as the most recent
 * altitude, and highestAltitude as the highest recorded altitude.
 */
public class SkydiveJumpLog1L extends SkydiveJumpLogSecondary {

    /**
     * Number of jumps recorded.
     */
    private int jumpCount;

    /**
     * Sum of all jump altitudes.
     */
    private int totalAltitude;

    /**
     * Most recent jump altitude.
     */
    private int lastJumpAltitude;

    /**
     * Highest recorded altitude.
     */
    private int highestAltitude;

    /**
     * Creates an empty jump log.
     */
    public SkydiveJumpLog1L() {
        this.createNewRep();
    }

    /**
     * Creates a new representation.
     */
    private void createNewRep() {
        this.jumpCount = 0;
        this.totalAltitude = 0;
        this.lastJumpAltitude = 0;
        this.highestAltitude = 0;
    }

    @Override
    public void recordJump(int altitude) {
        assert altitude > 0 : "Violation of: altitude > 0";

        this.jumpCount++;
        this.totalAltitude += altitude;
        this.lastJumpAltitude = altitude;

        if (altitude > this.highestAltitude) {
            this.highestAltitude = altitude;
        }
    }

    @Override
    public int jumpCount() {
        return this.jumpCount;
    }

    @Override
    public int lastJumpAltitude() {
        assert this.jumpCount > 0 : "Violation of: jumpCount() > 0";

        return this.lastJumpAltitude;
    }

    @Override
    public int totalAltitude() {
        return this.totalAltitude;
    }

    @Override
    public int highestAltitude() {
        assert this.jumpCount > 0 : "Violation of: jumpCount() > 0";

        return this.highestAltitude;
    }

    @Override
    public SkydiveJumpLog newInstance() {
        return new SkydiveJumpLog1L();
    }

    @Override
    public void clear() {
        this.createNewRep();
    }

    @Override
    public void transferFrom(SkydiveJumpLog source) {
        assert source != null : "Violation of: source is not null";
        assert source instanceof SkydiveJumpLog1L : "Violation of: source is same dynamic type";

        SkydiveJumpLog1L localSource = (SkydiveJumpLog1L) source;

        this.jumpCount = localSource.jumpCount;
        this.totalAltitude = localSource.totalAltitude;
        this.lastJumpAltitude = localSource.lastJumpAltitude;
        this.highestAltitude = localSource.highestAltitude;

        localSource.clear();
    }
}
