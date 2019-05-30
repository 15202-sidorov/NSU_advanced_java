package lab1;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.util.StreamReaderDelegate;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import lab1.JAXBGenerated.Node;
import lab1.JAXBGenerated.Osm;
import org.eclipse.persistence.oxm.XMLConstants;


public class OSMXmlJAXBParser {

    public OSMXmlJAXBParser(InputStream xmlInputStream)
            throws XMLStreamException, JAXBException {
        this.xmlInputFactory = XMLInputFactory.newFactory();
        this.xmlInputStream = xmlInputStream;
        XMLStreamReader xsr = this.xmlInputFactory.createXMLStreamReader(xmlInputStream);
        this.xmlInputStreamReader = new XsiTypeReader(xsr);

        this.jaxbContext = JAXBContext.newInstance(Osm.class);
        this.unmarshaller = jaxbContext.createUnmarshaller();

    }

    public OSMStats deriveStatistics() throws JAXBException {
        Osm resultUsm = (Osm)this.unmarshaller.unmarshal(this.xmlInputStreamReader);
        List<Node> nodes = resultUsm.getNode();
        OSMStats resultStats = new OSMStats();
        for (Node node : nodes) {
            resultStats.increaseUserAlterations(node.getUser());
        }

        return resultStats;
    }

    private InputStream xmlInputStream;
    private XMLStreamReader xmlInputStreamReader;
    private XMLInputFactory xmlInputFactory;
    private JAXBContext jaxbContext;
    private Unmarshaller unmarshaller;

    private static class XsiTypeReader extends StreamReaderDelegate {

        public XsiTypeReader(XMLStreamReader reader) {
            super(reader);
        }

        @Override
        public String getAttributeNamespace(int arg0) {
            if("type".equals(getAttributeLocalName(arg0))) {
                return XMLConstants.SCHEMA_INSTANCE_URL;
            }
            return super.getAttributeNamespace(arg0);
        }

    }
}
