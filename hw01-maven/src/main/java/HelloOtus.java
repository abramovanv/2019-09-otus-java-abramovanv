import static com.google.common.base.Strings.*;

public class HelloOtus {
    private String s;

    public HelloOtus(String sinput) {

        GuavaExample(sinput);

    }

    private void GuavaExample(String s1) {

        s1 = nullToEmpty(s1);
        s1 = emptyToNull(s1);
        if (isNullOrEmpty(s1)) {
            System.out.println("Empty ");
        }
        s=s1;
    }

    public String GetResult() {
        return s;
    }

}