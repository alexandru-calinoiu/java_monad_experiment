package monad.experiment;

public interface Func<T, R> {
    R call(T t);
}
