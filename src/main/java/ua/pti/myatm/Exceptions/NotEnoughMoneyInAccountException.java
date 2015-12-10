package ua.pti.myatm.Exceptions;

/**
 * Created by Alex on 09.12.2015.
 */
public class NotEnoughMoneyInAccountException extends RuntimeException {
    public NotEnoughMoneyInAccountException() {}

    public NotEnoughMoneyInAccountException(String s){
        System.out.println(s);
    }
}
