package com.nexxera.carros.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.nexxera.carros.CarsContants;
import com.nexxera.carros.R;
import com.nexxera.carros.adapter.CarListAdapter;
import com.nexxera.carros.data.CarMock;
import com.nexxera.carros.entity.Car;
import com.nexxera.carros.listner.OnClickInteractionListner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  ViewHolder mViewHolder = new ViewHolder();
  private Context mContext;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    getSupportActionBar().setDisplayShowTitleEnabled(false);
    getSupportActionBar().setDisplayShowHomeEnabled(true);
    getSupportActionBar().setIcon(R.mipmap.ic_launcher);

    this.mContext = this;

    CarMock carMock = new CarMock(this);
    List<Car> carList = new ArrayList<>();
    carList.addAll(carMock.getList());

    // Obter recyclerview
    this.mViewHolder.recyclerCars = (RecyclerView) this.findViewById(R.id.recycler_cars);
    OnClickInteractionListner listener = new OnClickInteractionListner() {
      @Override
      public void onClick(int id) {
          Bundle bundle = new Bundle();
          bundle.putInt(CarsContants.CARRO_ID, id);

          Intent intent = new Intent(mContext, DetailsActivity.class);
          intent.putExtras(bundle);

          startActivity(intent);
      }
    };

    // Definir adapter
    CarListAdapter carListAdapter = new CarListAdapter(carList, listener);
    this.mViewHolder.recyclerCars.setAdapter(carListAdapter);

    // Definir Layout
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
    this.mViewHolder.recyclerCars.setLayoutManager(linearLayoutManager);
  }

  private static class ViewHolder{
    RecyclerView recyclerCars;
  }
}
