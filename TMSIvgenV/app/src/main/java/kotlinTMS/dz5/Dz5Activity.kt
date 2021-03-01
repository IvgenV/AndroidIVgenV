package kotlinTMS.dz5

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.tmsivgenv.BuildConfig
import com.example.tmsivgenv.R
import com.google.zxing.BarcodeFormat
import com.journeyapps.barcodescanner.BarcodeEncoder
import timber.log.Timber
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

class Dz5Activity : AppCompatActivity() {

    lateinit var tvText:TextView
    lateinit var image:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dz5)

        tvText = findViewById(R.id.textViewDz5)

        tvText.text = SimpleDateFormat("HH:mm:ss", Locale.ENGLISH).format(Date(BuildConfig.TIME))
        tvText.text = "${tvText.text.toString()}\nApplication_ID: ${BuildConfig.APPLICATION_ID}\nbuild type: ${BuildConfig.BUILD_TYPE}\n" +
                "Flavour: ${BuildConfig.FLAVOR}\nVersion name: ${BuildConfig.VERSION_NAME}\nid:${BuildConfig.ID}\n" +
                "String from resources: ${getString(R.string.string_from_res)}"
        image = findViewById(R.id.imageViewDz5)
        Glide.with(this).load("https://i1.wp.com/sova.ponominalu.ru/wp-content/uploads/2017/12/Radiohead.jpg?w=1000&ssl=1").centerCrop().
                circleCrop().into(image)
        Timber.plant(Timber.DebugTree())
        Timber.e("All done!")

        try {
            val barcodeEncoder = BarcodeEncoder()
            val bitmap = barcodeEncoder.encodeBitmap("It's works!",BarcodeFormat.QR_CODE,400,400)
            val imageView = findViewById<ImageView>(R.id.barcode)
            imageView.setImageBitmap(bitmap)
        }catch (e:Exception){
            Timber.e("ERRRROOOORRR!!")
        }
    }

}