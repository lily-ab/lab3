package lab3;


import org.w3c.dom.Document;

public class Handler{
    private IConverter converter;
    private IInputStream inputStream;
    private IOutputStream outputStream;

    private String xmlPath;
    private String jsonPath;

    protected Handler(String xmlPath, String jsonPath){
        this.jsonPath=jsonPath;
        this.xmlPath=xmlPath;
    }
    public void setConverter(IConverter converter) {
        this.converter = converter;
    }
    public void setInputStream(IInputStream inputStream){
        this.inputStream=inputStream;
    }
    public void setOutputStream(IOutputStream outputStream){
        this.outputStream=outputStream;
    }

    public void setXmlPath(String xmlPath) {
        this.xmlPath = xmlPath;
    }

    public void setJsonPath(String jsonPath) {
        this.jsonPath = jsonPath;
    }

    public void Handle(){
        inputStream.setPath(xmlPath);
        inputStream.read();
        Document doc=converter.getXMLDocument(inputStream.getInputStream());
        outputStream.setPath(jsonPath);
        outputStream.write(converter.convert(doc));
    }
}
