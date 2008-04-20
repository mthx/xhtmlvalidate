package net.hillsdon.xhtmlvalidator;

import java.io.IOException;

import junit.framework.TestCase;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class TestXHTMLValidator extends TestCase {

  private XHTMLValidator _validator = new XHTMLValidator();
  
  public void testValid() throws Exception {
    validate("valid.xhtml");
  }
  
  public void testInvalid() throws Exception {
    try {
      validate("invalid.xhtml");
      fail("SAXException expected.");
    }
    catch (SAXException ex) {
      // Error reporting could be more useful!
      assertTrue(ex.getMessage().contains("h1"));
    }
  }

  private void validate(final String resource) throws SAXException, IOException {
    _validator.validate(new InputSource(getClass().getResourceAsStream(resource)));
  }
  
}
