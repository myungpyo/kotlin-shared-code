import RxSwift

class SingleSupport {
    static func deferredJust<T>(fun: @escaping () -> T) -> Single<T> {
        return Single.deferred { Single.just(fun()) }
    }
}
