package iot.empiaurhouse.mvvm.view;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DecimalFormat;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import iot.empiaurhouse.mvvm.R;
import iot.empiaurhouse.mvvm.adapters.ElementAdapter;
import iot.empiaurhouse.mvvm.adapters.ItemClickListener;
import iot.empiaurhouse.mvvm.model.Element;
import iot.empiaurhouse.mvvm.model.ElementBuilder;
import iot.empiaurhouse.mvvm.util.AlchemyKeyStore;
import iot.empiaurhouse.mvvm.viewmodel.PeriodicTableViewModel;


public class MainActivity extends AppCompatActivity {

    private static final String NOTE = "Activity::Main";
    private FloatingActionButton elementBtn;
    private RecyclerView elementRV;
    private ElementAdapter elementAdapter;
    private ProgressBar loader;
    private PeriodicTableViewModel periodicTableViewModel;
    public static final int VIEW_PERIODIC_ELEMENT = 1;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        elementBtn = findViewById(R.id.elementBtn);
        elementRV = findViewById(R.id.elementRV);
        loader = findViewById(R.id.loader);
        periodicTableViewModel = new ViewModelProvider(this).get(PeriodicTableViewModel.class);
        periodicTableViewModel.init();
        periodicTableViewModel.getElementsLiveData().observe(this, new Observer<List<Element>>() {
            @Override
            public void onChanged(@Nullable List<Element> elements) {
                elementAdapter.notifyDataSetChanged();
            }
        });
        periodicTableViewModel.getUpdateStatus().observe(this, aBoolean -> {
            if(aBoolean){
                displayLoader();
            }else {
                hideLoader();
                elementRV.smoothScrollToPosition(periodicTableViewModel.getElementsLiveData().getValue().size()-1);
            }

        });

        elementBtn.setOnClickListener(view -> {
            Element stagedElement = new ElementBuilder().generate();
            periodicTableViewModel.addLiveData(stagedElement);
        });

        initElementRV();
    }


    private void initElementRV(){
        elementAdapter = new ElementAdapter(periodicTableViewModel.getElementsLiveData().getValue(), this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        elementRV.setLayoutManager(layoutManager);
        elementRV.setAdapter(elementAdapter);
        elementAdapter.setItemClickListener(new ItemClickListener() {
            @Override
            public void onUserItemClicked(Element element) {
                Intent intent = new Intent(MainActivity.this,ElementViewActivity.class);
                intent.putExtra(AlchemyKeyStore.ELEMENT_NAME, element.getElementName());
                intent.putExtra(AlchemyKeyStore.ELEMENT_SYMBOL, element.getElementSymbol());
                intent.putExtra(AlchemyKeyStore.ELEMENT_GROUP, element.getElementGroup());
                intent.putExtra(AlchemyKeyStore.ATOMIC_NUMBER, element.getAtomicNumber().toString());
                DecimalFormat df = new DecimalFormat("#0.######");
                intent.putExtra(AlchemyKeyStore.ATOMIC_WEIGHT, df.format(element.getAtomicWeight()));
                intent.putExtra(AlchemyKeyStore.IMAGE_URL, element.getImageUrl());
                startActivityForResult(intent, VIEW_PERIODIC_ELEMENT);


            }
        });

    }




    private void displayLoader(){
        loader.setVisibility(View.VISIBLE);
    }

    private void hideLoader(){
        loader.setVisibility(View.GONE);
    }


}
