package ru.xinvestoriginal.siliconwalleytest.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import ru.xinvestoriginal.siliconwalleytest.adapters.PointsAdapter;
import ru.xinvestoriginal.siliconwalleytest.presenters.MainPresenter;
import ru.xinvestoriginal.siliconwalleytest.R;
import ru.xinvestoriginal.siliconwalleytest.models.PointItem;

public class MainActivity extends AppCompatActivity implements IMain, View.OnTouchListener, View.OnLongClickListener {

    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter = MainPresenter.getInstance();
        mainPresenter.take(this);
    }

    @Override
    public void onBackPressed() {
        close();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void close() {
        mainPresenter.drop();
        finish();
    }

    @Override
    public void onItemsLoad(List<PointItem> items) {
        RecyclerView rvMainPoints = (RecyclerView)findViewById(R.id.rvMainPoints);
        rvMainPoints.setVisibility(View.VISIBLE);
        rvMainPoints.setLayoutManager(new LinearLayoutManager(this));
        PointsAdapter adapter = new PointsAdapter(this,items, this, this);
        rvMainPoints.setAdapter(adapter);
    }

    @Override
    public void onItemsError() {
        Toast.makeText(this,getString(R.string.error_connection),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setProgressBarVisible(boolean visible) {
        findViewById(R.id.pbMainPoints).setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }
}
