package com.shutter.soulsync;

import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;

public class Utility {


    public CollectionReference getCollectionReferenceForNotes(){

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        return FirebaseFirestore.getInstance().collection("notes").document(currentUser.getUid()).collection("my_notes");
    }

    static String timestampToString(Timestamp timestamp){
        return new SimpleDateFormat("dd/MM/yyyy").format(timestamp.toDate());
    }

}