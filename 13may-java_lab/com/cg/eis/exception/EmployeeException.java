/*Exercise 6:  Create an Exception class named as EmployeeException (User defined Exception) in a package named as com.cg.eis.exception
and throw an exception if salary of an employee is below than 3000.
 Use Exception Handling mechanism to handle exception properly.*/
package com.cg.eis.exception;
public class EmployeeException extends Exception{
     
    public EmployeeException(String str){
        super(str);
    }
 
}