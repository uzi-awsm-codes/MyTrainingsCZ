import java.io.*;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.xml.sax.*;
import org.xml.sax.SAXParseException;

public class DomParseXSD {

	static final String JAXP_SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";

	static final String W3C_XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";

	public static void main(String args[]) {
		Document doc;

		try {

			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
					.newInstance();

			docBuilderFactory
					.setAttribute(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);

			docBuilderFactory.setValidating(true);
			docBuilderFactory.setNamespaceAware(true);
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();

			System.out.println(docBuilder);

			System.out.println(docBuilder.isValidating());

			System.out.println(docBuilder.isNamespaceAware());

			docBuilder.setErrorHandler(new ErrorHandler() {

				public void error(SAXParseException ee) {
					System.out.println("error is " + ee.getMessage());
				}

				public void fatalError(SAXParseException ee) {
					System.out.println("fatal error is " + ee.getMessage());
				}

				public void warning(SAXParseException ee) {
					System.out.println("warning is " + ee.getMessage());
				}
			});

			doc = docBuilder.parse(new File(args[0]));

			doc.getDocumentElement().normalize();

			Node node = doc.getDocumentElement();
			System.out.println("Root element of the doc is "
					+ node.getNodeName());

			getchildren(node);

		} catch (SAXParseException err) {
			System.out.println("** Parsing error" + ", line "
					+ err.getLineNumber() + ", uri " + err.getSystemId());
			System.out.println("   " + err.getMessage());
			// print stack trace as below

		} catch (SAXException e) {
			Exception x = e.getException();

			((x == null) ? e : x).printStackTrace();

		} catch (Throwable t) {
			t.printStackTrace();
		}

		System.exit(0);
	}

	public static void getchildren(Node node) throws Exception {
		System.out.println("node name :" + node.getNodeName()
				+ "     node value is " + node.getNodeValue());

		NamedNodeMap attrs = node.getAttributes();

		if (attrs != null) {

			for (int i = 0; i < attrs.getLength(); i++) {
				System.out.println(attrs.item(i).getNodeName() + "   :    "
						+ attrs.item(i).getNodeValue());
			}
		}

		if ((node.getNodeType() == 1) && node.hasChildNodes()) {
			NodeList childlist = node.getChildNodes();

			for (int i = 0; i < childlist.getLength(); i++) {
				getchildren(childlist.item(i));
			}
		}

	}

}
