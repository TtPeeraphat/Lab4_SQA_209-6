package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import sqa.main.Ranking;

public class RankingNormalTest {

    private Ranking ranking;

    @BeforeEach
    void setUp() {
        ranking = new Ranking();
    }

    @Test @DisplayName("TC01 1 2 -1 ระดับ Standard")
    void test_TC01() {
        assertEquals("Standard", ranking.CalculateMembershipRank(1, 2, -1));
    }

    @Test @DisplayName("TC02 1 2 0 ระดับ Standard")
    void test_TC02() {
        assertEquals("Standard", ranking.CalculateMembershipRank(1, 2, 0));
    }

    @Test @DisplayName("TC03 1 2 1 ระดับ Gold")
    void test_TC03() {
        assertEquals("Gold", ranking.CalculateMembershipRank(1, 2, 1));
    }

    @Test @DisplayName("TC04 1 2 500 ระดับ Gold")
    void test_TC04() {
        assertEquals("ระดับ Gold", ranking.CalculateMembershipRank(1, 2, 500));
    }

    @Test @DisplayName("TC05 1 2 999 ระดับ Gold")
    void test_TC05() {
        assertEquals("Gold", ranking.CalculateMembershipRank(1, 2, 999));
    }

    @Test @DisplayName("TC06 1 -1 1 ระดับ Silver")
    void test_TC06() {
        assertEquals("Silver", ranking.CalculateMembershipRank(1, -1, 1));
    }

    @Test @DisplayName("TC07 1 1 1 ระดับ Silver")
    void test_TC07() {
        assertEquals("Silver", ranking.CalculateMembershipRank(1, 1, 1));
    }

    @Test @DisplayName("TC08 1 15 1 ระดับ Gold")
    void test_TC08() {
        assertEquals("Gold", ranking.CalculateMembershipRank(1, 15, 1));
    }

    @Test @DisplayName("TC09 1 30 1 ระดับ Gold")
    void test_TC09() {
        assertEquals("Gold", ranking.CalculateMembershipRank(1, 30, 1));
    }

    @Test @DisplayName("TC10 -1 2 1 ระดับ Standard")
    void test_TC10() {
        assertEquals("Standard", ranking.CalculateMembershipRank(-1, 2, 1));
    }

    @Test @DisplayName("TC11 0 2 1 ระดับ Standard")
    void test_TC11() {
        assertEquals("Standard", ranking.CalculateMembershipRank(0, 2, 1));
    }

    @Test @DisplayName("TC12 50000 2 1 ระดับ Gold")
    void test_TC12() {
        assertEquals("Gold", ranking.CalculateMembershipRank(50000, 2, 1));
    }

    @Test @DisplayName("TC13 99999 2 1 ระดับ Gold")
    void test_TC13() {
        assertEquals("Gold", ranking.CalculateMembershipRank(99999, 2, 1));
    }
}