import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import java.io.File;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

class Main {
  public static void main(String[] args) {
    String FILENAME = "staff.xml";
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

    try{
      DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new File(FILENAME));
        doc.getDocumentElement().normalize();
        System.out.println("Root Element :" + doc.getDocumentElement().getNodeName());
        System.out.println("------");


      /*List all*/
NodeList employee = doc.getElementsByTagName("employee");
        for(int i = 0; i < employee.getLength(); i++){
          Node node = employee.item(i);
          if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
          // get text
            String firstName = element.getElementsByTagName("firstName").item(0).getTextContent();
            String lastName = element.getElementsByTagName("lastName").item(0).getTextContent();
            System.out.println(firstName + " " + lastName);
          }
        }
      /*End list all*/
      
    }catch(Exception e){
        System.out.println("Error: " + e.getMessage());
      }
  }
}