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
    private static Element sets;
    
    public boolean isEmpty(){
        return sets == null;
    }
    
    public boolean isSame(Set other) {

        if (this.isEmpty() && other.isEmpty()) {
            return true;
        } else if (this.isEmpty() || other.isEmpty()) {
            return false;
        } else {
            return this.isSame(other);
        }
    }
    public void addElement(char value){
        
    }
    public boolean existsElement(char value){
        if(this.isEmpty()){
            return false;
        }
        else{
            return sets.existsElement(value);
        }
    }

}
    

