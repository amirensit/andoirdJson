package choubanidev.ensit.com.tp1ex5;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;




public class EtudiantAdapter extends RecyclerView.Adapter<EtudiantAdapter.EtudiantHolder>  {
    private Context context;
    private LayoutInflater inflater;
    List<Etudiant> data ;

    Etudiant etudiant;

    public EtudiantAdapter(Context context,List<Etudiant> data){
        this.context=context;
        inflater=LayoutInflater.from(context);
        this.data=data;
    }

    public EtudiantHolder onCreateViewHolder(ViewGroup parent,int viewType)
    {
        View view=inflater.inflate(R.layout.etudiantinfo,parent,false);
        EtudiantHolder holder=new EtudiantHolder(view);
        return  holder;
    }


    public void onBindViewHolder(EtudiantHolder holder, int position) {
        etudiant=data.get(position);
        holder.nom.setText(etudiant.getNom());
        holder.email.setText(etudiant.getEmail());
        holder.abs.setText(""+etudiant.getAbs());
        holder.option.setText(etudiant.getOption());
        Glide.with(context).load("http://gestionetudiants-samplewalid.rhcloud.com/images/"+etudiant.getAvatar()).into(holder.avatar);
        /*
        String uri = "@drawable/"+etudiant.getAvatar();

        int imageResource = context.getResources().getIdentifier(uri, null, context.getPackageName());


        Drawable res = context.getResources().getDrawable(imageResource);
        holder.avatar.setImageDrawable(res);*/
        //holder.avatar.setImageResource(etudiant.getAvatar());

    }

public  int getItemCount()
{
    return data.size();
}




    class EtudiantHolder extends RecyclerView.ViewHolder {
        public TextView nom;
        public TextView email;
        public TextView option;
        public TextView abs;
        public ImageView avatar;

        public  EtudiantHolder(View ItemView)
        {
            super(ItemView);
            nom=(TextView)ItemView.findViewById(R.id.nom);
            email=(TextView)ItemView.findViewById(R.id.email);
            abs=(TextView)ItemView.findViewById(R.id.abs);
            option=(TextView)ItemView.findViewById(R.id.option);
            avatar=(ImageView) ItemView.findViewById(R.id.avatar);

        }

    }




}
