/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grp22_ueb04;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alireza
 * TODO: Get rid of all outputs, add proper asserts
 */
public class SetTest {

    private Set createList(String value) {
        Set list = new Set(value);
        return list;
    }

    @Test
    public void testAddElement() {
        Set newSet = new Set("aBf");
        assertEquals(3, newSet.size());
        newSet.addElement('A');
        assertEquals(4, newSet.size());
        System.out.println(newSet.showValues(","));
    }

    @Test
    public void testAddElement_emptyConstructor() {
        Set newSet = new Set();
        assertEquals(0, newSet.size());
        newSet.addElement('A');
    }
    /////////////// Union Test ////////////  

    @Test
    public void testUnion_WithIntersection() {
        Set newSet1 = new Set("AaBcDEfG");
        Set newSet2 = new Set("AcdEFfg");
        Set newSet3 = newSet1.union(newSet2);
        System.out.println(newSet1.showValues(","));
        System.out.println(newSet2.showValues(","));
        System.out.println(newSet3.showValues(","));
        assertEquals(11, newSet3.size());
    }

    @Test
    public void testUnion_IsSame() {
        Set newSet1 = new Set("AaBcDEfG");
        Set newSet2 = new Set("AaBcDEfG");
        Set newSet3 = newSet1.union(newSet2);
        System.out.println(newSet1.showValues(","));
        System.out.println(newSet2.showValues(","));
        System.out.println(newSet3.showValues(","));
        assertEquals(8, newSet3.size());
    }

    @Test
    public void testUnion_NoTintersection() {
        Set newSet1 = new Set("ABCDJK");
        Set newSet2 = new Set("abcdh");
        Set newSet3 = newSet1.union(newSet2);
        System.out.println(newSet1.showValues(","));
        System.out.println(newSet2.showValues(","));
        System.out.println(newSet3.showValues(","));
        assertEquals(11, newSet3.size());
    }

    @Test
    public void testUnion_FirstEmpty() {
        Set newSet1 = new Set("");
        Set newSet2 = new Set("aBcdhK");
        Set newSet3 = newSet1.union(newSet2);
        System.out.println(newSet1.showValues(","));
        System.out.println(newSet2.showValues(","));
        System.out.println(newSet3.showValues(","));
        assertEquals(6, newSet3.size());
    }

    @Test
    public void testUnion_SecondEmpty() {
        Set newSet1 = new Set("aBCdF");
        Set newSet2 = new Set("");
        Set newSet3 = newSet1.union(newSet2);
        System.out.println(newSet1.showValues(","));
        System.out.println(newSet2.showValues(","));
        System.out.println(newSet3.showValues(","));
        assertEquals(5, newSet3.size());
    }
    ///////////////intersection Test ////////////  

    @Test
    public void testIntersection_WithIntersection() {
        Set newSet1 = new Set("AbcDd");
        Set newSet2 = new Set("AcdEFfg");
        Set newSet3 = newSet1.intersection(newSet2);
        System.out.println(newSet1.showValues(","));
        System.out.println(newSet2.showValues(","));
        System.out.println(newSet3.showValues(","));
        assertEquals(3, newSet3.size());
    }

    @Test
    public void testIntersection_NoIntersection() {
        Set newSet1 = new Set("AbcDd");
        Set newSet2 = new Set("EFfg");
        Set newSet3 = newSet1.intersection(newSet2);
        System.out.println(newSet1.showValues(","));
        System.out.println(newSet2.showValues(","));
        System.out.println(newSet3.showValues(","));
        assertEquals(0, newSet3.size());
    }

    @Test
    public void testIntersection_FirstEmpty() {
        Set newSet1 = new Set("");
        Set newSet2 = new Set("EFfg");
        Set newSet3 = newSet1.intersection(newSet2);
        System.out.println(newSet1.showValues(","));
        System.out.println(newSet2.showValues(","));
        System.out.println(newSet3.showValues(","));
        assertEquals(0, newSet3.size());
        assertTrue(newSet3.isSame(newSet1));
        assertFalse(newSet3.isSame(newSet2));
    }

    @Test
    public void testIntersection_SecondEmpty() {
        Set newSet1 = new Set("EFfghN");
        Set newSet2 = new Set("");
        Set newSet3 = newSet1.intersection(newSet2);
        System.out.println(newSet1.showValues(","));
        System.out.println(newSet2.showValues(","));
        System.out.println(newSet3.showValues(","));
        assertEquals(0, newSet3.size());
        assertFalse(newSet3.isSame(newSet1));
    }

