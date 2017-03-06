package com.epam.game.gameinfrastructure.parser;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.xml.sax.SAXException;

import com.epam.game.gamemodel.model.action.ActionsType;

public class XmlParserTest {
    
    private final Map<ClientsDataObject, String> testParseData = new HashMap<ClientsDataObject, String>();
    
    @Before
    public void setUpTestParse() {        
        ClientsDataObject o = new ClientsDataObject();
        String s = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><request><uid>1</uid><actions><action><from>101</from><to>202</to><unitscount>15</unitscount></action></actions></request>";
        o.setType(ActionsType.MOVE);
        Map<RequestXMLTag,String> m = new HashMap<RequestXMLTag,String>();
        m.put(RequestXMLTag.FROM, "101");
        m.put(RequestXMLTag.TO, "202");
        m.put(RequestXMLTag.UNITSCOUNT, "15");        
        o.setParams(m);
        testParseData.put(o, s);
    }

    @Test
    public void testParse() {
        try {
            XmlParser p = new XmlParser();
            
            for (Map.Entry<ClientsDataObject, String> entry : testParseData.entrySet()) {
                String v = entry.getValue();
                ClientsDataObject k = entry.getKey();
                List<ClientsDataObject> actual = p.parse(v);
//                assert(expected, actual)
            }
            
            
        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

}
