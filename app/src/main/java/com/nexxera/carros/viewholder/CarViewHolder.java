package com.nexxera.carros.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.nexxera.carros.R;
import com.nexxera.carros.entity.Car;
import com.nexxera.carros.listner.OnClickInteractionListner;

public class CarViewHolder extends RecyclerView.ViewHolder {

  private ImageView mImgCarPicture;
  private TextView mTextCarModel;
  private TextView mTextViewDetails;


  public CarViewHolder(@NonNull View itemView) {
    super(itemView);
    this.mTextCarModel = (TextView) itemView.findViewById(R.id.text_car_model);
    this.mImgCarPicture = (ImageView) itemView.findViewById(R.id.image_car_pic);
    this.mTextViewDetails = (TextView) itemView.findViewById(R.id.text_car_details);
  }

  public void bindData(final Car car, final OnClickInteractionListner listener){
    this.mTextCarModel.setText(car.model);
    this.mImgCarPicture.setImageDrawable(car.picture);
    this.mTextViewDetails.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        listener.onClick(car.id);
      }
    });
  }
}
