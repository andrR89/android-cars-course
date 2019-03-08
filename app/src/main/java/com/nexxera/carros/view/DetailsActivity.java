package com.nexxera.carros.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.nexxera.carros.CarsContants;
import com.nexxera.carros.R;
import com.nexxera.carros.data.CarMock;
import com.nexxera.carros.entity.Car;


public class DetailsActivity extends AppCompatActivity {

  private ViewHolder mViewHolder = new ViewHolder();
  private CarMock mCarMock;
  private Car mCar;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_details);

    getSupportActionBar().setDisplayShowTitleEnabled(false);
    getSupportActionBar().setDisplayShowHomeEnabled(true);
    getSupportActionBar().setIcon(R.mipmap.ic_launcher);

    this.mCarMock = new CarMock(this);

    this.mViewHolder.imgCarPicture = this.findViewById(R.id.image_car_pic);
    this.mViewHolder.textModel = (TextView) this.findViewById(R.id.text_car_model);
    this.mViewHolder.textHorsePower = (TextView) this.findViewById(R.id.text_horse_power);
    this.mViewHolder.textPrice = (TextView) this.findViewById(R.id.text_car_price);
    this.mViewHolder.textManucature = (TextView) this.findViewById(R.id.text_car_manufactor);

    this.getDataFromActivity();

  }

  private void setData(){
    this.mViewHolder.imgCarPicture.setImageDrawable(this.mCar.picture);
    this.mViewHolder.textManucature.setText(this.mCar.manufacturer);
    this.mViewHolder.textModel.setText(this.mCar.model);
    this.mViewHolder.textPrice.setText("R$: "+ String.valueOf(this.mCar.price));
    this.mViewHolder.textHorsePower.setText(String.valueOf(this.mCar.horsePower));
  }

  private void getDataFromActivity(){
    Bundle extras = getIntent().getExtras();
    if(extras != null){
      this.mCar = this.mCarMock.get(extras.getInt(CarsContants.CARRO_ID));
      this.setData();
    }

  }

  private static class ViewHolder{
    TextView textModel;
    TextView textHorsePower;
    TextView textPrice;
    TextView textManucature;
    ImageView imgCarPicture;
  }
}
