package ua.pti.myatm.Exceptions;

/**
 * Created by Alex on 09.12.2015.
 */
public class NoCardInsertedException extends RuntimeException {
    public NoCardInsertedException(String s){
        System.out.println(s);
    }
}
