package pub.devrel.easypermissions.helper;

import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import pub.devrel.easypermissions.RationaleDialogFragmentCompat;
import pub.devrel.easypermissions.RationaleDialogFragmentX;

/**
 * Implementation of {@link PermissionHelper} for Support Library host classes.
 */
public abstract class BaseSupportXPermissionsHelper<T> extends PermissionHelper<T> {

    private static final String TAG = "BSPermissionsHelper";

    public BaseSupportXPermissionsHelper(@NonNull T host) {
        super(host);
    }

    public abstract FragmentManager getSupportFragmentManager();

    @Override
    public void showRequestPermissionRationale(@NonNull String rationale,
                                               @NonNull String positiveButton,
                                               @NonNull String negativeButton,
                                               @StyleRes int theme,
                                               int requestCode,
                                               @NonNull String... perms) {

        FragmentManager fm = getSupportFragmentManager();

        // Check if fragment is already showing
        Fragment fragment = fm.findFragmentByTag(RationaleDialogFragmentCompat.TAG);
        if (fragment instanceof RationaleDialogFragmentX) {
            Log.d(TAG, "Found existing fragment, not showing rationale.");
            return;
        }

        RationaleDialogFragmentX
                .newInstance(rationale, positiveButton, negativeButton, theme, requestCode, perms)
                .showAllowingStateLoss(fm, RationaleDialogFragmentX.TAG);

    }
}
