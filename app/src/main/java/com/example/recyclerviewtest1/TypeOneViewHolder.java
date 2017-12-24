package com.example.recyclerviewtest1;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/12/24.
 */

public class TypeOneViewHolder extends TypeAbstractViewHolder<DataModelOne> {

    public ImageView avatar;
    public TextView name;
    public TypeOneViewHolder(View itemView) {
        super(itemView);
        avatar = itemView.findViewById(R.id.avatar);
        name = itemView.findViewById(R.id.name);
        itemView.setBackgroundColor(Color.GREEN);
    }

    @Override
    public void bindViewHolder(DataModelOne model) {
        avatar.setBackgroundResource(model.avatarColor);
        name.setText(model.name);

    }


}
