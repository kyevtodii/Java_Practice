public class Account {

    private long money;
    private String accNumber;
    private boolean block;

    protected Account(String accNumber) {
        this.accNumber = accNumber;
        block = false;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }
    public String getAccNumber() {
        return accNumber;
    }

    public boolean isBlocked() {
        return block;
    }
    protected void setBlock() {
        this.block = true;
    }


    protected void setMoney(long money) {
        if(block) {
            System.err.println("\tACCOUNT NUMBER == " + accNumber + " == IS BLOCKED!\n");
        } else {
            this.money += money;
            System.out.println("Put " + money + " - rub. to account - " + accNumber + "." +
                    " Account balance - " + getBalance());
        }
    }

    protected void getMoney(long money) {
        if(block) {
            System.err.println("\tACCOUNT NUMBER == " + accNumber + " == IS BLOCKED!\n");
        } else {
            this.money -= money;
            System.out.println("Get " + money + " - rub. from account - " + accNumber + "." +
                    " Account balance - " + getBalance());
        }
    }

    public long getBalance() {
        return money;
    }
}
