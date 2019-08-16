package avishkaar.com.universallogindemo;

import android.content.Context;
import android.os.Build;
import android.text.Html;
import android.util.Log;
import android.webkit.JavascriptInterface;

import androidx.annotation.RequiresApi;

import org.json.JSONException;
import org.json.JSONObject;

public class WebInterface {
   Context context;
    private static final String TAG = "WebInterface";
    public WebInterface(Context context) {
        this.context = context;
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    @JavascriptInterface
    public  void showString(String html)
    {

        try {
            JSONObject jsonObject = new JSONObject(Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY).toString());
            Log.e(TAG, "showString: "+ jsonObject );

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
