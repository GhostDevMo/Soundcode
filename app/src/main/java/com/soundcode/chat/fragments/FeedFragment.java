package com.soundcode.chat.fragments;


import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.soundcode.chat.R;
import com.soundcode.chat.model.Person;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import jagerfield.mobilecontactslibrary.Contact.Contact;
import jagerfield.mobilecontactslibrary.ImportContacts;

/**
 * A simple {@link Fragment} subclass.
 */
public class FeedFragment extends Fragment {


    private ValueEventListener valueEventListener;
    private boolean userList;
    private ArrayList<Contact> listItem2;
    private ArrayList<Person> listItem1;

    public FeedFragment() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();
        readContacts();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getPosts();
        return inflater.inflate(R.layout.feed_fragment, container, false);
    }

    private void getPosts() {

        DatabaseReference mFirebaseDatabaseReference = FirebaseDatabase.getInstance().getReference();
        Query query = mFirebaseDatabaseReference.child("posts");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Log.e("AlphaAppsTag", postSnapshot.toString() + "    ");
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    private void readContacts() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            Cursor cursor = getActivity().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
            listItem1 = new ArrayList<>();
            while (cursor.moveToNext()) {
                String contact_name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String phonenumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                Person contact = new Person();
                contact.setMyName(contact_name);
                contact.setMyNumber(phonenumber);
                listItem1.add(contact);
            }
            cursor.close();
        } else {
            ImportContacts importContacts = new ImportContacts(getActivity());
            listItem2 = importContacts.getContacts();
        }


    }
}
