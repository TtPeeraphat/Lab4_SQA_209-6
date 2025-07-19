package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import sqa.main.Ranking;

public class RankingRobustnessTest {

    private Ranking ranking;

    @BeforeEach
    void setUp() {
        ranking = new Ranking();
    }

    @Test @DisplayName("TC01 50000 15 -1")
    void test_TC01() {
        assertEquals("Standard",ranking.CalculateMembershipRank(50000, 15, -1));
      
    }

    @Test @DisplayName("TC02 50000 15 0")
    void test_TC02() {
        assertEquals("Standard",ranking.CalculateMembershipRank(50000, 15, 0));
       
    }

    @Test @DisplayName("TC03 50000 15 1")
    void test_TC03() {
        assertEquals("Standard",ranking.CalculateMembershipRank(50000, 15, 1));
        
    }

    @Test @DisplayName("TC04 50000 15 500")
    void test_TC04() {
        assertEquals("Gold",ranking.CalculateMembershipRank(50000, 15, 500));
       
    }

    @Test @DisplayName("TC05 50000 15 999")
    void test_TC05() {
        assertEquals("Gold",ranking.CalculateMembershipRank(50000, 15, 999));
        
    }

    @Test @DisplayName("TC06 50000 15 1000")
    void test_TC06() {
        assertEquals("Gold",ranking.CalculateMembershipRank(50000, 15, 1000));
       
    }

    @Test @DisplayName("TC07 50000 15 1001")
    void test_TC07() {
        assertEquals("Gold",ranking.CalculateMembershipRank(50000, 15, 1001));
      
    }

    @Test @DisplayName("TC08 50000 0 500")
    void test_TC08() {
        assertEquals("Standard",ranking.CalculateMembershipRank(50000, 0, 500));
      
    }

    @Test @DisplayName("TC09 50000 1 500")
    void test_TC09() {
        assertEquals("Silver",ranking.CalculateMembershipRank(50000, 1, 500));
       
    }

    @Test @DisplayName("TC10 50000 2 500")
    void test_TC10() {
        assertEquals("Silver",ranking.CalculateMembershipRank(50000, 2, 500));
        
    }

    @Test @DisplayName("TC11 50000 30 500")
    void test_TC11() {
        assertEquals("Gold",ranking.CalculateMembershipRank(50000, 30, 500));
        
    }

    @Test @DisplayName("TC12 50000 31 500")
    void test_TC12() {
        assertEquals("Gold",ranking.CalculateMembershipRank(50000, 31, 500));
     
    }

    @Test @DisplayName("TC13 50000 32 500")
    void test_TC13() {
        assertEquals("Gold",ranking.CalculateMembershipRank(50000, 32, 500));
        
    }

    @Test @DisplayName("TC14 -1 15 500")
    void test_TC14() {
        assertEquals("Standard",ranking.CalculateMembershipRank(-1, 15, 500));
        
    }

    @Test @DisplayName("TC15 0 15 500")
    void test_TC15() {
        assertEquals("Standard",ranking.CalculateMembershipRank(0, 15, 500));
       
    }

    @Test @DisplayName("TC16 1 15 500")
    void test_TC16() {
        assertEquals("Standard",ranking.CalculateMembershipRank(1, 15, 500));
      
    }

    @Test @DisplayName("TC17 99999 15 500")
    void test_TC17() {
        assertEquals("Gold",ranking.CalculateMembershipRank(99999, 15, 500));
        
    }

    @Test @DisplayName("TC18 100000 15 500")
    void test_TC18() {
        assertEquals("Gold",ranking.CalculateMembershipRank(100000, 15, 500));
        
    }

    @Test @DisplayName("TC19 100001 15 500")
    void test_TC19() {
        assertEquals("Gold",ranking.CalculateMembershipRank(100001, 15, 500));
       
    }
}