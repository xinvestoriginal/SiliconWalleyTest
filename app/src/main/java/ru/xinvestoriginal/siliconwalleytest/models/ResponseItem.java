package ru.xinvestoriginal.siliconwalleytest.models;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by x-inv on 04.11.2017.
 */
@Root(name = "response")
public class ResponseItem {
    @Element(name = "code")
    public String code;

    @Element(name="message")
    public Message message;

    public ResponseItem(){

    }
}
