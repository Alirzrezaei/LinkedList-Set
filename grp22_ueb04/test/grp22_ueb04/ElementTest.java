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
 * @author ite102770
 */
public class ElementTest {

/**
     * Creates an element with given value, if multiple values are given more
     * elements are appended. .
     *
     * @param value value(s) of the element(s)
     * @return element with value, for multiple values multiple concatened
     * elements
     */
    private Element createElements(char... value){
        if (value.length == 0) {
            return null;
        }
        // create a new element
        Element el = new Element(value[0]);
        Element firstEl = el; // remember first element
        
        // create more elements
        for (int i = 1; i < value.length; i++) {
            el.setNext(new Element()) ;
            el = el.getNext();
             el.setValue(value[i]);
        }
        return firstEl;       
    }

    //-----------------------------------------------    
//<editor-fold defaultstate="collapsed" desc="Tests of methods from the lecture">
    
    @Test
    public void testAppendElement_ToOneElement() {
        Element el = new Element();
        el.setValue('a');
        Element result = el.appendElement('b');
        assertEquals('a', result.getValue());
        assertEquals('b', result.getNext().getValue());
        assertNull(result.getNext().getNext());
    }
    
    @Test
    public void testAppendElement_Twice() {
        Element el = new Element();
         el.setValue('a');
        Element result = el.appendElement('b').appendElement('c');
        assertEquals('a', result.getValue());
        assertEquals('b', result.getNext().getValue());
        assertEquals('c', result.getNext().getNext().getValue());
        assertNull(result.getNext().getNext().getNext());
    }
    
    //-----------------------------------------------
    
    @Test
    public void testInsertElement_AtFront() {
        Element el = createElements('b', 'd');
        Element result = el.insertElement('a');
        assertEquals('a', result.getValue());
        assertEquals('b', result.getNext().getValue());
        assertEquals('d', result.getNext().getNext().getValue());
        assertNull(result.getNext().getNext().getNext());
    }
    
    @Test
    public void testInsertElement_InMiddle() {
        Element el = createElements('b', 'd');
        Element result = el.insertElement('c');
        assertEquals('b', result.getValue());
        assertEquals('c', result.getNext().getValue());
        assertEquals('d', result.getNext().getNext().getValue());
        assertNull(result.getNext().getNext().getNext());
    }   
    @Test
    public void testInsertElement_AtEnd() {
        Element el = createElements('b', 'd');
        Element result = el.insertElement('e');
        System.out.println(el.showElements(","));
        assertEquals('b', result.getValue());
        assertEquals('d', result.getNext().getValue());
        assertEquals('e', result.getNext().getNext().getValue());
        assertNull(result.getNext().getNext().getNext());
    }
    
    //-----------------------------------------------
    
    @Test
    public void testDeleteElement_AtFront() {
        Element el = createElements('a', 'b', 'c');
        Element result = el.deleteElement('a');
        assertEquals('b', result.getValue());
        assertEquals('c', result.getNext().getValue());
        assertNull(result.getNext().getNext());
    }
    
    @Test
    public void testDeleteElement_InMiddle() {
        Element el = createElements('a', 'b', 'c');
        Element result = el.deleteElement('b');
        System.out.println(result.showElements(","));
        assertEquals('a', result.getValue());
        assertEquals('c', result.getNext().getValue());
        assertNull(result.getNext().getNext());
    }
    
    @Test
    public void testDeleteElement_AtEnd() {
        Element el = createElements('a', 'b', 'c');
        Element result = el.deleteElement('c');
        System.out.println(result.showElements(","));
        assertEquals('a', result.getValue());
        assertEquals('b', result.getNext().getValue());
        assertNull(result.getNext().getNext());
    }
    
    @Test
    public void testDeleteElement_NotExisting() {
        Element el = createElements('a', 'b', 'c');
        Element result = el.deleteElement('d');
        assertEquals('a', result.getValue());
        assertEquals('b', result.getNext().getValue());
        assertEquals('c', result.getNext().getNext().getValue());
        assertNull(result.getNext().getNext().getNext());
    }
    
//</editor-fold>
    
    //-----------------------------------------------

//<editor-fold defaultstate="collapsed" desc="Tests of the methods that should be created">
    
    @Test
    public void testSize() {
        Element el = createElements('a');
        assertEquals(1, el.size());
        
        el = createElements('a', 'b', 'c');
        assertEquals(3, el.size());
    }
    
    
    
    //<editor-fold defaultstate="collapsed" desc="existsElement">
    @Test
    public void testExistsElement_First() {
        Element el = createElements('b', 'c', 'e');
        assertTrue(el.existsElement('b'));
    }
    
    @Test
    public void testExistsElement_Middle() {
        Element el = createElements('b', 'c', 'e');
        assertTrue(el.existsElement('c'));
    }
    
