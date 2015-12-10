package ua.pti.myatm.Exceptions;

/**
 * Created by Alex on 09.12.2015.
 */
public class NotEnoughMoneyInATMException extends RuntimeException {
    public NotEnoughMoneyInATMException(){}

    public NotEnoughMoneyInATMException(String s){
        System.out.println(s);
    }
}
