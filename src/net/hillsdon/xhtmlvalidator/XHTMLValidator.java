package net.hillsdon.xhtmlvalidator;


import java.io.IOException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;

/**
 * Performs XHTML validation of the given {@link InputSource}.
 * 
 * @author mth
 */
public class XHTMLValidator {

  private final XMLReader _reader;

  public XHTMLValidator() {
    try {
      final SAXParserFactory factory = SAXParserFactory.newInstance();
      factory.setNamespaceAware(true);
      factory.setValidating(true);
      SAXParser parser = factory.newSAXParser();
      _reader = parser.getXMLReader();
      _reader.setEntityResolver(new XHTMLEntityResolver());
      _reader.setErrorHandler(new ErrorHandler() {
        public void error(SAXParseException e) throws SAXException {
          throw e;
        }

        public void fatalError(SAXParseException e) throws SAXException {
          throw e;
        }

        public void warning(SAXParseException e) throws SAXException {
          throw e;
        }
      });
    }
    catch (Exception ex) {
      throw new RuntimeException("Parser configuration error", ex);
    }
  }

  public void validate(final InputSource in) throws SAXException, IOException {
    _reader.parse(in);
  }

}