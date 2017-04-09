package com.moe.finalproject;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.moe.finalproject.R;

import java.util.ArrayList;

public class LivingRoom extends BaseActivity {

    private ListView roomList;
    private ArrayList<RoomData> roomItems;
    private RoomAdapter roomAdapter;

    private SQLiteDatabase db;



   /* private String[] allColumns = { DatabaseHelper.COLUMN_ROOM_ID,

            DatabaseHelper.COLUMN_LIVING_ROOM_DEVICE_TITLE, DatabaseHelper.COLUMN_LIVING_ROOM_DEVICE_IMAGE,
            DatabaseHelper.COLUMN_LIVING_ROOM_DEVICE_TYPE,
            DatabaseHelper.COLUMN_LIVING_ROOM_LAST_VISITED, DatabaseHelper.COLUMN_LIVING_ROOM_CREATED};
    private boolean isFrameLoaded;
    private FrameLayout livingRoomFrame;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_living_room);
        getSupportActionBar().setTitle("Living Room");



        final boolean isTablet = findViewById(R.id.livingRoomFrame) != null;

        roomItems = new ArrayList<>();

        roomList = (ListView) findViewById(R.id.roomItems);

        db = getDbHelper().getWritableDatabase();

        roomAdapter = new RoomAdapter(this);

        roomList.setAdapter(roomAdapter);

        roomItems.add(new RoomData(0, "TV", "@drawable/tv", RoomData.item_TV));
        roomItems.add(new RoomData(1, "Light1", "@drawable/lamp", RoomData.item_Light1));
        roomItems.add(new RoomData(2, "Light2", "@drawable/lamp", RoomData.item_Light2));
        roomItems.add(new RoomData(3, "Light3", "@drawable/lamp", RoomData.item_Light3));
        roomItems.add(new RoomData(4, "Blinding", "@drawable/blind", RoomData.item_Blinding));

        roomList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
                Object o = roomList.getItemAtPosition(position);
                RoomData itemData = (RoomData) o;
                Bundle data = new Bundle();

                data.putString("id", Long.toString(id));
                data.putString("itemTitle", roomItems.get(position).getTitle());
                data.putString("itemImage", roomItems.get(position).getImageUri());
                data.putString("deviceType", Integer.toString(itemData.getDeviceType()));

                Intent intent = null;
if(!isTablet) {
    if (position == 0)
        intent = new Intent(LivingRoom.this, TVDetails.class);
    else if (position == 1)
        intent = new Intent(LivingRoom.this, LightDetails.class);
    else if (position == 2)
        intent = new Intent(LivingRoom.this, LightDetails.class);
    else if (position == 3)
        intent = new Intent(LivingRoom.this, LightDetails.class);
    else if (position == 4)
        intent = new Intent(LivingRoom.this, BlindingDetails.class);

    intent.putExtras(data);
    startActivity(intent);
}
else {
    Fragment f = null;
    if(position == 0)
        f = new TVFragment();
    else if(position == 1)
        f = new Light1();
    else if (position ==2)
        f = new Light2();
    else if (position ==3)
        f = new Light3();
    else if(position == 4)
        f = new Blinding();
    f.setArguments(data);

    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
    ft.replace(R.id.livingRoomFrame, f);
    ft.commit();

}

            }
        });

    }

   

    private class RoomAdapter extends ArrayAdapter<RoomData> {

        public RoomAdapter(Context context) {
            super(context, 0);
        }

        public int getCount() {
            return roomItems.size();
        }

        public long getItemId(int position) { return roomItems.get(position).get_id();}
        public RoomData getItem(int position) {
            return roomItems.get(position);
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






    private class GetRoomItems extends AsyncTask<Object, Object, Object> {

        @Override
        protected Object doInBackground(Object... params) {

            listItems();

            return null;
        }

        private void listItems() {
        }

        @Override
        protected void onPostExecute(Object result) {

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
}
