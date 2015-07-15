package fr.valquev.tuto4;

public interface OnItemClick {

    /*
    Plutôt que faire passer des entiers pour récupérer
    la position, on pourrait faire passer un objet Personne
    pour récupérer directement la personne en question
    */

    void onClick(int position);

    void onLongClick(int position);

}
