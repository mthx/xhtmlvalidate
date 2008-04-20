package net.hillsdon.xhtmlvalidator;

import java.io.IOException;

import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XHTMLEntityResolver implements EntityResolver {

  public InputSource resolveEntity(final String publicId, final String systemId) throws SAXException, IOException {
    // Mmm tail matching... quick but dirty.
    final String filename = systemId.substring(systemId.lastIndexOf('/') + 1);
    InputSource inputSource = new InputSource(XHTMLEntityResolver.class.getResourceAsStream("resources/" + filename));
    inputSource.setSystemId(systemId);
    inputSource.setPublicId(publicId);
    return inputSource;
  }

}
