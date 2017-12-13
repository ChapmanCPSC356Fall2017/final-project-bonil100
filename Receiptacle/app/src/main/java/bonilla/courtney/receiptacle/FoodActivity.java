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

public class FoodActivity extends AppCompatActivity {

    private static final int GALLERY_REQUEST = 1888;

    ImageView image;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        image = (ImageView) this.findViewById(R.id.image_from_camera);
        button = (Button) this.findViewById(R.id.take_image_from_camera);
    }


    public void takeImageFromCamera(View view) {
        Intent cameraIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        //cameraIntent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        cameraIntent.setType("image/*");
        startActivityForResult(cameraIntent, GALLERY_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == GALLERY_REQUEST && resultCode == RESULT_OK) {
            final Bundle extras = data.getExtras();
            if (extras != null) {
                Bitmap photo = extras.getParcelable("data");
                image.setImageBitmap(photo);
            }
            //Bitmap photo = (Bitmap) data.getExtras().get("data");
            //image.setImageBitmap(photo);


        }

    }
}
