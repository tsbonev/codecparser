package com.clouway.parser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XmlCodec implements MessageCodec{

    private final Class type;

    private JAXBContext context;
    private Marshaller marshaller;
    private Unmarshaller unmarshaller;

    public XmlCodec(Class type){
        this.type = type;

        {
            try {
                context = JAXBContext.newInstance(type);
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public Object parseFile(File file) {

        try {
            unmarshaller = context.createUnmarshaller();
            return unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public File parseObject(Object object) {

        try{
            marshaller = context.createMarshaller();
            File file = new File("src/test/resources/parsedXml.xml");
            marshaller.marshal(object, file);
            return file;
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }
}
