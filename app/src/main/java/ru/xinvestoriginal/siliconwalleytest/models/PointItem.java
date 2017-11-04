package ru.xinvestoriginal.siliconwalleytest.models;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by x-inv on 04.11.2017.
 */

@Root(name = "item", strict = false)
public class PointItem {
    @Element(name = "shop_logo")
    public String shop_logo;

    @Element(name = "shop_rank")
    public float shop_rank;

    @Element(name = "item_image")
    public String item_image;

    @Element(name = "item_name")
    public String item_name;

    @Element(name = "item_price")
    public float item_price;

    @Element(name = "point_distance")
    public int point_distance;
}
