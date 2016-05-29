package lt.seb.testing.resolver.operations;

public interface Operation<T> {
    public boolean test(T value, T targetValue);
}
