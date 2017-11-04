package ru.xinvestoriginal.siliconwalleytest.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ru.xinvestoriginal.siliconwalleytest.R;
import ru.xinvestoriginal.siliconwalleytest.models.PointItem;
import ru.xinvestoriginal.siliconwalleytest.utils.RoundedCornersTransform;


/**
 * Created by x-inv on 02.04.2017.
 */

public class PointsAdapter extends RecyclerView.Adapter<PointsAdapter.CustomViewHolder> {

    private View.OnLongClickListener listener;
    private View.OnTouchListener touchClickListener;
    private List<PointItem> items;
    private Context context;

    public PointsAdapter(Context context, List<PointItem> items, View.OnLongClickListener listener,
                         View.OnTouchListener touchClickListener){
        this.context  = context;
        this.items    = items;
        this.listener = listener;
        this.touchClickListener = touchClickListener;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.point_item,parent,false);
        return new CustomViewHolder(root);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        PointItem item = items.get(position);
        holder.tvPointItemName.setText(item.item_name);
        holder.tvPointItemPrice.setText("$" + String.format("%.2f", item.item_price).replace(",","."));
        holder.tvPointItemDistance.setText(item.point_distance + "km");
        Picasso.with(context)
                .load(item.item_image)
                .transform(new RoundedCornersTransform())
                .into(holder.ivPointItemImage);
        Picasso.with(context)
                .load(item.shop_logo)
                //.transform(new RoundedCornersTransform())
                .into(holder.ivPointItemLogo);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder{

        private View mainView;

        private TextView tvPointItemName;
        private TextView tvPointItemPrice;
        private TextView tvPointItemDistance;

        private ImageView ivPointItemImage;
        private ImageView ivPointItemLogo;

        public CustomViewHolder(View itemView) {
            super(itemView);
            mainView = itemView;
            tvPointItemName     = (TextView)mainView.findViewById(R.id.tvPointItemName);
            tvPointItemPrice    = (TextView)mainView.findViewById(R.id.tvPointItemPrice);
            tvPointItemDistance = (TextView)mainView.findViewById(R.id.tvPointItemDistance);
            ivPointItemImage    = (ImageView)mainView.findViewById(R.id.ivPointItemImage);
            ivPointItemLogo     = (ImageView)mainView.findViewById(R.id.ivPointItemLogo);
        }
    }

}
