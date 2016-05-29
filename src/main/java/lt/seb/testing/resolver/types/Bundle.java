package lt.seb.testing.resolver.types;

public enum Bundle{
    NO_BUNDLE {

        @Override
        public int getWeight() {
            return 0;
        }

    },
    JUNIOR_SAVER {

        @Override
        public int getWeight() {
            return 0;
        }

    },
    STUDENT {

        @Override
        public int getWeight() {
            return 0;
        }

    },
    CLASSIC {

        @Override
        public int getWeight() {
            return 1;
        }

    },
    CLASSIC_PLUS {

        @Override
        public int getWeight() {
            return 2;
        }

    },
    GOLD {

        @Override
        public int getWeight() {
            return 3;
        }

    };

    public abstract int getWeight();

}