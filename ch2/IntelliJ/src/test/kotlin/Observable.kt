import io.reactivex.*
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.AsyncSubject
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.ReplaySubject
import java.util.concurrent.TimeUnit


fun main(args: Array<String>){

//    val mSubject = AsyncSubject.create<Long>()
//    // Defining the behaviour of Subject as observer
//    mSubject.subscribeBy (
//            onNext = {
//                println("Subject 1 observing: $it")
//            }, onComplete = {
//                println("Subject 1 : onComplete")
//            }
//    )
//    //Subscribing to the observable using the subject
//    Observable.interval(10, TimeUnit.MILLISECONDS)
//            .take(10)
//            .subscribe(mSubject)
//    //Subject behaving as an observable
//    val newObservable = mSubject.`as` {
//        it
//    }
//    Thread.sleep(40) //delay before the second observer subscribes to an observable
//    newObservable.subscribeBy (
//            onNext = {
//                println("Subject 2 observing: $it")
//            }, onComplete = {
//        println("Subject 2 : onComplete")
//    }
//    )
//    Thread.sleep(10000)

//    var item = 1
    val observable =Observable.defer {
        Observable.just(1)
    }
    observable.toFlowable(BackpressureStrategy.BUFFER);
//    println("First observer subscribing")
//    observable.subscribe {
//        println("receiving $it")
//    }
//    item = 2
//    println("Second observer subscribing")
//    observable.subscribe {
//        println("receiving $it")
//    }
    Flowable.range(1, 1000)
    .map {
        println("mapping $it")
        it
    }
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.computation())
            .subscribeBy {
//                Thread.sleep(1000)
                println("Received $it")
            }
    Thread.sleep(10000000)

    val demoFlowable = Flowable.create<Int>({
        emitter -> emitter.onNext(1)
        emitter.onNext(2)
        emitter.onComplete()
    }, BackpressureStrategy.BUFFER)

}