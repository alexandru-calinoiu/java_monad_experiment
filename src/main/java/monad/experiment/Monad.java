package monad.experiment;

public class Monad<T> {
    private T value;

    private Monad(T value) {
        this.value = value;
    }

    public static <T> Monad<T> unit(T value) {
        return new Monad<T>(value);
    }

    public <R> Monad<R> flatMap(Func<T, Monad<R>> func) {
       return func.call(this.value);
    }

    public T get() {
        return value;
    }
}
