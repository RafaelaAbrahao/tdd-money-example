package moneyexample;

abstract class Money {
    protected int amount; //The visibility has to change from private to protected so the subclass can still see it
    protected String currency;

    Money (int amount, String currency){
        this.amount = amount;
        this.currency = currency;
    }
    abstract Money times(int multiplier);

    protected String currency() {
        return currency;
    }

    static Money dollar(int amount){
        return new Dollar(amount, "USD");
    }

    static Money franc(int amount){
        return new Franc(amount, "CHF");
    }

    public boolean equals(Object object) {
        Money money = (Money) object;
        return amount == money.amount && getClass().equals(money.getClass());
        //This ensures that the equals method only returns true if both objects are of the exact same class
    }
}

class Dollar extends Money {

    Dollar(int amount, String currency){
        super(amount, currency);
    }

    Money times(int multiplier) {
        return new Dollar(amount * multiplier, currency);
    }
}

class Franc extends Money{
    Franc(int amount, String currency){
        super(amount, currency);
    }

    Money times (int multiplier){
        return new Franc(amount * multiplier, currency);
    }
} //pagina 46