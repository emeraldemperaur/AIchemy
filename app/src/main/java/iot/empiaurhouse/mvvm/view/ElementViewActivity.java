package iot.empiaurhouse.mvvm.view;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import de.hdodenhof.circleimageview.CircleImageView;
import iot.empiaurhouse.mvvm.R;
import iot.empiaurhouse.mvvm.databinding.ActivityElementViewBinding;
import iot.empiaurhouse.mvvm.util.AlchemyKeyStore;

public class ElementViewActivity extends AppCompatActivity {

    private ActivityElementViewBinding activityElementViewBinding;
    private ElementViewActivityClickHandlers elementViewActivityClickHandlers;
    private TextView elementSymbol;
    private TextView elementGroup;
    private TextView elementName;
    private TextView atomicViewNumber;
    private TextView atomicViewWeight;
    private TextView elementTitle;
    private CircleImageView elementImageView;
    private CardView elementCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_element_view);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        activityElementViewBinding = DataBindingUtil.setContentView(this, R.layout.activity_element_view);
        elementViewActivityClickHandlers = new ElementViewActivityClickHandlers();
        activityElementViewBinding.setClickDirector(elementViewActivityClickHandlers);
        elementTitle = activityElementViewBinding.selectedElementTitle;
        elementSymbol = activityElementViewBinding.elementViewSymbol;
        elementGroup = activityElementViewBinding.elementGroup;
        elementImageView = activityElementViewBinding.elementViewIcon;
        elementName = activityElementViewBinding.elementCardLayout.elementViewName;
        atomicViewNumber = activityElementViewBinding.elementCardLayout.atomicViewNumber;
        atomicViewWeight = activityElementViewBinding.elementCardLayout.atomicViewWeight;
        elementCardView = activityElementViewBinding.elementCardLayout.elementCardView;
        this.getElementInfo();

    }


    private void getElementInfo(){
        Intent intent = getIntent();
        String eName = intent.getStringExtra(AlchemyKeyStore.ELEMENT_NAME);
        String eSymbol = intent.getStringExtra(AlchemyKeyStore.ELEMENT_SYMBOL);
        String eGroup = intent.getStringExtra(AlchemyKeyStore.ELEMENT_GROUP);
        String aNumber = "Atomic number (Z): " + intent.getStringExtra(AlchemyKeyStore.ATOMIC_NUMBER);
        String aWeight = "Atomic Mass: " + intent.getStringExtra(AlchemyKeyStore.ATOMIC_WEIGHT);
        String iUrl = intent.getStringExtra(AlchemyKeyStore.IMAGE_URL);
        String eTitle =  eSymbol + " | " + eName;
        elementSymbol.setText(eSymbol);
        elementName.setText(eName);
        elementGroup.setText(eGroup);
        atomicViewNumber.setText(aNumber);
        atomicViewWeight.setText(aWeight);
        elementTitle.setText(eTitle);
        RequestOptions glOptions = new RequestOptions()
                .error(R.drawable.mekaico);
        Glide.with(this)
                .setDefaultRequestOptions(glOptions)
                .load(iUrl)
                .into(elementImageView);


    }


    @Override
    protected void onResume() {
        super.onResume();
        Animation fadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
        elementCardView.startAnimation(fadeIn);


    }

    @Override
    protected void onPause() {
        super.onPause();
        elementCardView.clearAnimation();

    }

    public class ElementViewActivityClickHandlers{

        public void onCloseClicked(View view){
            finish();
        }


    }



    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0)
        {
            this.moveTaskToBack(true);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


}
