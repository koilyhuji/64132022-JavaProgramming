
package javafx_tn;

public class Questions {
    String question,A,B,C,D,answer;
    String imagePath;

    public Questions(String question, String a, String b, String c, String d, String answer, String imagePath) {
        this.question = question;
        this.A = a;
        this.B = b;
        this.C = c;
        this.D = d;
        this.answer = answer;
        this.imagePath = imagePath;
    }

    public Questions() {
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getA() {
        return A;
    }

    public void setA(String a) {
        A = a;
    }

    public String getB() {
        return B;
    }

    public void setB(String b) {
        B = b;
    }

    public String getC() {
        return C;
    }

    public void setC(String c) {
        C = c;
    }

    public String getD() {
        return D;
    }

    public void setD(String d) {
        D = d;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}