import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import io.reactivex.schedulers.TestScheduler
import org.junit.Test

import org.junit.Assert.*
import java.util.concurrent.TimeUnit

class RxKotlinTest {

    @Test
    fun blockingSubscribeTest() {

        val maxElement : Long = 5

        val source = Observable.interval(1, TimeUnit.SECONDS).take(maxElement)

        var counter : Long = 0

        source.blockingSubscribe{ i -> counter = i + 1 }

        assertEquals(maxElement, counter)
    }

    @Test
    fun blockingFirstTest() {

        val source = Observable.just("one","two","three","four","five")

        val firstValue = source.filter{ it.length == 5}.blockingFirst()

        assertTrue(firstValue.length == 5)
        assertTrue(firstValue == "three")
    }

    @Test
    fun blockingGetTest() {

        val source = Observable.just(3,2,6,1,9,4,7)

        val greaterThanFive = source.filter { it > 5 }.toList().blockingGet()

        val expectedList = listOf(6,9,7)

        assertTrue(greaterThanFive.containsAll(expectedList))
    }

    @Test
    fun blockingLastTest(){

        val source = Observable.just("one","two","three","four","five")

        val lastValue = source.blockingLast()

        assertTrue(lastValue == "five")
    }

    @Test
    fun blockingIterableTest(){

        val source = Observable.interval(1, TimeUnit.SECONDS).take(10)

        val iList = source.filter{it > 5}.blockingIterable()

        for (item in iList) assertTrue(item > 5)
    }

    @Test
    fun blockingForEachTest(){

        val source = Observable.interval(1, TimeUnit.SECONDS).take(10)

        source.filter{it > 5}.blockingForEach{ assertTrue(it > 5)}
    }


    @Test
    fun blockingNextTest(){
        val source = Observable.interval(1,TimeUnit.MICROSECONDS).take(500)

        val iList = source.blockingNext()

        for (item in iList)
            println(item)
    }

    @Test
    fun blockingLatestTest(){
        val source = Observable.interval(1,TimeUnit.MICROSECONDS).take(500)

        val iList = source.blockingLatest()

        for (item in iList)
            println(item)

    }

    @Test
    fun blockingMostRecentTest(){
        val source = Observable.interval(1,TimeUnit.MILLISECONDS).take(500)

        val iList = source.blockingMostRecent(10101)

        for (item in iList)
            println(item)
    }

    @Test
    fun `test a TestObservable`(){

        val source = Observable.interval(1,TimeUnit.SECONDS).take(10)

        val testObserver = TestObserver<Long>()

        // Subscribe to the Test observer
        source.subscribe(testObserver)

        // Check if it is subscribed successfully
        testObserver.assertSubscribed()

        // Wait for completion
        testObserver.awaitTerminalEvent()

        // Completed without any error
        testObserver.assertNoErrors()


        // Completed successfully
        testObserver.assertComplete()

        // Total emitted values
        testObserver.assertValueCount(10)

        // Value at specified location
        testObserver.assertValueAt(0,0)

        // No negative value was emitted.
        testObserver.assertNever{it < 0}
    }


    @Test
    fun `test a TestScheduler`(){

        val testObserver = TestObserver<Long>()

        val testScheduler = TestScheduler()

        val source = Observable.interval(1, TimeUnit.MINUTES, testScheduler).take(10)

        // Subscribe to the Test observer
        source.subscribe(testObserver)

        // Check if it is subscribed successfully
        testObserver.assertSubscribed()

        // No item emitted yet
        testObserver.assertValueCount(0)

        // Forward in time
        testScheduler.advanceTimeBy(5,TimeUnit.MINUTES)

        // Items emitted after specific time
        testObserver.assertValueCount(5)

        testScheduler.advanceTimeTo(8,TimeUnit.MINUTES)

        testObserver.assertValueCount(8)

        testScheduler.advanceTimeBy(10,TimeUnit.MINUTES)

        // Completed without any error
        testObserver.assertNoErrors()

        // Completed successfully
        testObserver.onComplete()

        // Total emitted values
        testObserver.assertValueCount(10)

        // Value at specified location
        testObserver.assertValueAt(0,0)

        // No negative value was emitted.
        testObserver.assertNever{it < 0}
    }

}