package pub.devrel.easypermissions.helper;

import android.content.Context;
import android.support.annotation.NonNull;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

/**
 * Permissions helper for {@link Fragment} from the support library.
 */
class SupportFragmentXPermissionHelper extends BaseSupportXPermissionsHelper<Fragment> {

    public SupportFragmentXPermissionHelper(@NonNull Fragment host) {
        super(host);
    }

    @Override
    public FragmentManager getSupportFragmentManager() {
        return getHost().getChildFragmentManager();
    }

    @Override
    public void directRequestPermissions(int requestCode, @NonNull String... perms) {
        getHost().requestPermissions(perms, requestCode);
    }

    @Override
    public boolean shouldShowRequestPermissionRationale(@NonNull String perm) {
        return getHost().shouldShowRequestPermissionRationale(perm);
    }

    @Override
    public Context getContext() {
        return getHost().getActivity();
    }
}
