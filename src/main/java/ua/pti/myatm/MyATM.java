package ua.pti.myatm;

public class MyATM {

    public static void main(String[] args) {
        double moneyInATM = 1000;
        ATM atm = new ATM(moneyInATM);
        Card card = null;
        atm.validateCard(card, 1234);
        atm.checkBalance(card, 7777);
        atm.getCash(999.99,1234, card);
    }
}
