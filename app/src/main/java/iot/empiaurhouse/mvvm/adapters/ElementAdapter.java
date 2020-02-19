package iot.empiaurhouse.mvvm.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;
import iot.empiaurhouse.mvvm.R;
import iot.empiaurhouse.mvvm.databinding.PeriodicElementBinding;
import iot.empiaurhouse.mvvm.model.Element;

public class ElementAdapter extends RecyclerView.Adapter<ElementAdapter.PEViewHolder> {

    private List<Element> periodicElements = new ArrayList<>();
    private Context context;
    private ItemClickListener itemClickListener;

    public ElementAdapter(List<Element> periodicElements, Context context) {
        this.periodicElements = periodicElements;
        this.context = context;
    }


    @NonNull
    @Override
    public PEViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PeriodicElementBinding periodicElementBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.periodic_element, parent ,false);


        return new PEViewHolder(periodicElementBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PEViewHolder holder, int position) {
        Element periodicElement = periodicElements.get(position);
        holder.setElementSymbol(periodicElement.getElementSymbol());
        holder.setElementName(periodicElement.getElementName());
        holder.setAtomicNumber(periodicElement.getAtomicNumber());
        holder.setElementGroup(periodicElement.getElementGroup());
        holder.setAtomicWeight(periodicElement.getAtomicWeight());

        RequestOptions glOptions = new RequestOptions()
                .error(R.drawable.ic_launcher_background);
        Glide.with(context)
                .setDefaultRequestOptions(glOptions)
                .load(periodicElements.get(position).getImageUrl())
                .into(holder.elementImage);
    }

    @Override
    public int getItemCount() {
        return periodicElements.size();
    }

    public class PEViewHolder extends RecyclerView.ViewHolder{

        private TextView elementName;
        private TextView elementSymbol;
        private TextView atomicNumber;
        private TextView atomicWeight;
        private TextView elementGroup;
        private CircleImageView elementImage;

        void setElementName(String elementName) {
            this.elementName.setText(elementName);
        }

        void setElementSymbol(String elementSymbol) {
            this.elementSymbol.setText(elementSymbol);
        }

        void setAtomicNumber(Integer atomicNumber) {
            if(atomicNumber == null){
                atomicNumber = 0;
                String atomicNumberString = atomicNumber.toString();
                this.atomicNumber.setText(atomicNumberString);

            }else {
                this.atomicNumber.setText(atomicNumber.toString());

            }
        }

        void setAtomicWeight(BigDecimal atomicWeight) {
            if(atomicWeight == null){
                atomicWeight = new BigDecimal(0);
                String atomicWeightString = atomicWeight.toString();
                this.atomicWeight.setText(atomicWeightString);

            }else {
                DecimalFormat df = new DecimalFormat("#0.######");

                this.atomicWeight.setText(df.format(atomicWeight));

            }
        }

        void setElementGroup(String elementGroup) {
            this.elementGroup.setText(elementGroup);
        }



        private PEViewHolder(@NonNull PeriodicElementBinding periodicElementBinding) {
            super(periodicElementBinding.getRoot());
            elementName = periodicElementBinding.elementName;
            elementSymbol = periodicElementBinding.elementSymbol;
            atomicNumber = periodicElementBinding.atomicNumber;
            atomicWeight = periodicElementBinding.atomicWeight;
            elementGroup = periodicElementBinding.elementGroup;
            elementImage = periodicElementBinding.elementIcon;
            periodicElementBinding.getRoot().setOnClickListener(view -> {
                int clickedPosition = getAdapterPosition();

                if(itemClickListener !=null && clickedPosition!=RecyclerView.NO_POSITION) {
                    itemClickListener.onUserItemClicked(periodicElements.get(clickedPosition));
                    notifyItemChanged(clickedPosition);
                }
            });

        }
    }


    public void setItemClickListener(ItemClickListener listener) {
        this.itemClickListener = listener;
    }



}
