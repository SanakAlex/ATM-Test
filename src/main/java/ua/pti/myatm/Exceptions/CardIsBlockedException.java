package ua.pti.myatm.Exceptions;

/**
 * Created by Alex on 10.12.2015.
 */
public class CardIsBlockedException extends RuntimeException{
    public CardIsBlockedException(String s){
        System.out.println(s);
    }
}
