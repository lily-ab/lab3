package lab3;

public class Main {

    public static void main(String[] args) {
        String xmlName="example.xml";
        String fileName= "c:\\Files\\file.json";
        Handler h=new Handler(xmlName,fileName, Way.FILE);
        System.out.println(h.parse());
    }

}
