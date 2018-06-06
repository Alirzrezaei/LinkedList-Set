/*
 * This class gets values from the arguments from main Class and store the arguments 
into two sets. then it compares two sets and make UnionSet , IntersectionSet , Set Difference and
Symmetric Difference
 */
package grp22_ueb04;

/**
 *
 * @author Alireza
 */
public class Set {

    Element sets;

    /**
     * this is a constructor without any parameter
     */
    Set() {
    }

    /**
     * it is another constructor that gets a parameter as a string type to make
     * a set of tha string
     *
     * @param value is the given string
     */
    Set(String value) {
        this.addElement(value);
    }

    /**
     * check the set if there is no member
     *
     * @return true if the set is empty
     */
    public boolean isEmpty() {
        return sets == null;
    }

    /**
     * this method return the size of the set
     *
     * @return the size of the set
     */
    public int size() {
        if (isEmpty()) {
            return 0;
        } else {
            return this.sets.size();
        }
    }

    /**
     * checks if the given set contain the same values as the current one
     *
     * @param other is the given set
     * @return true if the current and given set are the same
     */
    public boolean isSame(Set other) {

        if (this.isEmpty() && other.isEmpty()) {
            return true;
        } else if (this.isEmpty() || other.isEmpty()) {
            return false;
        } else {
            return sets.isSame(other.sets);
        }
    }

    /**
     * add Element with the given value if the value does not exist.
     *
     * @param value is the given value
     */
    public void addElement(char value) {
        if (isEmpty()) {
            sets = new Element();
            sets.setValue(value);
        } else if (!sets.existsElement(value)) {
            sets = sets.insertElement(value);
        }
    }

    /**
     * checks if the given value already exists in the element list
     *
     * @param value given value
     * @return true if the value is exists in the set
     */
    public boolean existsElement(char value) {
        if (isEmpty()) {
            return false;
        } else {
            return sets.existsElement(value);
        }
    }

    /**
     * deletes an element with this value
     *
     * @param value is the given value
     */
    public void deleteElement(char value) {
        if (isEmpty()) {
        } else {
            sets = sets.deleteElement(value);
        }
    }

    /**
     * return a string that represents the values of the set enclosing curl
     * brackets
     *
     * @param seperator
     * @return a string of the values of set
     */
    public String showValues(String seperator) {
        if (isEmpty()) {
            return "{}";
        } else {
            return "{" + sets.showElements(seperator) + "}";
        }
    }

    /**
     *
     * @returns all elements of the set in an array
     */
    char[] getValues() {
        char[] values = new char[size()];
        if (!isEmpty()) {
            for (int i = 0; i < values.length; i++) {
                values[i] = sets.getElementAt(i);
            }
        }
        return values;
    }

    /**
     *
     * @param other is the given set
     * @return a new set which represents the union of the current with the
     * given set
     */
    public Set union(Set other) {
        Set unionSet = new Set();
        unionSet.addElementList(other.sets);
        unionSet.addElementList(this.sets);
        return unionSet;
    }

    /**
     *
     * @param other is the given set
     * @return return a new set which represents the intersection of the current
     * with the given set
     */
    public Set intersection(Set other) {
        Set interSection = new Set();
        if (this.isEmpty() || other.isEmpty()) {
            return interSection;
        } else if (this.sets.isSame(other.sets)) {
            interSection = this.CloneSet();
        } else {
            for (int i = 0; i < other.sets.size(); i++) {
                if (this.sets.existsElement(other.sets.getElementAt(i))) {
                    interSection.addElement(other.sets.getElementAt(i));
                }
            }

        }
        return interSection;
    }

    /**
     *
     * @param other is the given set
     * @return a new set which represents the difference of the current with the
     * given set
     */
    public Set diff(Set other) {
        Set differnece = new Set();
        if (this.isEmpty()) {
            return differnece;
        } else if (other.isEmpty()) {

            differnece = this.CloneSet();

            return differnece;
        } else {
            for (int i = 0; i < this.sets.size(); i++) {
                if (!other.sets.existsElement(this.sets.getElementAt(i))) {
                    differnece.addElement(this.sets.getElementAt(i));
                }
            }
        }
        return differnece;
    }

    /**
     *
     * @param other given set
     * @return a new set which represents the symmetric difference of the
     * current with the given set
     */
    public Set symmDiff(Set other) {
        return (this.union(other).diff(this.intersection(other)));
    }

    /**
     * creates a copy of the current set
     *
     * @return a set which is copy of the set
     */
    private Set CloneSet() {
        return (new Set().union(this));
    }

    /**
     * adds to the current list all values which are not in the current.
     *
     * @param value given string
     */
    private void addElement(String value) {
        if (value != null) {
            for (int i = 0; i < value.length(); i++) {
                addElement(value.charAt(i));
            }
        }
    }

    /**
     * adds every character of the string to list as parameter
     *
     * @param list given element
     */
    private void addElementList(Element list) {
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                addElement(list.getElementAt(i));
            }
        }

    }

}
