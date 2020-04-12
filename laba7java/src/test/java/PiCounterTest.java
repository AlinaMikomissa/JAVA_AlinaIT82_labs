import static org.junit.jupiter.api.Assertions.*;

class PiCounterTest {

    @org.junit.jupiter.api.Test
    void getPiParallel_1_thread() {
        PiCounter counter = new PiCounter(1, 1000000);
        counter.GetPiParallel();
    }
    @org.junit.jupiter.api.Test
    void getPiParallel_2_threads() {
        PiCounter counter = new PiCounter(2, 1000000);
        counter.GetPiParallel();
    }
    @org.junit.jupiter.api.Test
    void getPiParallel_3_threads() {
        PiCounter counter = new PiCounter(3, 1000000);
        counter.GetPiParallel();
    }
    @org.junit.jupiter.api.Test
    void getPiParallel_4_threads() {
        PiCounter counter = new PiCounter(4, 1000000);
        counter.GetPiParallel();
    }
    @org.junit.jupiter.api.Test
    void getPiParallel_5_threads() {
        PiCounter counter = new PiCounter(5, 1000000);
        counter.GetPiParallel();
    }
}