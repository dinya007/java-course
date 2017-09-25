package ru.java.course.homework.reznikova.elena.two.two;

public class Account {

    Integer id;
    String firstName;
    String secondName;
    float balance;

    public Account() {
        this.id = new Integer(0);
        this.firstName = new String("");
        this.secondName = new String("");
        this.balance = 0;
    }

    public Account(Integer id, String firstName, String secondName) {
        this.id = new Integer(id);
        this.firstName = new String(firstName);
        this.secondName = new String(secondName);
        this.balance = 0;
    }

    public boolean addMoney(float amount) {
        this.balance += amount;
        return true;
    }

    public void spendMoney(float amount) throws NotSufficientAmount {
        if (this.balance >= amount) {
            this.balance -= amount;
        } else {
            throw new NotSufficientAmount();
        }
    }

    /*public boolean spendMoney (float amount)
    {
        if (this.balance >= amount) {
            this.balance -= amount;
            return true;
        }
        else
            return false;

    }*/

}
