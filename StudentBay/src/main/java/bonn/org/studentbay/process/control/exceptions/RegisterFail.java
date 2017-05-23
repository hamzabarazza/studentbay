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
public class RegisterFail extends Exception {

    public RegisterFail() {super();}
    public RegisterFail(String message) {super(message);}
    public RegisterFail(String message, Throwable cause) {super(message, cause);}
    public RegisterFail(Throwable cause) {super(cause);}   
}
