package ru.java.course.homework.reznikova.elena.two.two;


public class AccountWithOverdraft extends Account {

    float overdraft;

    public AccountWithOverdraft() {
        super();
        this.overdraft = 0;
    }

    public AccountWithOverdraft(Integer id, String firstName, String secondName, float limit) {
        super(id, firstName, secondName);
        this.overdraft = limit;
    }

    /*@Override
    public boolean spendMoney (float amount)
    {
        if (this.balance + this.overdraft >= amount) {
            this.balance -= amount;
            return true;
        }
        else
            return false;

    }*/

    @Override
    public void spendMoney(float amount) throws NotSufficientAmount {
        if (this.balance + this.overdraft >= amount) {
            this.balance -= amount;
        } else {
            throw new NotSufficientAmount();
        }
    }
}
