package ru.xinvestoriginal.siliconwalleytest.views;

import java.util.List;

import ru.xinvestoriginal.siliconwalleytest.models.PointItem;

/**
 * Created by x-inv on 04.11.2017.
 */

public interface IMain {
    void close();
    void onItemsLoad(List<PointItem> items);
    void onItemsError();
    void setProgressBarVisible(boolean visible);
}