    @Test
    public void testIntersection_IsSame() {
        Set newSet1 = new Set("EFfghN");
        Set newSet2 = new Set("EFfghN");
        Set newSet3 = newSet1.intersection(newSet2);
        System.out.println(newSet1.showValues(","));
        System.out.println(newSet2.showValues(","));
        System.out.println(newSet3.showValues(","));
        assertEquals(6, newSet3.size());
        assertTrue(newSet3.isSame(newSet1));
        assertTrue(newSet3.isSame(newSet2));
    }
    /////////////// Diff Test ////////////  

    @Test
    public void testdiff_WithIntersection() {
        Set newSet1 = new Set("AaB");
        Set newSet2 = new Set("Acdg");
        Set newSet3 = newSet1.diff(newSet2);
        System.out.println(newSet1.showValues(","));
        System.out.println(newSet2.showValues(","));
        System.out.println(newSet3.showValues(","));
        assertEquals(2, newSet3.size());
    }

    @Test
    public void testdiff_NoIntersection() {
        Set newSet1 = new Set("AaB");
        Set newSet2 = new Set("cdghjklmnOP");
        Set newSet3 = newSet1.diff(newSet2);
        System.out.println(newSet1.showValues(","));
        System.out.println(newSet2.showValues(","));
        System.out.println(newSet3.showValues(","));
        assertEquals(3, newSet3.size());
    }

    @Test
    public void testdiff_Firstempty() {
        Set newSet1 = new Set("");
        Set newSet2 = new Set("cdghjklmnOP");
        Set newSet3 = newSet1.diff(newSet2);
        System.out.println(newSet1.showValues(","));
        System.out.println(newSet2.showValues(","));
        System.out.println(newSet3.showValues(","));
        assertEquals(0, newSet3.size());
        assertTrue(newSet3.isSame(newSet1));
    }

    @Test
    public void testdiff_Secondempty() {
        Set newSet1 = new Set("cdghjklmnOP");
        Set newSet2 = new Set("");
        Set newSet3 = newSet1.diff(newSet2);
        System.out.println(newSet1.showValues(","));
        System.out.println(newSet2.showValues(","));
        System.out.println(newSet3.showValues(","));
        assertEquals(11, newSet3.size());
    }

    @Test
    public void testdiff_IsSame() {
        Set newSet1 = new Set("cdghnOP");
        Set newSet2 = new Set("cdghnOP");
        Set newSet3 = newSet1.diff(newSet2);
        System.out.println(newSet1.showValues(","));
        System.out.println(newSet2.showValues(","));
        System.out.println(newSet3.showValues(","));
        assertEquals(0, newSet3.size());
    }

    /////////////// SymmetricDiff Test ////////////  
    @Test
    public void testSymmdiff_WithIntersection() {
        Set newSet1 = new Set("AaB");
        Set newSet2 = new Set("ABcg");
        Set newSet3 = newSet1.symmDiff(newSet2);
        System.out.println(newSet1.showValues(","));
        System.out.println(newSet2.showValues(","));
        System.out.println(newSet3.showValues(","));
        assertEquals(3, newSet3.size());
    }

    @Test
    public void testSymmdiff_noIntersection() {
        Set newSet1 = new Set("abd");
        Set newSet2 = new Set("ABcg");
        Set newSet3 = newSet1.symmDiff(newSet2);
        System.out.println(newSet1.showValues(","));
        System.out.println(newSet2.showValues(","));
        System.out.println(newSet3.showValues(","));
        assertEquals(7, newSet3.size());
    }

    @Test
    public void testSymmdiff_FirstEmpty() {
        Set newSet1 = new Set("");
        Set newSet2 = new Set("ABcg");
        Set newSet3 = newSet1.symmDiff(newSet2);
        System.out.println(newSet1.showValues(","));
        System.out.println(newSet2.showValues(","));
        System.out.println(newSet3.showValues(","));
        assertEquals(4, newSet3.size());
    }

    @Test
    public void testSymmdiff_SecondEmpty() {
        Set newSet1 = new Set("ABcg");
        Set newSet2 = new Set("");
        Set newSet3 = newSet1.symmDiff(newSet2);
        System.out.println(newSet1.showValues(","));
        System.out.println(newSet2.showValues(","));
        System.out.println(newSet3.showValues(","));
        assertEquals(4, newSet3.size());
    }

    @Test
    public void testSymmdiff_IsSame() {
        Set newSet1 = new Set("ABcg");
        Set newSet2 = new Set("ABcg");
        Set newSet3 = newSet1.symmDiff(newSet2);
        System.out.println(newSet1.showValues(","));
        System.out.println(newSet2.showValues(","));
        System.out.println(newSet3.showValues(","));
        assertEquals(0, newSet3.size());
        assertTrue(newSet1.isSame(newSet2));
    }
}
