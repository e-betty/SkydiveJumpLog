public class TrainingTracker {

    private SkydiveJumpLog log;

    public TrainingTracker() {
        this.log = new SkydiveJumpLog1L();
    }

    public void addJump(int altitude) {
        this.log.recordJump(altitude);
    }

    public boolean readyForLicense() {
        return this.log.hasReachedALicense();
    }
}
