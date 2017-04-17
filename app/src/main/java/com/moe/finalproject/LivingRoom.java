package com.moe.finalproject;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moe.finalproject.R;

import java.util.ArrayList;

public class LivingRoom extends BaseActivity {

    private ListView roomList;
    private ArrayList<RoomDataBase> roomArrayList;
    private RoomAdapter roomAdapter;
    private boolean isTablet;
    private FrameLayout livingRoomFrame;
    private DatabaseHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_living_room);

        livingRoomFrame = (FrameLayout) findViewById(R.id.livingRoomFrame);
        isTablet = (livingRoomFrame != null);
        roomList = (ListView) findViewById(R.id.roomItems);
        roomArrayList = new ArrayList<>();
        dbHelper = new DatabaseHelper(this);
        roomAdapter = new RoomAdapter(this);

        roomList.setAdapter(roomAdapter);
        readItems();


        roomArrayList.add(new RoomDataBase(0, "TV", "@drawable/tv", RoomDataBase.item_TV));
        roomArrayList.add(new RoomDataBase(1, "Light1", "@drawable/lamp", RoomDataBase.item_Light1));
        roomArrayList.add(new RoomDataBase(2, "Light2", "@drawable/lamp", RoomDataBase.item_Light2));
        roomArrayList.add(new RoomDataBase(3, "Light3", "@drawable/lamp", RoomDataBase.item_Light3));
        roomArrayList.add(new RoomDataBase(4, "Blinding", "@drawable/blind", RoomDataBase.item_Blinding));


        Button addLivingroomItems = (Button) findViewById(R.id.addlivingroomitems);
        addLivingroomItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createDeviceDialog();
            }
        });

        roomList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                dbHelper.deletlivingroomiteam(id);
                roomArrayList.remove(position);
                roomAdapter.notifyDataSetChanged();
                return false;
            }


        });

        roomList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object o = roomList.getItemAtPosition(position);
                RoomDataBase itemData = (RoomDataBase) o;
                Bundle data = new Bundle();

                data.putString("id", Long.toString(id));
                /*data.putString("itemTitle", roomArrayList.get(position).getTitle());
                data.putString("itemImage", roomArrayList.get(position).getImageUri());
                data.putString("deviceType", Integer.toString(itemData.getDeviceType()));*/

                Intent intent = null;
                if (!isTablet) {
                    if (itemData.getDeviceType() == RoomDataBase.item_TV)
                        intent = new Intent(LivingRoom.this, TVDetails.class);

                    else if (itemData.getDeviceType() == RoomDataBase.item_Light1)
                        intent = new Intent(LivingRoom.this, Light1Details.class);

                    else if (itemData.getDeviceType() == RoomDataBase.item_Light2)
                        intent = new Intent(LivingRoom.this, Light2Details.class);

                    else if (itemData.getDeviceType() == RoomDataBase.item_Light3)
                        intent = new Intent(LivingRoom.this, Light3Details.class);

                    else if (itemData.getDeviceType() == RoomDataBase.item_Blinding)
                        intent = new Intent(LivingRoom.this, BlindingDetails.class);

                    intent.putExtras(data);
                    startActivity(intent);
                } else {
                    Fragment f = null;
                    if (itemData.getDeviceType() == RoomDataBase.item_TV)
                        f = new TVFragment();
                    else if (itemData.getDeviceType() == RoomDataBase.item_Light1)
                        f = new Light1();
                    else if (itemData.getDeviceType() == RoomDataBase.item_Light2)
                        f = new Light2();
                    else if (itemData.getDeviceType() == RoomDataBase.item_Light3)
                        f = new Light3();
                    else if (itemData.getDeviceType() == RoomDataBase.item_Blinding)
                        f = new Blinding();

                    f.setArguments(data);
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.livingRoomFrame, f);
                    ft.commit();

                }

                dbHelper.saveLivingRoomItemCount(itemData.get_id());
            }
        });

    }

    public Dialog createDeviceDialog() {

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View v = inflater.inflate(R.layout.dialog_livingroom_add, null);
        builder.setView(v);

        final AlertDialog show = builder.show();

        final Button light1 = (Button) v.findViewById(R.id.addlivinglight1);
        light1.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                long id = dbHelper.insertLivingRoomItem(RoomDataBase.item_Light1, "@drawable/light");
                RoomDataBase Llight1 = new RoomDataBase(id, "", "@drawable/light", RoomDataBase.item_Light1);
                roomArrayList.add(Llight1);
                roomAdapter.notifyDataSetChanged();
                show.dismiss();

            }
        });

        final Button light2 = (Button) v.findViewById(R.id.addlivinglight2);
        light2.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                long id = dbHelper.insertLivingRoomItem(RoomDataBase.item_Light2, "@drawable/light");
                RoomDataBase Llight2 = new RoomDataBase(id, "", "@drawable/light", RoomDataBase.item_Light2);
                roomArrayList.add(Llight2);
                roomAdapter.notifyDataSetChanged();
                show.dismiss();


            }

        });

        final Button light3 = (Button) v.findViewById(R.id.addlivinglight3);
        light3.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                long id = dbHelper.insertLivingRoomItem(RoomDataBase.item_Light3, "@drawable/light");
                RoomDataBase Llight3 = new RoomDataBase(id, "", "@drawable/light", RoomDataBase.item_Light3);
                roomArrayList.add(Llight3);
                roomAdapter.notifyDataSetChanged();
                show.dismiss();


            }

        });

        final Button blinding = (Button) v.findViewById(R.id.addblinding);
        blinding.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                long id = dbHelper.insertLivingRoomItem(RoomDataBase.item_Blinding, "@drawable/blind");
                RoomDataBase Lblinding = new RoomDataBase(id, "", "@drawable/blind", RoomDataBase.item_Blinding);
                roomArrayList.add(Lblinding);
                roomAdapter.notifyDataSetChanged();
                show.dismiss();


            }

        });

        final Button tv = (Button) v.findViewById(R.id.addlivingtv);
        tv.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {


                long id = dbHelper.insertLivingRoomItem(RoomDataBase.item_TV, "@drawable/tv");
                RoomDataBase Ltv = new RoomDataBase(id, (String) getTitle(), "@drawable/tv", RoomDataBase.item_TV);
                roomArrayList.add(Ltv);
                roomAdapter.notifyDataSetChanged();
                show.dismiss();
            }

        });


        builder.setView(v);
        return builder.create();

    }

    private void readItems() {

        roomArrayList = new ArrayList<>();

        Cursor cursor = dbHelper.getLivingroom_Items();
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {

            long _id = cursor.getLong(cursor.getColumnIndex(DatabaseHelper.COLUMN_LIVINGROOM_ID));
           /* String title = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_LIVINGROOM_DEVICE_TITLE));*/
            String image = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_LIVINGROOM_DEVICE_IMAGE));
            int device_type = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_LIVINGROOM_DEVICE_TYPE));
            RoomDataBase data = new RoomDataBase(_id, "", image, device_type);
            roomArrayList.add(data);
            cursor.moveToNext();

        }

        cursor.close();
    }

    private class GetRoomItems extends AsyncTask<Object, Object, Object> {

        @Override
        protected Object doInBackground(Object... params) {

            listItems();
            try {
                Thread.sleep(3000);
            } catch (Exception e) {

            }
            return null;
        }

        private void listItems() {
        }

        @Override
        protected void onPostExecute(Object result) {
            Log.d("Waited", "Three seconds later");
            Toast.makeText(LivingRoom.this, "Welcome To Living Room App", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        new GetRoomItems().execute((Object[]) null);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }


    private class RoomAdapter extends ArrayAdapter<RoomDataBase> {

        public RoomAdapter(Context context) {
            super(context, 0);
        }

        public int getCount() {
            return roomArrayList.size();
        }

        public long getItemId(int position) {
            return roomArrayList.get(position).get_id();
        }

        public RoomDataBase getItem(int position) {
            return roomArrayList.get(position);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LivingRoom.this.getLayoutInflater();
            View result = null;

            result = inflater.inflate(R.layout.room_items, null);

            TextView roomItemText = (TextView) result.findViewById((R.id.roomItemText));
            roomItemText.setText(getItem(position).getTitle());

            ImageView roomItemImage = (ImageView) result.findViewById((R.id.roomItemImage));
            roomItemImage.setImageDrawable(ContextCompat.getDrawable(result.getContext(), getResources().getIdentifier(getItem(position).getImageUri(), null, getPackageName())));

            return result;
        }
    }
}







