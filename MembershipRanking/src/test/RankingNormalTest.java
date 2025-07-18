package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sqa.main.Ranking;

public class RankingNormalTest {

    private Ranking ranking;

    @BeforeEach
    void setUp() {
        ranking = new Ranking();
    }

    @Test
    void testTC01() {
        assertEquals("Standard", ranking.CalculateMembershipRank(9999, 0, 0));
    }

    @Test
    void testTC02() {
        assertEquals("Silver", ranking.CalculateMembershipRank(10000, 1, 100));
    }

    @Test
    void testTC03() {
        assertEquals("Silver", ranking.CalculateMembershipRank(10001, 1, 100));
    }

    @Test
    void testTC04() {
        assertEquals("Silver", ranking.CalculateMembershipRank(30000, 1, 100));
    }

    @Test
    void testTC05() {
        assertEquals("Silver", ranking.CalculateMembershipRank(49999, 1, 100));
    }

    @Test
    void testTC06() {
        assertEquals("Silver", ranking.CalculateMembershipRank(50000, 1, 100));
    }

    @Test
    void testTC07() {
        assertEquals("Silver", ranking.CalculateMembershipRank(50000, 2, 499));
    }

    @Test
    void testTC08() {
        assertEquals("Gold", ranking.CalculateMembershipRank(50000, 3, 500));
    }

    @Test
    void testTC09() {
        assertEquals("Gold", ranking.CalculateMembershipRank(50001, 3, 500));
    }

    @Test
    void testTC10() {
        assertEquals("Gold", ranking.CalculateMembershipRank(75000, 4, 750));
    }

    @Test
    void testTC11() {
        assertEquals("Gold", ranking.CalculateMembershipRank(99999, 5, 999));
    }

    @Test
    void testTC12() {
        assertEquals("Gold", ranking.CalculateMembershipRank(100000, 5, 999));
    }

    @Test
    void testTC13() {
        assertEquals("Platinum", ranking.CalculateMembershipRank(100000, 6, 1000));
    }

    @Test
    void testTC14() {
        assertEquals("Platinum", ranking.CalculateMembershipRank(100001, 6, 1000));
    }

    @Test
    void testTC15() {
        assertEquals("Platinum", ranking.CalculateMembershipRank(150000, 7, 1500));
    }

    @Test
    void testTC16() {
        assertEquals("Standard", ranking.CalculateMembershipRank(200000, 10, 2000)); // ตามโค้ด Platinum ได้เมื่อ frequency 6-7 เท่านั้น
    }

    @Test
    void testTC17() {
        assertEquals("Standard", ranking.CalculateMembershipRank(-1, -1, -1));
    }

    @Test
    void testTC18() {
        assertEquals("Silver", ranking.CalculateMembershipRank(50000, 1, 500));
    }

    @Test
    void testTC19() {
        assertEquals("Silver", ranking.CalculateMembershipRank(50000, 3, 100));
    }

    @Test
    void testTC20() {
        assertEquals("Gold", ranking.CalculateMembershipRank(100000, 5, 1000));
    }

    @Test
    void testTC21() {
        assertEquals("Gold", ranking.CalculateMembershipRank(100000, 6, 900));
    }
    @Test
    void testTC22_Gold_JustMeetCondition() {
        // ครบทุกเงื่อนไข Gold (Purchase >=50000, frequency >=3, point_collected >=500)
        assertEquals("Gold", ranking.CalculateMembershipRank(60000, 3, 500));
    }

    @Test
    void testTC23_Gold_PurchaseMuchHigher() {
        // สูงกว่า silver, ถึง threshold gold
        assertEquals("Gold", ranking.CalculateMembershipRank(85000, 4, 600));
    }

    @Test
    void testTC24_Gold_FrequencyHighEnough() {
        assertEquals("Gold", ranking.CalculateMembershipRank(99999, 10, 800));
    }

    @Test
    void testTC25_Gold_PointExactlyAtThreshold() {
        assertEquals("Gold", ranking.CalculateMembershipRank(90000, 5, 500));
    }

    @Test
    void testTC26_Platinum_JustMeetCondition() {
        // ครบ Platinum ทุกเงื่อนไข (Purchase >=100000, frequency=6, point_collected >=1000)
        assertEquals("Platinum", ranking.CalculateMembershipRank(100000, 6, 1000));
    }

    @Test
    void testTC27_Platinum_MoreThanThreshold() {
        assertEquals("Platinum", ranking.CalculateMembershipRank(150000, 7, 3500));
    }

    @Test
    void testTC28_Platinum_WithMinimumFrequency() {
        // frequency = 6 ต่ำสุดที่ได้ platinum
        assertEquals("Platinum", ranking.CalculateMembershipRank(200000, 6, 1200));
    }

    @Test
    void testTC29_Platinum_WithMaximumFrequency() {
        // frequency = 7 สูงสุดที่ได้ platinum
        assertEquals("Platinum", ranking.CalculateMembershipRank(120000, 7, 5000));
    }
    
    @Test
    void testTC30_PlatinumMai() {
    	//all for plat
    	assertEquals("Platinum",ranking.CalculateMembershipRank(120000, 7, 2000));
    }
    @Test
    void testTC31_GoldMai() {
    	//all for gold
    	assertEquals("Gold",ranking.CalculateMembershipRank(60000, 4, 600));
    }
}