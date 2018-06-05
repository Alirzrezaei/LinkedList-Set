/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grp22_ueb04;

/**
 *
 * @author Alireza
 */
public class Set {
    Element sets;
    
    public Set(){
        
    }
    public Set(String value){
        this.addElement(value);
    }
    public void addElement(String value){
        
        for(int i = 0; i < value.length(); i++){
            this.addElement(value.charAt(i));
        }
    }
    public void addElementList(Element list){
        for(int i = 0; i < list.size(); i++){
            if(!this.sets.existsElement(list.getElementAt(i))){
                this.sets.insertElement(list.getElementAt(i));
            }
        }
    }
    public boolean isEmpty(){
        return sets == null;
    }
    public int size(){
        if(isEmpty()){
            return 0;
        }
        else{
            return this.sets.size();
        }
    }
    
    public boolean isSame(Set other) {

        if (this.isEmpty() && other.isEmpty()) {
            return true;
        } else if (this.isEmpty() || other.isEmpty()) {
            return false;
        } else {
            return sets.isSame(other.sets);
        }
    }
    public void addElement(char value){
        if(isEmpty()){
           sets = new Element();
            sets.setValue(value);
        }
        else {
            if(!this.sets.existsElement(value)){
            sets = sets.insertElement(value);
            }
        }
    }
    public boolean existsElement(char value){
        if(isEmpty()){
            return false;
        }
        else{
            return sets.existsElement(value);
        }
    }
    public void deleteElement(char value){
        if(isEmpty()){
        }
        else{
            sets = sets.deleteElement(value);
        }
    }
    public String showValues(String seperator) {
        if (isEmpty()) {
            return "{}";
        } else {
            return "{" + sets.showElements(seperator) + "}";
        }
    }
    public char[] getValues() {
        char[] values = new char[size()];
        if (!isEmpty()) {
            for (int i = 0; i < values.length; i++) {
                values[i] = sets.getElementAt(i);
            }
        }
        return values;
    }
    public Set union(Set other) {
        Set unionSet = new Set();
        if (this.isEmpty() && other.isEmpty()) {
            return unionSet;
        } else {
            unionSet.cloneSet(); //copy of this set
            for (int i = 0; i < other.sets.size(); i++) {
                if (!unionSet.existsElement(other.sets.getElementAt(i))) {
                    unionSet.addElement(other.sets.getElementAt(i));
                }
            }
            return unionSet;
        }

    }
    public Set intersection(Set other) {
        Set interSection = new Set();
        if (this.isEmpty() || other.isEmpty()) {
            return interSection;
        } else if (this.sets.isSame(other.sets)) {
            interSection.cloneSet();
        } else {
            for (int i = 0; i < other.sets.size(); i++) {
                if (this.sets.existsElement(other.sets.getElementAt(i))) {
                    interSection.addElement(other.sets.getElementAt(i));
                }
            }
          
        }  return interSection;
    } 
    public Set diff(Set other){
        Set differnece = new Set();
        for(int i = 0; i < this.sets.size(); i++){
            if(!other.sets.existsElement(this.sets.getElementAt(i))){
                differnece.addElement(this.sets.getElementAt(i));
            }
        }return differnece;
    }
    public Set symmDiff(Set other) {
        Set symmtricDiff = new Set();
        if (this.isEmpty() && other.isEmpty()) {
            return symmtricDiff;
        } else if (this.isEmpty() || other.isEmpty()) {
            return symmtricDiff = union(other);
        } else {
            Set diff1 = new Set();
            diff1 = union(other).cloneSet();
            Set diff2 = new Set();
            diff2 = intersection(other).cloneSet();
            symmtricDiff = diff1.diff(diff2);
        }
        return symmtricDiff;
    }
    public Set cloneSet(){
        Set CloneSet = new Set();
        for(int i = 0; i< this.sets.size(); i++){
            CloneSet.addElement(this.sets.getElementAt(i));
        }
        return CloneSet;
    }

  
}
    

