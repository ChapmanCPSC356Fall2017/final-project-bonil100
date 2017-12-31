package bonilla.courtney.receiptacle;

import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.graphics.BitmapFactory;
import android.database.Cursor;

import java.io.IOException;

public class GasActivity extends AppCompatActivity implements View.OnClickListener{

    private static final int GALLERY_REQUEST = 1888;

    ImageView image;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        image = (ImageView) this.findViewById(R.id.image_from_camera);
        button = (Button) this.findViewById(R.id.take_image_from_camera);

        button.setOnClickListener(this);
    }


    public void onClick(View view) {

        Intent intent = new Intent();

        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), GALLERY_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);

        if (requestCode == GALLERY_REQUEST && resultCode == RESULT_OK && data!= null && data.getData() != null) {
            Uri uri =data.getData();

            try{
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);

                ImageView image = (ImageView) findViewById(R.id.image_from_camera);
                image.setImageBitmap(bitmap);
            }

            catch (IOException e){
                e.printStackTrace();
            }




        }



    }

}
