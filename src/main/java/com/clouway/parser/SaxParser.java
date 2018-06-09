package com.clouway.parser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class SaxParser {

    public static void main(String[] args){


        File file = new File("src/main/resources/xml1.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            NodeList personList = document.getElementsByTagName("person");
            for(int i = 0; i < personList.getLength(); i++){
                Node node = personList.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE){
                    Element person = (Element) node;
                    String id = person.getAttribute("id");
                    NodeList nameList = person.getChildNodes();
                    for(int j = 0; j < nameList.getLength(); j++){
                        Node name = nameList.item(j);
                        if(node.getNodeType() == Node.ATTRIBUTE_NODE){
                            Element personName = (Element) name;
                            String lastname = personName.getAttribute("lastname");
                            String firstname = personName.getAttribute("firstname");
                        }
                    }
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
