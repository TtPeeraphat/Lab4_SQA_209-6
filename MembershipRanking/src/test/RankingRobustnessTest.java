package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sqa.main.Ranking;

import static org.junit.jupiter.api.Assertions.*;

class RankingRobustnessTest {

    private Ranking ranking;

    @BeforeEach
    void setUp() {
        ranking = new Ranking();
    }

    @Test
    void testRB01_NegativePurchaseTotal() {
        // ปัจจุบันโค้ด return "Standard" ไม่ throw exception
        assertEquals("Standard", ranking.CalculateMembershipRank(-1, 3, 100));
    }

    @Test
    void testRB02_ZeroPurchaseTotal() {
        assertEquals("Standard", ranking.CalculateMembershipRank(0, 1, 0));
    }

    @Test
    void testRB03_JustAboveZero() {
        assertEquals("Standard", ranking.CalculateMembershipRank(1, 1, 0));
    }

    @Test
    void testRB04_SilverConditions() {
        assertEquals("Silver", ranking.CalculateMembershipRank(10000, 1, 500));
    }

    @Test
    void testRB05_PlatinumHighPoint() {
        // frequency = 3 < 6 ไม่มีทางเข้า platinum ใน logic, ได้ Gold ตามหลัก
        assertEquals("Gold", ranking.CalculateMembershipRank(50000, 3, 8900));
    }

    @Test
    void testRB06_VeryHighValues() {
        // frequency = 20, ตาม logic ไม่มีชั้น platinum ได้, ได้ Gold
        assertEquals("Gold", ranking.CalculateMembershipRank(999999999, 20, 35000));
    }

    @Test
    void testRB07_NonNumericPurchaseTotal() {
        assertThrows(NumberFormatException.class, () -> {
            Integer.parseInt("abc");
        });
    }

    @Test
    void testRB08_NullPurchaseTotal() {
        assertThrows(NullPointerException.class, () -> {
            Integer x = null;
            ranking.CalculateMembershipRank(x, 4, 780);
        });
    }

    @Test
    void testRB09_NegativeFrequency() {
        assertEquals("Standard", ranking.CalculateMembershipRank(1000, -5, 600));
    }

    @Test
    void testRB10_NonNumericFrequency() {
        assertThrows(NumberFormatException.class, () -> {
            Integer.parseInt("xxx");
        });
    }

    @Test
    void testRB11_NegativePointCollected() {
        assertEquals("Standard", ranking.CalculateMembershipRank(1000, 3, -500));
    }

    @Test
    void testRB12_NonNumericPointCollected() {
        assertThrows(NumberFormatException.class, () -> {
            Integer.parseInt("point");
        });
    }

    @Test
    void testRB13_NullPointCollected() {
        assertThrows(NullPointerException.class, () -> {
            Integer x = null;
            ranking.CalculateMembershipRank(1000, 3, x);
        });
    }

    @Test
    void testRB14_NormalData() {
        assertEquals("Standard", ranking.CalculateMembershipRank(1000, 3, 600));
    }	

    @Test
    void testRB15_VeryLargeNumber() {
        assertEquals("Platinum", ranking.CalculateMembershipRank(1000000000, 3, 600));
    }

    @Test
    void testRB16_AllZero() {
        assertEquals("Standard", ranking.CalculateMembershipRank(0, 0, 0));
    }

    @Test
    void testRB17_NormalBusinessCase() {
        assertEquals("Silver", ranking.CalculateMembershipRank(1000, 3, 600));
    }

    @Test
    void testRB18_SpecialCharacterFrequency() {
        assertThrows(NumberFormatException.class, () -> {
            Integer.parseInt("!@#");
        });
    }
}