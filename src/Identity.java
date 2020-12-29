public class Identity {
    public String passWord;

    public final void checkPassWord(String passWord){
        this.passWord=passWord;
        for (int i=0;i<=passWord.length();i++){
            if (    this.passWord.length()>=8 &&
                    Character.isUpperCase(this.passWord.charAt(i)) &&
                    Character.isLowerCase(this.passWord.charAt(i)) &&
                        Character.isDigit(this.passWord.charAt(i))){

                System.out.println("OK");

            }
            else {
                System.out.println("WRONG");
            }
        }
        }

}
