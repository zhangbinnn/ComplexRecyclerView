package com.example.recyclerviewtest1;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerAdapter mAdapter;
    int colors[] = {android.R.color.holo_red_dark,
            android.R.color.holo_blue_dark,
            android.R.color.holo_orange_dark};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(){

            @Override
            public int getSpanSize(int position) {
                int type = mRecyclerView.getAdapter().getItemViewType(position);
                if (type == DataModel.TYPE_THREE){
                    return gridLayoutManager.getSpanCount();
                }else {
                    return 1;
                }

            }
        });
        mRecyclerView = findViewById(R.id.recyclerView);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,
//                LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mAdapter = new RecyclerAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration(){
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                GridLayoutManager.LayoutParams layoutParams  = (GridLayoutManager.LayoutParams) view.getLayoutParams();
                int spanSize = layoutParams.getSpanSize();
                int spanIndex = layoutParams.getSpanIndex();
                outRect.top = 20;
                if (spanSize != gridLayoutManager.getSpanCount()){
                    if (spanIndex == 1){
                        outRect.left = 10;
                    }else {
                        outRect.right = 10;
                    }
                }
            }
        });
        initData();

    }

    private void initData() {
        List<DataModel> list = new ArrayList<>();
        for (int i = 0 ; i < 30 ; i ++){
            //int type = (int) ((Math.random()*3) + 1);
            int type;
            if (i < 5 || (i > 15 && i < 20)){
                type = 1 ;
            }else if (i < 10 || i > 26){
                type = 2 ;
            }else {
                type = 3 ;
            }
            DataModel data = new DataModel();
            data.avatarColor = colors[type - 1];
            data.type = type;
            data.name = "name :" +type;
            data.content = "content :" +i;
            data.contentColor = colors[(type + 1) %3];
            //// TODO: 2017/12/24 list.add
            list.add(data);
        }

        List<DataModelOne> list1 = new ArrayList<DataModelOne>();
        for (int i = 0 ; i < 10 ; i ++){
            DataModelOne data = new DataModelOne();
            data.avatarColor = colors[0];
            data.name = "name :" +1;
            //// TODO: 2017/12/24 list.add
            list1.add(data);
        }

        List<DataModelTwo> list2 = new ArrayList<DataModelTwo>();
        for (int i = 0 ; i < 10 ; i ++){
            DataModelTwo data = new DataModelTwo();
            data.avatarColor = colors[1];
            data.name = "name :" +1;
            data.content = "content";
            //// TODO: 2017/12/24 list.add
            list2.add(data);
        }

        List<DataModelThree> list3 = new ArrayList<DataModelThree>();
        for (int i = 0 ; i < 10 ; i ++){
            DataModelThree data = new DataModelThree();
            data.avatarColor = colors[2];
            data.name = "name :" +1;
            data.content = "content";
            data.contentColor =colors[2];
            list3.add(data);
        }

        mAdapter.addList(list1,list2,list3);
        mAdapter.notifyDataSetChanged();
    }
}
