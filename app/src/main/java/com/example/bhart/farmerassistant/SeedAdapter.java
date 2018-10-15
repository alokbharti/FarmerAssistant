package com.example.bhart.farmerassistant;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class SeedAdapter extends RecyclerView.Adapter<SeedAdapter.ViewHolder> {

    private Context context;
    private List<Product_detail> product_detailList;

    public SeedAdapter(Context context, List<Product_detail> product_detailList) {
        this.context = context;
        this.product_detailList = product_detailList;
    }

    @NonNull
    @Override
    public SeedAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.farmer_seed_detail,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SeedAdapter.ViewHolder holder, int position) {
        Product_detail detail = product_detailList.get(position);
        holder.name.setText(detail.getName());
        holder.state.setText(detail.getState());
        holder.district.setText(detail.getDistrict());
        holder.pincode.setText(detail.getPincode());
        holder.commodity.setText(detail.getCommodity());
        holder.price.setText(detail.getPrice());
        holder.weight.setText(detail.getWeight());
        holder.phone.setText(detail.getPhone());

    }

    @Override
    public int getItemCount() {
        return product_detailList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public TextView state;
        public TextView district;
        public TextView pincode;
        public TextView commodity;
        public TextView price;
        public TextView weight;
        public TextView phone;
        public Button buy;
        public ViewHolder(View itemView) {
            super(itemView);

            name=(TextView)itemView.findViewById(R.id.Farmer_Name);
            state = (TextView)itemView.findViewById(R.id.Farmer_State);
            district = (TextView)itemView.findViewById(R.id.Farmer_District);
            pincode = (TextView)itemView.findViewById(R.id.Farmer_Pincode);
            commodity = (TextView)itemView.findViewById(R.id.Farmer_Commodity);
            price = (TextView)itemView.findViewById(R.id.Farmer_Price);
            weight =(TextView)itemView.findViewById(R.id.Product_Weight);
            phone = (TextView)itemView.findViewById(R.id.phone);
            buy = (Button)itemView.findViewById(R.id.Buy_Product);
            buy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //start a new layout which buyer has to fill a form about his detail
                    String phoneNumber = phone.getText().toString();
                    Intent intent = new Intent(v.getContext(),BuyerDetail.class);
                    intent.putExtra("phone",phoneNumber);
                    v.getContext().startActivity(intent);

                }
            });
        }
    }
}
