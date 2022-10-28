public class WrongPasswordException extends Exception {
    private String password;
    private String  confirmPassword;

    public WrongPasswordException(Throwable cause) {
        super(cause);
    }

    public WrongPasswordException(String s, String password, String confirmPassword) {
        super(s);
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
}
