package com.example.recyclerviewtest1;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/12/24.
 */

public class TypeTwoViewHolder extends TypeAbstractViewHolder<DataModelTwo> {

    public ImageView avatar;
    public TextView name;
    public TextView content;
    public TypeTwoViewHolder(View itemView) {
        super(itemView);
        avatar = itemView.findViewById(R.id.avatar);
        name = itemView.findViewById(R.id.name);
        content = itemView.findViewById(R.id.content);
        itemView.setBackgroundColor(Color.BLUE);
    }

    @Override
    public void bindViewHolder(DataModelTwo model) {
        avatar.setBackgroundResource(model.avatarColor);
        name.setText(model.name);
        content.setText(model.content);

    }


}