    @Test
    public void testExistsElement_Last() {
        Element el = createElements('b', 'c', 'e');
        assertTrue(el.existsElement('e'));
    }
    
    @Test
    public void testExistsElement_NotExisting() {
        Element el = createElements('b', 'c', 'e');
        assertFalse(el.existsElement('a'));
        assertFalse(el.existsElement('d'));
        assertFalse(el.existsElement('f'));
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="isSorted">
    @Test
    public void testIsSorted_Gapless() {
        Element el = createElements('b', 'c', 'd');
        assertTrue(el.isSorted());
    }
    
    @Test
    public void testIsSorted_WithGaps() {
        Element el = createElements('a', 'c', 'e');
        assertTrue(el.isSorted());
    }
    
    @Test
    public void testIsSorted_DoubleValues() {
        Element el = createElements('b', 'b', 'e');
        assertTrue(el.isSorted());
        el = createElements('b', 'e', 'e');
        assertTrue(el.isSorted());
        el = createElements('b', 'c', 'c', 'e', 'e');
        assertTrue(el.isSorted());
    }
    
    @Test
    public void testIsSorted_NotSorted() {
        Element el = createElements('a', 'b', 'd', 'c');
        assertFalse(el.isSorted());
        el = createElements('a', 'c', 'b', 'd');
        assertFalse(el.isSorted());
        el = createElements('b', 'c', 'a', 'd');
        assertFalse(el.isSorted());
    }
//</editor-fold>
    
    //-----------------------------------------------
    
    @Test
    public void testShowElements() {
        Element el = createElements('a', 'b', 'c');
        assertEquals("a, b, c", el.showElements(","));
        
        el = createElements('b');
        assertEquals("b", el.showElements(","));
    }
    
    //-----------------------------------------------
    
    @Test
    public void testGetElementAt() {
        Element el = createElements('a', 'b', 'c');
        assertEquals('a', el.getElementAt(0));
        assertEquals('b', el.getElementAt(1));
        assertEquals('c', el.getElementAt(2));
    }
    
    @Test
    public void testGetElementAt_InvalidArgument() {
        Element el = createElements('a', 'b', 'c');
        assertEquals(0, el.getElementAt(-1));
        assertEquals(0, el.getElementAt(3));
    }
    
    //-----------------------------------------------
    
//<editor-fold defaultstate="collapsed" desc="testInsertElementAt">
    @Test
    public void testInsertElementAt_Front() {
        Element el = createElements('a', 'b', 'c');
        Element result = el.insertElementAt('A', 0);
        assertEquals('A', result.getValue());
        assertEquals('a', result.getNext().getValue());
    }
    
    @Test
    public void testInsertElementAt_Middle() {
        Element el = createElements('a', 'b', 'c');
        Element result = el.insertElementAt('B', 1);
        assertEquals('a', result.getValue());
        assertEquals('B', result.getNext().getValue());
    }
    
    @Test
    public void testInsertElementAt_End() {
        Element el = createElements('a', 'b');
        Element result = el.insertElementAt('C', 2);
        assertEquals('a', result.getValue());
        assertEquals('b', result.getNext().getValue());
        assertEquals('C', result.getNext().getNext().getValue());
        assertNull(result.getNext().getNext().getNext());
    }
    
    @Test
    public void testInsertElementAt_InvalidIndex() {
        Element el = createElements('b', 'c');
        Element result = el.insertElementAt('A', -1);
        assertEquals(2, result.size());
        assertEquals('b', result.getValue());
        assertEquals('c', result.getNext().getValue());
        assertNull(result.getNext().getNext());
        
        el = createElements('b', 'c');
        result = el.insertElementAt('A', 3);
        assertEquals(2, result.size());
        assertEquals('b', result.getValue());
        assertEquals('c', result.getNext().getValue());
        assertNull(result.getNext().getNext());
    }
//</editor-fold>
    
    //-----------------------------------------------
    
    @Test
    public void testInsertElementAtFront() {
        Element el = createElements('a', 'b');
        Element result = el.insertElementAtFront('A');
        assertEquals('A', result.getValue());
        assertEquals('a', result.getNext().getValue());
        assertEquals('b', result.getNext().getNext().getValue());
        assertNull(result.getNext().getNext().getNext());
    }
    
//</editor-fold>

       @Test
    public void testIsPredecessor() {
        Element el = createElements('a', 'B', 'b', 'c', 'D');
        assertTrue(el.TestisPredecessor('C'));
        assertTrue(el.TestisPredecessor('x'));
        assertTrue(el.TestisPredecessor('f'));
        assertTrue(el.TestisPredecessor('B'));
        assertTrue(el.TestisPredecessor('c'));
        assertTrue(el.TestisPredecessor('D'));
        assertFalse(el.TestisPredecessor('a'));
    }

    @Test
    public void testIsPredecessor_WithOneValue() {
        Element el = createElements('a');
        assertFalse(el.TestisPredecessor('a'));
    }

    @Test
    public void testIsPredecessor_NotExistValue() {
        Element el = createElements('a', 'B');
        assertTrue(el.TestisPredecessor('E'));
    }

    @Test
    public void testOwnInsertElement_AtFront() {
        Element el = createElements('A', 'b', 'E', 'e');
        Element result = el.insertElement('a');
        System.out.println(result.showElements(","));
        assertTrue(el.TestisPredecessor('a'));
        assertEquals('A', result.getValue());
        assertEquals('a', result.getNext().getValue());
        assertEquals('b', result.getNext().getNext().getValue());

    }

    @Test
    public void testOwnInsertElement_UpperCaseinserted() {
        Element el = createElements('a', 'b', 'E', 'e');
        Element result = el.insertElement('A');
        System.out.println(result.showElements(","));
        assertTrue(result.TestisPredecessor('a'));
        assertTrue(result.TestisPredecessor('E'));
        assertEquals('A', result.getValue());
        assertEquals('a', result.getNext().getValue());
        assertEquals('b', result.getNext().getNext().getValue());
        assertNull(result.getNext().getNext().getNext().getNext().getNext());
    }

    @Test
    public void testOwnInsertElement() {
        Element el = createElements('a', 'c', 'E', 'e');
        Element result = el.insertElement('B');
        System.out.println(result.showElements(","));
        assertFalse(result.TestisPredecessor('a'));
        assertTrue(result.TestisPredecessor('B'));
        assertEquals('a', result.getValue());
        assertEquals('B', result.getNext().getValue());
        assertEquals('c', result.getNext().getNext().getValue());
        assertNull(result.getNext().getNext().getNext().getNext().getNext());
    }

    @Test
    public void testOwnInsertElement2() {
        Element el = createElements('A', 'B', 'E', 'e');
        Element result = el.insertElement('c');
        System.out.println(result.showElements(","));
        assertTrue(result.TestisPredecessor('a'));
        result.insertElement('a');
        System.out.println(result.showElements(","));
    }

    @Test
    public void testOwnInsertElement_beforeSuccessor() {
        Element el = createElements('a', 'c', 'e');
        Element result = el.insertElement('B');
        System.out.println(result.showElements(","));
        assertFalse(result.TestisPredecessor('a'));
        assertTrue(result.TestisPredecessor('B'));
        assertEquals('a', result.getValue());
        assertEquals('B', result.getNext().getValue());
        assertEquals('c', result.getNext().getNext().getValue());

    }

    @Test
    public void testOwnIsSame_trueCase() {
        Element el = createElements('A', 'a', 'c', 'e');
        Element other = createElements('A', 'a', 'c', 'e');
        System.out.println(other.showElements(","));
        assertTrue(el.isSame(other));
    }

    @Test
    public void testOwnIsSame_diffSize() {
        Element el = createElements('a', 'c', 'e');
        Element other = createElements('a', 'c');
        System.out.println(other.showElements(","));
        assertFalse(el.isSame(other));
        assertEquals('a', other.getValue());
        assertEquals('c', other.getNext().getValue());

    }

    @Test
    public void testOwnIsSame_trueCase2() {
        Element el = createElements('a', 'c');
        Element other = createElements('a', 'c', 'e');
        System.out.println(other.showElements(","));
        assertFalse(el.isSame(other));
        assertEquals('a', other.getValue());
        assertEquals('c', other.getNext().getValue());
        assertEquals('e', other.getNext().getNext().getValue());
    }

    @Test
    public void testOwnIsSame_diffValuesAtFront() {
        Element el = createElements('A', 'c', 'e');
        Element other = createElements('a', 'c', 'e');
        System.out.println(other.showElements(","));
        assertFalse(el.isSame(other));

    }

    @Test
    public void testOwnIsSame_diffValuesInMiddle() {
        Element el = createElements('A', 'C', 'e');
        Element other = createElements('A', 'c', 'e');
        System.out.println(other.showElements(","));
        assertFalse(el.isSame(other));
    }

    @Test
    public void testOwnIsSame_diffValuesLastElement() {
        Element el = createElements('A', 'c', 'E');
        Element other = createElements('A', 'c', 'e');
        System.out.println(other.showElements(","));
        assertFalse(el.isSame(other));
    }

    @Test
    public void testOwnIsSame_EmptySets() {
        Element el = new Element();
        Element other = new Element();
        assertTrue(el.isSame(other));
    }

    @Test
    public void testOwnIsSame_OneIsEmpty() {
        Element el = createElements('A', 'c', 'E');
        Element other = new Element();
        assertFalse(el.isSame(other));
    }

    @Test
    public void testownExistElement() {
        Element el = createElements('A', 'c', 'E');
        assertTrue(el.existsElement('A'));
        //assertFalse(el.existsElement('b'));
    }
}
