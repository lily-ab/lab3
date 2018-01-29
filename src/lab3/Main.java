package lab3;

public class Main {

    public static void main(String[] args) {
        String xmlName="example.xml";
        String fileName= "c:\\Files\\file.json";
        Handler h=new Handler(xmlName,fileName);
        h.setConverter(new Converter());
        h.setInputStream(new FileInputStreamXML());
        h.setOutputStream(new OutputStreamJSON());
        h.Handle();

        String xmlURL="https://vk.com/doc214441979_458154461?hash=7697fd071ac4d2dc31&dl=7441d170a18e59d57e";
        String fileName1= "c:\\Files\\file1.json";
        h.setXmlPath(xmlURL);
        h.setJsonPath(fileName1);
        h.setInputStream(new URLInputStreamXML());
        h.setOutputStream(new OutputStreamJSON());
        h.Handle();
    }

}
