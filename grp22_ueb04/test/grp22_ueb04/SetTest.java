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
    
     @Test
    public void testUnion() {
       Set newSet1 = new Set("AaBcDEfG");
       Set newSet2 = new Set("AbcdEFfg");   
       Set newSet3 = newSet1.union(newSet2);
       System.out.println(newSet1.showValues(","));
       System.out.println(newSet2.showValues(","));
       System.out.println(newSet3.showValues(","));
       assertEquals(16, newSet3.size());   
    }
    
    
}
