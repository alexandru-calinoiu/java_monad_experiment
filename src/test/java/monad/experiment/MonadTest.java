package monad.experiment;

import junit.framework.TestCase;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.MatcherAssert.assertThat;

public class MonadTest extends TestCase {
    public void testUnitWillReturnAMonad() throws Exception {
        assertThat(Monad.unit(42), isA(Monad.class));
    }

    public void testGetAlwaysReturnsTheValue() throws Exception {
        assertThat(Monad.unit(42).get(), is(42));
    }

    public void testFlatMapAlwaysReturnAMonad() throws Exception {
        Monad<String> stringMonad = Monad.unit(42).flatMap(new Func<Integer, Monad<String>>() {
            @Override
            public Monad<String> call(Integer integer) {
                return Monad.unit(integer.toString());
            }
        });

        assertThat(stringMonad.get(), is("42"));
    }
}
