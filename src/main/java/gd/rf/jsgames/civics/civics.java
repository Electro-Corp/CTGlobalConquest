package gd.rf.jsgames.civics;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.util.ArrayList;
public class civics {
private String name = "";
private ArrayList<civic> civi = new ArrayList<>();
public civics(String name){
this.name = name;
}
public void coc(){
try{
File file = new File(name);
DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
Document doc = dBuilder.parse(file);
doc.getDocumentElement().normalize();
System.out.println("root of xml file" +
doc.getDocumentElement().getNodeName());
NodeList nodes = doc.getElementsByTagName("item");
System.out.println("==========================");

for (int i = 0; i < nodes.getLength(); i++) {
Node node = nodes.item(i);

if (node.getNodeType() == Node.ELEMENT_NODE) {
Element element = (Element) node;
System.out.println("CIVIC NAME: " + getValue("name", element)+ " LOADED");
civi.add(new civic(getValue("name",element)));
}
}
}catch(Exception e){
e.printStackTrace();
}
}
private static String getValue(String tag, Element element) {
NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
Node node = (Node) nodes.item(0);
return node.getNodeValue();
}
}
