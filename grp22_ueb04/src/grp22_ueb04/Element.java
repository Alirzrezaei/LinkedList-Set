/**
 * this class, Element, is making new element in a Linked-List and appending, deleting, inserting
 * elements in recursive manner. It also check if the Linked-List of elements is sorted.
 * Also, in this class two Linked-List are being checked if they have values with same length.
 * . This class can be used as instance class for a list class to make a list of elements with char value.
 *
 */
package grp22_ueb04;

/**
 *
 * @author Alireza
 */
public class Element {

    private char value;
    private Element next;
    public static final char INVALID_VALUE = 0;

    public Element() {
        //default constructor 
    }

    public Element(char value) {
        this.value = value;
    }

    /**
     * gets the value of the element
     *
     * @return value of the element
     */
    public char getValue() {
        return this.value;
    }

    /**
     * sets the values of an element
     *
     * @param value is the given value
     */
    public void setValue(char value) {
        this.value = value;
    }

    /**
     * sets the next element
     *
     * @param next element
     */
    public void setNext(Element next) {
        this.next = next;
    }

    /**
     * gets the next element
     *
     * @return next element
     */
    public Element getNext() {
        return this.next;
    }

    /**
     * appends an element in an empty place
     *
     * @param value of the element in char type
     * @return element
     */
    public Element appendElement(char value) {
        if (this.next == null) {
            Element newElement = new Element();
            newElement.setValue(value);
            this.next = newElement;

        } else {
            this.next = this.next.appendElement(value);
        }
        return this;

    }

    /**
     * deletes the element with given value
     *
     * @param value of an elements in char type
     * @return element
     */
    public Element deleteElement(char value) {
        if (isSorted() && existsElement(value)) {

            if (!isPredecessor(value) && this.value == value) {
                return this.next;
            } else if (isPredecessor(value) && this.next.value == value) {
                this.setNext(this.next.next);
                return this;
            } else {
                if (this.next != null) {
                    this.next = this.next.deleteElement(value);
                }
                return this;
            }
        }
        return this;
    }

    /**
     * insert new element between sorted elements
     *
     * @param value of the element in char type
     * @return element
     */
    public Element insertElement(char value) {
        if (!TestisPredecessor(value) && this.value > value) {
            Element newElement = new Element();
            newElement.setValue(value);
            newElement.setNext(this);
            return newElement;
        } else if (TestisPredecessor(value) && this.next != null && Character.toLowerCase(this.next.value) > Character.toLowerCase(value)) {
            Element newElement = new Element();
            newElement.setValue(value);
            newElement.setNext(this.next);
            this.setNext(newElement);
            return this;
        } else if (this.next == null) {
            Element newElement = new Element();
            newElement.setValue(value);
            this.next = newElement;
            return this;
        } else {
            this.next = this.next.insertElement(value);
            return this;
        }
    }

    /**
     * return the number of existing elements
     *
     * @return size of the total elements in Integer type
     */
    public int size() {
        if (this.next == null) {
            return 1;
        } else {
            return 1 + this.next.size();
        }
    }

    /**
     * return true if the elements are sorted in ascending order.(increase)
     *
     * @return boolean (true/false) if its sorted
     */
    public boolean isSorted() {
        if (this.next == null) {
            return true;
        } else if (this.getValue() <= this.next.getValue()) {
            return this.next.isSorted();
        } else {
            return false;
        }
    }

    /**
     * return true if there is an element with given value
     *
     * @param value is the given value
     * @return true if the value is exists
     */
    public boolean existsElement(char value) {

        if (!isPredecessor(value) && this.value == value) {
            return true;
        } else if (isPredecessor(value) && this.next != null && this.next.value == value) {
            return true;
        } else if (this.next != null) {
            return this.next.existsElement(value);

        } else {
            return false;
        }

    }

    /**
     * return string in a single line containing current value and all
     * succeeding values separated by space
     *
     * @return String
     */
    public String showElements(String seperator) {

        if (this.next == null) {
            return "" + this.getValue();
        } else {

            return this.getValue() + seperator + this.next.showElements(seperator);
        }

    }

    /**
     * return value of the elements at specific position with given index
     *
     * @param index is the position of the value
     * @return the value of the given index
     */
    public char getElementAt(int index) {
        if (index == 0) {
            return this.value;
        } else if (index > 0 && this.next != null) {
            return this.next.getElementAt(index - 1);
        } else {
            return INVALID_VALUE;
        }
    }

    /**
     * inserts elements with given value at the beginning of the elements
     *
     * @param value of the element in char type
     * @return element that is added at front of the list
     */
    public Element insertElementAtFront(char value) {
        Element elem = new Element();
        elem.setValue(value);
        elem.setNext(this);
        return elem;
    }

    /**
     * insert an element with given value in given position(index)
     *
     * @param value is the given value
     * @param index of position for element
     * @return element containing the value
     */
    public Element insertElementAt(char value, int index) {
        if (index == 0) {
            return insertElementAtFront(value);
        } else if (index == 1 && this.next == null) {
            Element newElement = new Element();
            newElement.setValue(value);
            this.next = newElement;
            return this;
        } else if (index > 0 && this.next != null) {
            this.next = this.next.insertElementAt(value, index - 1);
            return this;
        } else {
            return this;
        }
    }

    /**
     *
     * @param value given value
     * @return true if this.value is a predecessor of value
     */
    private boolean isPredecessor(char value) {
        if (Character.toLowerCase(this.getValue()) < Character.toLowerCase(value)) {
            return true;
        } else if (Character.toLowerCase(this.getValue()) == Character.toLowerCase(value) && this.value < value) {
            return true;
        }
        return false;

    }

    /**
     * checks if this and the respective successor contain the same values and
     * if the the list have the same length
     *
     * @param other given element
     * @return true if the given element is the same with current
     */
    public boolean isSame(Element other) {
        if (other == null) {
            return false;
        } else if (this.next == null && other.next == null && this.value == other.value) {
            return true;
        } else if (this.next == null || other.next == null) {
            return false;
        } else if (this.value != other.value) {
            return false;
        } else {
            return this.next.isSame(other.next);
        }

    }

    public boolean TestisPredecessor(char value) {
        return isPredecessor(value);
    }
}
