import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests for SkydiveJumpLog1L.
 */
public class SkydiveJumpLog1LTest {

    @Test
    public void testInitialState() {
        SkydiveJumpLog log = new SkydiveJumpLog1L();

        assertEquals(0, log.jumpCount());
        assertEquals(0, log.totalAltitude());
    }

    @Test
    public void testRecordJumpOne() {
        SkydiveJumpLog log = new SkydiveJumpLog1L();

        log.recordJump(12000);

        assertEquals(1, log.jumpCount());
        assertEquals(12000, log.totalAltitude());
        assertEquals(12000, log.lastJumpAltitude());
        assertEquals(12000, log.highestAltitude());
    }

    @Test
    public void testRecordJumpManyHighestFirst() {
        SkydiveJumpLog log = new SkydiveJumpLog1L();

        log.recordJump(14000);
        log.recordJump(12000);
        log.recordJump(10000);

        assertEquals(3, log.jumpCount());
        assertEquals(36000, log.totalAltitude());
        assertEquals(10000, log.lastJumpAltitude());
        assertEquals(14000, log.highestAltitude());
    }

    @Test
    public void testRecordJumpManyHighestLast() {
        SkydiveJumpLog log = new SkydiveJumpLog1L();

        log.recordJump(10000);
        log.recordJump(12000);
        log.recordJump(14000);

        assertEquals(3, log.jumpCount());
        assertEquals(36000, log.totalAltitude());
        assertEquals(14000, log.lastJumpAltitude());
        assertEquals(14000, log.highestAltitude());
    }

    @Test
    public void testAverageAltitude() {
        SkydiveJumpLog log = new SkydiveJumpLog1L();

        log.recordJump(10000);
        log.recordJump(14000);

        assertEquals(12000.0, log.averageAltitude(), 0.001);
        assertEquals(2, log.jumpCount());
        assertEquals(24000, log.totalAltitude());
        assertEquals(14000, log.lastJumpAltitude());
        assertEquals(14000, log.highestAltitude());
    }

    @Test
    public void testHasReachedALicenseFalse() {
        SkydiveJumpLog log = new SkydiveJumpLog1L();

        for (int i = 0; i < 24; i++) {
            log.recordJump(12000);
        }

        assertEquals(false, log.hasReachedALicense());
        assertEquals(24, log.jumpCount());
        assertEquals(288000, log.totalAltitude());
    }

    @Test
    public void testHasReachedALicenseTrue() {
        SkydiveJumpLog log = new SkydiveJumpLog1L();

        for (int i = 0; i < 25; i++) {
            log.recordJump(12000);
        }

        assertEquals(true, log.hasReachedALicense());
        assertEquals(25, log.jumpCount());
        assertEquals(300000, log.totalAltitude());
    }

    @Test
    public void testClear() {
        SkydiveJumpLog log = new SkydiveJumpLog1L();

        log.recordJump(12000);
        log.recordJump(14000);
        log.clear();

        assertEquals(0, log.jumpCount());
        assertEquals(0, log.totalAltitude());
    }

    @Test
    public void testNewInstance() {
        SkydiveJumpLog log = new SkydiveJumpLog1L();
        log.recordJump(12000);

        SkydiveJumpLog empty = log.newInstance();

        assertEquals(0, empty.jumpCount());
        assertEquals(0, empty.totalAltitude());

        assertEquals(1, log.jumpCount());
        assertEquals(12000, log.totalAltitude());
    }

    @Test
    public void testTransferFrom() {
        SkydiveJumpLog source = new SkydiveJumpLog1L();
        source.recordJump(12000);
        source.recordJump(14000);

        SkydiveJumpLog target = new SkydiveJumpLog1L();
        target.transferFrom(source);

        assertEquals(2, target.jumpCount());
        assertEquals(26000, target.totalAltitude());
        assertEquals(14000, target.lastJumpAltitude());
        assertEquals(14000, target.highestAltitude());

        assertEquals(0, source.jumpCount());
        assertEquals(0, source.totalAltitude());
    }

    @Test
    public void testToStringDoesNotChangeState() {
        SkydiveJumpLog log = new SkydiveJumpLog1L();

        log.recordJump(12000);
        log.toString();

        assertEquals(1, log.jumpCount());
        assertEquals(12000, log.totalAltitude());
        assertEquals(12000, log.lastJumpAltitude());
        assertEquals(12000, log.highestAltitude());
    }

    @Test
    public void testEqualsSameState() {
        SkydiveJumpLog log1 = new SkydiveJumpLog1L();
        SkydiveJumpLog log2 = new SkydiveJumpLog1L();

        log1.recordJump(12000);
        log2.recordJump(12000);

        assertEquals(true, log1.equals(log2));
        assertEquals(1, log1.jumpCount());
        assertEquals(12000, log1.totalAltitude());
    }
}
