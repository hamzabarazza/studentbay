/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonn.org.studentbay.process.control.exceptions;

/**
 *
 * @author jens
 */
public class NoSuchUserOrPassword extends Exception {
    
  public NoSuchUserOrPassword() { super(); }
  public NoSuchUserOrPassword(String message) { super(message); }
  public NoSuchUserOrPassword(String message, Throwable cause) { super(message, cause); }
  public NoSuchUserOrPassword(Throwable cause) { super(cause); } 
    
}
