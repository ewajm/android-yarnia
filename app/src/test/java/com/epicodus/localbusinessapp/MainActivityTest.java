package com.epicodus.localbusinessapp;

import android.os.Build;
import android.widget.Spinner;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Guest on 11/17/16.
 */

@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)
public class MainActivityTest {
    private MainActivity activity;

    @Before
    public void setup() {
        activity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void validateSpinnerContent() {
        Spinner fiberSpinner = (Spinner) activity.findViewById(R.id.fiberSpinner);
        String[] fiberArray = activity.getResources().getStringArray(R.array.fibers);
        assertEquals(fiberArray.length, fiberSpinner.getAdapter().getCount());
    }
}
