package lt.seb.testing.comparators;

import java.util.Comparator;

import lt.seb.testing.resolver.types.Bundle;

public class BundleComparator implements Comparator<Bundle> {

    @Override
    public int compare(Bundle bundle1, Bundle bundle2) {
        if (bundle1.getWeight() == bundle2.getWeight())
            return 0;
        else if (bundle1.getWeight() > bundle2.getWeight())
            return -1;
        else
            return 1;
    }

}