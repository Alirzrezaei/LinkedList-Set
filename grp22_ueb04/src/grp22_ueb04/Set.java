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
    
    Set(){  
    }
    
    Set(String value){
        this.addElement(value);
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
        else if(!sets.existsElement(value)){
            sets = sets.insertElement(value);  
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
    char[] getValues() {
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
        if (!this.isEmpty()){
            unionSet = this.CloneSet(); //copy of this set
        }
        if(!other.isEmpty()){
            for (int i = 0; i < other.sets.size(); i++) {
                    unionSet.addElement(other.sets.getElementAt(i));
            }
        }
            return unionSet;
    }
    public Set intersection(Set other) {
        Set interSection = new Set();
        if (this.isEmpty() || other.isEmpty()) {
            return interSection;
        } else if (this.sets.isSame(other.sets)) {
            interSection= this.CloneSet();
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
         if (this.isEmpty()) {
            return differnece;
        } else if (other.isEmpty()) {
           
                differnece=this.CloneSet();
            
            return differnece;
        } else{
        for(int i = 0; i < this.sets.size(); i++){
            if(!other.sets.existsElement(this.sets.getElementAt(i))){
                differnece.addElement(this.sets.getElementAt(i));
            }
        }
        }return differnece;
    }
    public Set symmDiff(Set other) {
        Set symmtricDiff = new Set();
        if (this.isEmpty() && other.isEmpty()) {
            return symmtricDiff;
        } else if (this.isEmpty() || other.isEmpty()) {
            return symmtricDiff = this.union(other);
        } else {
            Set diff1 = new Set();
            diff1 = this.union(other);
            Set diff2 = new Set();
            diff2 = this.intersection(other);
            symmtricDiff = diff1.diff(diff2);
        }
        return symmtricDiff;
    }
    private Set cloneSet(){
        Set CloneSet = new Set();
        for(int i = 0; i< this.sets.size(); i++){
            CloneSet.addElement(this.sets.getElementAt(i));
        }
        return CloneSet;
    }
    public Set CloneSet(){
        return cloneSet();
    }
     private void addElement(String value){
        
        for(int i = 0; i < value.length(); i++){
            addElement(value.charAt(i));
        }
    }
   
    private void addElementList(Element list){
        for(int i = 0; i < list.size(); i++){
            if(!existsElement(list.getElementAt(i))){
                sets = sets.insertElement(list.getElementAt(i));
            }
        }
    }
  

  
}
    

