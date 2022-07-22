package org.example.utils;

import org.example.config.DataSourceConfig;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XmlParser {

    private static final String tag_sourceName = "source-name";
    private static final String tag_connectionUrl = "connection-url";
    private static final String tag_driverClass = "driver-class";
    private static final String tag_userName = "user-name";
    private static final String tag_password = "password";


    public static DataSourceConfig convertFromXml(File source, boolean validating)
            throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(validating);

        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(source);

        DataSourceConfig config = new DataSourceConfig();

        Node datasourcesNode = document.getLastChild();
        NodeList datasourcesChildNodes = datasourcesNode.getChildNodes();

        String sourceName = null;
        String connectionUrl = null;
        String driverClass = null;
        String userName = null;
        String password = null;
        String url;

        for (int i = 0; i < datasourcesChildNodes.getLength(); i++) {
            if (datasourcesChildNodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
                NodeList datasourceChildNodes = datasourcesChildNodes.item(i).getChildNodes();

                for (int j = 0; j < datasourceChildNodes.getLength(); j++) {
                    if (datasourceChildNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {
                        switch (datasourceChildNodes.item(j).getNodeName()) {
                            case tag_sourceName:
                                sourceName = datasourceChildNodes.item(j).getTextContent();
                                break;
                            case tag_connectionUrl:
                                connectionUrl = datasourceChildNodes.item(j).getTextContent();
                                break;
                            case tag_driverClass:
                                driverClass = datasourceChildNodes.item(j).getTextContent();
                                break;
                            case tag_userName:
                                userName = datasourceChildNodes.item(j).getTextContent();
                                break;
                            case tag_password:
                                password = datasourceChildNodes.item(j).getTextContent();
                                break;
                        }
                    }
                }
                url = connectionUrl + "/" + sourceName;
                config.setUrl(url);
                config.setUserName(userName);
                config.setPassword(password);
                config.setDriver(driverClass);
            }
        }
        return config;
    }
}
