package com.awesome.galleryy;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    GridView Grid_view;
    ArrayList<File> Image_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Grid_view= (GridView) findViewById(R.id.image_fence);
        Image_list= Image_viewer(new File( Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)+"/Basic"));//parsing string dir to readable file dir
        Grid_view.setAdapter(new Adapterx());
        Grid_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
             public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent in1 = new Intent(MainActivity.this,ImageryActivity.class);
                in1.putExtra("img", Image_list.get(i).toString());
                startActivity(in1);
            }
        });
    }

   //https://developer.android.com/reference/android/widget/Adapter
    //Untuk mengakses dan proses gambar sebelum ditampilkan.
    public class Adapterx extends BaseAdapter{
       @Override
       public int getCount() {
           return Image_list.size();
       }

       @Override
       public Object getItem(int i) {
           return Image_list.get(i);
       }

       @Override
       public long getItemId(int i) {
           return 0;
       }

       @Override
       public View getView(int i, View view, ViewGroup viewGroup) {
           View convert_View= null;
           if(convert_View==null)
           {
                convert_View = getLayoutInflater().inflate(R.layout.row_column_layout,viewGroup,false);
               ImageView image= (ImageView) convert_View.findViewById(R.id.images);
               image.setImageURI(Uri.parse(Image_list.get(i).toString()));
           }

           return convert_View;
       }
   }
    private ArrayList<File> Image_viewer(File externalStorageDirectory)
    {
        ArrayList<File> list1= new ArrayList<>();
        File[] image_files = externalStorageDirectory.listFiles();

        for(int i=0;i<image_files.length;i++)
        {
            if(image_files[i].isDirectory())
            {
                list1.addAll(Image_viewer(image_files[i]));
            }else
            {
                if(image_files[i].getName().endsWith(".jpg")) //file yang diminta .jpg
                {
                    list1.add(image_files[i]);
                }
            }
        }
        return list1;
    }
}
// (Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)+"Basic"));
// (Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)+"Advance"));