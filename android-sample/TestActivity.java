import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Test activity.
 */
public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);									// Call the super method
        setContentView(R.layout.activity_test);			// Load the activity_test.xml layout file
        
        Toast.makeText(this, "Application is running!", Toast.LENGTH_SHORT).show();
    }
}
