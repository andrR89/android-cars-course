package com.nexxera.carros.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nexxera.carros.R;
import com.nexxera.carros.entity.Car;
import com.nexxera.carros.listner.OnClickInteractionListner;
import com.nexxera.carros.viewholder.CarViewHolder;

import java.util.List;

public class CarListAdapter extends RecyclerView.Adapter<CarViewHolder> {

  private List<Car> mListCars;
  private OnClickInteractionListner mOnClickInteractionListner;


  public CarListAdapter(List<Car> cars, OnClickInteractionListner listner){
    this.mListCars = cars;
    this.mOnClickInteractionListner = listner;
  }

  @NonNull
  @Override
  public CarViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    Context context  = viewGroup.getContext();
    LayoutInflater inflater = LayoutInflater.from(context);

    View carView = inflater.inflate(R.layout.row_car_list, viewGroup, false);
    return new CarViewHolder(carView);
  }

  @Override
  public void onBindViewHolder(@NonNull CarViewHolder carViewHolder, int i) {
    Car car = this.mListCars.get(i);
    carViewHolder.bindData(car, this.mOnClickInteractionListner);
  }

  @Override
  public int getItemCount() {
    return mListCars.size();
  }
}
