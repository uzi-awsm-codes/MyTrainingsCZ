//a sax program to parse a given xml fle and print it.

import java.io.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import javax.xml.parsers.*;
public class sax extends DefaultHandler //implements ContentHandler
{
    public static void main (String argv [])  throws IOException
    {
	if (argv.length != 1) {
	    System.err.println ("Usage: cmd filename");
	    System.exit (1);
	}
	try {
	    String uri = "file:" + new File (argv [0]).getAbsolutePath ();

	    SAXParserFactory spf = SAXParserFactory.newInstance ();
	    String validation = System.getProperty (
    				"javax.xml.parsers.validation", "false");
	    if (validation.equalsIgnoreCase("true"))
	        spf.setValidating (true);
	    SAXParser sp = spf.newSAXParser ();
		XMLReader xmlReader = sp.getXMLReader();
        xmlReader.setContentHandler(new sax());
        xmlReader.setErrorHandler(new MyErrorHandler(System.err));
        xmlReader.parse(uri);



	} catch (SAXParseException err) {
	    System.out.println ("** Parsing error" + ", line " + err.getLineNumber ()
		+ ", uri " + err.getSystemId ());
	    System.out.println("   " + err.getMessage ());
	} catch (SAXException e) {
	    Exception	x = e;
	    if (e.getException () != null)
		x = e.getException ();
	    x.printStackTrace ();
	} catch (Throwable t) {
	    t.printStackTrace ();
	}
	System.exit (0);
    }
     private static class MyErrorHandler implements ErrorHandler {
        /** Error handler output goes here */
        private PrintStream out;

        MyErrorHandler(PrintStream out) {
            this.out = out;
        }

        /**
         * Returns a string describing parse exception details
         */
        private String getParseExceptionInfo(SAXParseException spe) {
            String systemId = spe.getSystemId();
            if (systemId == null) {
                systemId = "null";
            }
            String info = "URI=" + systemId +
                " Line=" + spe.getLineNumber() +
                ": " + spe.getMessage();
            return info;
        }

        // The following methods are standard SAX ErrorHandler methods.
        // See SAX documentation for more info.

        public void warning(SAXParseException spe) throws SAXException {
            out.println("Warning: " + getParseExceptionInfo(spe));
        }
        
        public void error(SAXParseException spe) throws SAXException {
            String message = "Error: " + getParseExceptionInfo(spe);
            throw new SAXException(message);
        }

        public void fatalError(SAXParseException spe) throws SAXException {
            String message = "Fatal Error: " + getParseExceptionInfo(spe);
            throw new SAXException(message);
        }
    }
	
	private Writer out;
    // here are all the SAX DocumentHandler methods
    public void setDocumentLocator (Locator l)
    {	// we'd record this if we needed to resolve relative URIs
	// in content or attributes, or wanted to give diagnostics.
    }
    public void startDocument()   throws SAXException
    {	
		//System.out.println("document started");
		try {
	    out = new OutputStreamWriter (System.out, "UTF8");
	    emit ("<?xml version='1.0' encoding='UTF-8'?>\n");
	} catch (IOException e) {
	    throw new SAXException ("I/O error", e);
	}
    }
    public void endDocument() throws SAXException
    {	try {
	    out.write ('\n');
	    out.flush ();
	    out = null;
	} catch (IOException e) {
	    throw new SAXException ("I/O error", e);
	}
    }
    public void startElement (String uri,String localName, String qname, Attributes attrs) throws SAXException
    {	
	
		emit ("<");
	emit (qname);
	if (attrs != null) {
	    for (int i = 0; i < attrs.getLength (); i++) {
		emit (" ");
		emit (attrs.getQName (i));
		emit ("=\"");
		// XXX this doesn't quote '&', '<', and '"' in the
		// way it should ... needs to scan the value and
		// emit '&amp;', '&lt;', and '&quot;' respectively
		emit (attrs.getValue (i));
		emit ("\"");
	    }
	}
	emit (">");
    }

    public void endElement (String uri,String localName,String qname) throws SAXException
    {	emit ("</");
	emit (qname);
	emit (">");
    }
    public void characters (char buf [], int offset, int len) throws SAXException
    {
	// NOTE:  this doesn't escape '&' and '<', but it should
	// do so else the output isn't well formed XML.  to do this
	// right, scan the buffer and write '&amp;' and '&lt' as
	// appropriate.

	try {
	    out.write (buf, offset, len);
	} catch (IOException e) {
	    throw new SAXException ("I/O error", e);
	}
    }
    public void ignorableWhitespace (char buf [], int offset, int len)throws SAXException
    {
	// this whitespace ignorable ... so we ignore it!
	// this callback won't be used consistently by all parsers,
	// unless they read the whole DTD.  Validating parsers will
	// use it, and currently most SAX nonvalidating ones will
	// also; but nonvalidating parsers might hardly use it,
	// depending on the DTD structure.
    }

    public void processingInstruction (String target, String data)throws SAXException
    {	emit ("<?");
	emit (target);
	emit (" ");
	emit (data);
	emit ("?>");
    }
    // helpers ... wrap I/O exceptions in SAX exceptions, to
    // suit handler signature requirements
    private void emit (String s)  throws SAXException
    {	try {
	    out.write (s);
	    out.flush ();
	} catch (IOException e) {
	    throw new SAXException ("I/O error", e);
	}
    }
}
