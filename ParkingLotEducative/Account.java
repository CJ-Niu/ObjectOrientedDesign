package Z_OOD.ParkingLotEducative;

public abstract class Account {
    private String userName;
    private String passWord;
    private AccountStatus status;
    private Person person;

    public boolean resetPassword() {
        return false;
    }
}
