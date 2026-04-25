public class SkydiveJumpLog {

    // tracks total number of jumps
    private int jumpCount;

    // tracks total altitude across all jumps
    private int totalAltitude;

    // stores the most recent jump altitude
    private int lastJumpAltitude;

    // stores the highest altitude recorded
    private int highestAltitude;

    /**
     * Creates an empty jump log.
     */
    public SkydiveJumpLog() {
        this.jumpCount = 0;
        this.totalAltitude = 0;
        this.lastJumpAltitude = 0;
        this.highestAltitude = 0;
    }

    /**
     * Records a jump with a given altitude.
     */
    public void recordJump(int altitude) {
        if (altitude > 0) {
            this.jumpCount++;
            this.totalAltitude += altitude;
            this.lastJumpAltitude = altitude;

            if (altitude > this.highestAltitude) {
                this.highestAltitude = altitude;
            }
        }
    }

    /**
     * Returns total number of jumps.
     */
    public int jumpCount() {
        return this.jumpCount;
    }

    /**
     * Returns the last jump altitude.
     */
    public int lastJumpAltitude() {
        return this.lastJumpAltitude;
    }

    /**
     * Returns the total altitude across all jumps.
     */
    public int totalAltitude() {
        return this.totalAltitude;
    }

    /**
     * Calculates average altitude.
     */
    public double averageAltitude() {
        double avg = 0.0;

        if (this.jumpCount > 0) {
            avg = (double) this.totalAltitude / this.jumpCount;
        }

        return avg;
    }

    /**
     * Returns the highest altitude recorded.
     */
    public int highestAltitude() {
        return this.highestAltitude;
    }

    /**
     * Checks if A-license jump count (25) has been reached.
     */
    public boolean hasReachedALicense() {
        return this.jumpCount >= 25;
    }

    /**
     * Demonstrates how the component works.
     */
    public static void main(String[] args) {

        SkydiveJumpLog log = new SkydiveJumpLog();

        log.recordJump(12000);
        log.recordJump(13500);
        log.recordJump(14000);

        System.out.println("Jumps: " + log.jumpCount());
        System.out.println("Last altitude: " + log.lastJumpAltitude());
        System.out.println("Average altitude: " + log.averageAltitude());
        System.out.println("Highest altitude: " + log.highestAltitude());
        System.out.println("A license: " + log.hasReachedALicense());
    }
}
