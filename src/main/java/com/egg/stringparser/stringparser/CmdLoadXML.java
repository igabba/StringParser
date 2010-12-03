/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egg.stringparser.stringparser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import org.jdom.Document;
import org.jdom.input.SAXBuilder;

/**
 *
 * @author igabbarini
 */
public class CmdLoadXML {

    private InputStream aInputStream = null;

    public CmdLoadXML(FileInputStream aFile) throws FileNotFoundException {
        aInputStream = aFile;
    }

    public CmdLoadXML(InputStream aInputStream) {
        this.aInputStream = aInputStream;
    }

    public Object execute() throws Exception {
        Document document = null;

        try {
            SAXBuilder parser = new SAXBuilder();
            document = parser.build(aInputStream);
        } catch (Exception e) {
            throw new Exception(e);
        }

        return document;
    }
}
