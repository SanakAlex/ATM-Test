package ua.pti.myatm;

import ua.pti.myatm.Exceptions.*;

public class ATM {

    private double moneyInATM;
    private Card card;

    //Можно задавать количество денег в банкомате 
    ATM(double moneyInATM){
        if (moneyInATM < 0)
        {
            throw new IllegalArgumentException("Incorrect argument input");
        }
        this.moneyInATM = moneyInATM;
    }

    // Возвращает количество денег в банкомате
    public double getMoneyInATM() {
        return this.moneyInATM;
    }

    //С вызова данного метода начинается работа с картой
    //Метод принимает карту и пин-код, проверяет пин-код карты и не заблокирована ли она
    //Если неправильный пин-код или карточка заблокирована, возвращаем false. При этом, вызов всех последующих методов у ATM с данной картой должен генерировать исключение NoCardInserted
    public boolean validateCard(Card card, int pinCode){
        if (card == null){
            throw new NoCardInsertedException("Incorrect card argument input");
        }
        if(card.isBlocked() || !card.checkPin(pinCode)){
            return false;
        }
        this.card = card;
        return true;
    }

    public void checkCard(){
        if (this.card == null) {
            throw new NoCardInsertedException("No card inserted");
        }
    }

    //Возвращает сколько денег есть на счету
    public double checkBalance(){
        this.checkCard();
        return this.card.getAccount().getBalance();
    }

    //Проверяет достаточно ли денег в банкомате для снятия указанной суммы
    public void isEnoughMoneyInATM(double amount){
        if(this.moneyInATM < amount){
            throw new NotEnoughMoneyInATMException("Not enough money in ATM");
        }
    }

    //Проверяет достаточно ли денег на карточке для снятия указанной суммы
    public void isEnoughMoneyInAccount(double amount){
        if(this.card.getAccount().getBalance() < amount){
            throw new NotEnoughMoneyInAccountException("Not enough money in Account");
        }
    }

    //Метод для снятия указанной суммы
    //Метод возвращает сумму, которая у клиента осталась на счету после снятия
    //Кроме проверки счета, метод так же должен проверять достаточно ли денег в самом банкомате
    //Если недостаточно денег на счете, то должно генерироваться исключение NotEnoughMoneyInAccount 
    //Если недостаточно денег в банкомате, то должно генерироваться исключение NotEnoughMoneyInATM
    //Если не прошла проверка пин кода, то метод возвращает прежнюю сумму счета
    //При успешном снятии денег, указанная сумма должна списываться со счета, и в банкомате должно уменьшаться количество денег
    public double getCash(double amount, int pinCode){
        this.checkCard();
        if (this.card.checkPin(pinCode)) {
            isEnoughMoneyInAccount(amount);
            isEnoughMoneyInATM(amount);
            this.moneyInATM -= this.card.getAccount().withdrow(amount);
            return this.card.getAccount().getBalance();
        }
        return this.card.getAccount().getBalance();
    }
}
