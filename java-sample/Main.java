import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws Exception {

        final Observable<List<Integer>> localSource = Observable.just(Arrays.asList(1, 2, 3, 4, 5));
        final Observable<List<Integer>> remoteSource = Observable.just(Arrays.asList(6, 7, 8, 9, 10))
                .delay(3, TimeUnit.SECONDS);

        final Observable<List<Integer>> mergedSource = Observable.merge(remoteSource, localSource);

        mergedSource.subscribe(mergedList -> {
            for (int i : mergedList) {
                System.out.println(i);
            }
        });

        Thread.sleep(5000);
    }
}
