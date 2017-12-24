package com.example.recyclerviewtest1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/24.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int TYPE_ONE = 1;

    public static final int TYPE_TWO = 2;

    public static final int TYPE_THREE = 3 ;

    private LayoutInflater mInflater;
    //private List<DataModel> mList = new ArrayList<DataModel>();
    private List<Integer> types = new ArrayList<Integer>();
    private Map<Integer,Integer> mPositions = new HashMap<>();
    private List<DataModelOne> list1;
    private List<DataModelTwo> list2;
    private List<DataModelThree> list3;


    public RecyclerAdapter(Context context) {
        this.mInflater = LayoutInflater.from(context);
    }


    public void addList(List<DataModelOne> list1,List<DataModelTwo> list2,List<DataModelThree> list3){
        addListByType(TYPE_ONE,list1);
        addListByType(TYPE_TWO,list2);
        addListByType(TYPE_THREE,list3);

        this.list1 = list1;
        this.list2 = list2;
        this.list3 = list3;
    }

    private void addListByType(int type,List list){
        mPositions.put(type,types.size());
        for (int i =0;i<list.size();i++){
            types.add(type);

        }

    }

    @Override
    public int getItemViewType(int position) {
        return types.get(position);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case DataModel.TYPE_ONE:
                return new TypeOneViewHolder(mInflater.inflate(R.layout.item_type_one,parent,false));
            case DataModel.TYPE_TWO:
                return new TypeTwoViewHolder(mInflater.inflate(R.layout.item_type_two,parent,false));
            case DataModel.TYPE_THREE:
                return new TypeThreeViewHolder(mInflater.inflate(R.layout.item_type_three,parent,false));

        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        int realPositon = position - mPositions.get(viewType);
        switch (viewType){
            case DataModel.TYPE_ONE:
                ((TypeOneViewHolder)holder).bindViewHolder(list1.get(realPositon));
                break;
            case DataModel.TYPE_TWO:
                ((TypeTwoViewHolder)holder).bindViewHolder(list2.get(realPositon));
                break;
            case DataModel.TYPE_THREE:
                ((TypeThreeViewHolder)holder).bindViewHolder(list3.get(realPositon));
                break;
        }

        //((TypeAbstractViewHolder)holder).bindViewHolder(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return types.size();
    }
}
