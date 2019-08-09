package iks.market.testcard;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class MyHolder extends RecyclerView.ViewHolder {

    TextView title, description, vendorId, vendorCode;

    MyHolder(@NonNull View itemView) {
        super(itemView);
        this.title = itemView.findViewById(R.id.documentNumber);
        this.description = itemView.findViewById(R.id.documentDescription);
        this.vendorId = itemView.findViewById(R.id.vendorId);
        this.vendorCode = itemView.findViewById(R.id.vendorCode);
    }
}
