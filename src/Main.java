import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Massage.userNameMassage();
        String userName=new Scanner(System.in).next();

        Massage.passWordMassage();
        String passWord=new Scanner(System.in).next();

        Identity identity=new Identity();
        identity.checkPassWord(passWord);



    }
}
