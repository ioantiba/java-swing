package org.ownbit.password.manager.jarloader;

import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;

/**
 * A factory for creating RsrcURLStreamHandler objects.
 */
public class RsrcURLStreamHandlerFactory implements URLStreamHandlerFactory {
    
    /** The class loader. */
    private ClassLoader classLoader;
    
    /** The chain fac. */
    private URLStreamHandlerFactory chainFac;

    /**
     * Instantiates a new rsrc URL stream handler factory.
     *
     * @param cl the cl
     */
    public RsrcURLStreamHandlerFactory(ClassLoader cl) {
	this.classLoader = cl;
    }

    /* (non-Javadoc)
     * @see java.net.URLStreamHandlerFactory#createURLStreamHandler(java.lang.String)
     */
    public URLStreamHandler createURLStreamHandler(String protocol) {
	if ("rsrc".equals(protocol)) {
	    return new RsrcURLStreamHandler(this.classLoader);
	}
	if (this.chainFac != null) {
	    return this.chainFac.createURLStreamHandler(protocol);
	}
	return null;
    }

    /**
     * Sets the URL stream handler factory.
     *
     * @param fac the new URL stream handler factory
     */
    public void setURLStreamHandlerFactory(URLStreamHandlerFactory fac) {
	this.chainFac = fac;
    }
}