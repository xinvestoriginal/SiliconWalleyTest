package ru.xinvestoriginal.siliconwalleytest.models;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by x-inv on 04.11.2017.
 */

@Root(name = "message")
public class Message {
    @ElementList(inline = true)
    public List<PointItem> points;
}
