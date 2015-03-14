/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.clxy.tools.core.exception;

/**
 * Logic exception.
 * @author clxy
 */
public class LogicException extends RuntimeException {

    /**
     * Default serial Version.
     */
    private static final long serialVersionUID = 1L;

    public LogicException(String message, Throwable cause) {
        super(message, cause);
    }

    public LogicException(String message) {
        super(message);
    }

    public LogicException() {
    }
}
