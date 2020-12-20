package pl.coderslab.Spring01hibernate.testing;

public class First {

    public String concatString(String first, String second) {
        if (first == null) {
            throw new NullPointerException();
        }
        return first + second;
    }

    public int multiply(int first, int second) {
        return first * second;
    }

}
