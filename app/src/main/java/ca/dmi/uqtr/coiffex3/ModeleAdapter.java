package ca.dmi.uqtr.coiffex3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ca.dmi.uqtr.coiffex3.modele.Modele;

public class ModeleAdapter  extends RecyclerView.Adapter<ModeleAdapter.MyViewHolder> {
    //Attributs
    private static Context context = null;
    private List<Modele> modeles;

    //Constructeur
    public ModeleAdapter(Context context) {
        super();
        this.context = context;
        modeles=new ArrayList<>();
    }
    public void addItem(Modele modele) {
        modeles.add(0, modele);
        notifyItemInserted(0);
    }

    @NonNull
    @Override
    public ModeleAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ModeleAdapter.MyViewHolder holder, int position) {
        Modele currentModele = modeles.get(position);
        holder.setModele(currentModele);
    }

    @Override
    public int getItemCount() {
        return modeles.size();
    }

    public  static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nom, prix;
        ImageView img;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.item_image);
            nom = itemView.findViewById(R.id.item_nom);
            prix =  itemView.findViewById(R.id.item_prix);


        }

        public void setModele(Modele currentModele) {

            String resourceName = "tresse" + currentModele.getImg();
            int resId=context.getResources().getIdentifier(resourceName,"drawable",context.getOpPackageName());
            img.setImageResource(resId);


            nom.setText(currentModele.getNom());
            prix.setText(currentModele.getPrix()+" $");
        }
    }
}
