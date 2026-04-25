public class JumpDemo {

    public static void main(String[] args) {
        SkydiveJumpLog log = new SkydiveJumpLog1L();

        log.recordJump(12000);
        log.recordJump(14000);

        System.out.println(log);
    }
}
