/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycomparing;

import comparingstudents.Student;

/**
 *
 * @author helen
 */
public class PorovnavacStudentByFirstname implements ComparatorInterface {

    @Override
    public boolean bigger(Object o1, Object o2) {
        return (((Student)o1).getFirstname().compareTo(((Student)o2).getFirstname()) > 0);
    }
    
}
