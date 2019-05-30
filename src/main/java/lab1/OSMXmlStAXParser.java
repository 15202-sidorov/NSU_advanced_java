package lab1;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import java.io.InputStream;

public class OSMXmlStAXParser {
    public OSMXmlStAXParser(InputStream xmlFileStream) {
        this.xmlFileStream = xmlFileStream;
    }

    public OSMStats deriveStatistics() throws XMLStreamException {
        OSMStats stats = new OSMStats();
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(this.xmlFileStream);
        while(xmlEventReader.hasNext()) {
            XMLEvent event = xmlEventReader.nextEvent();
            if (event.isStartElement()) {
                StartElement startElement = event.asStartElement();
                if (startElement.getName().getLocalPart().equals(OSMXmlStAXParser.NODE_STRING)) {
                    stats.increaseUserAlterations(
                            startElement.getAttributeByName(new QName("user")).getValue()
                    );
                }
            }
        }


        return stats;
    }

    private InputStream xmlFileStream;
    private static String NODE_STRING = "node";
}
