import SharedCode
import RxSwift

class MemoListViewModel : BaseViewModel {
    
    private let schedulerProvider: SchedulerProvider
    private let getAllMemosUseCase: GetAllMemosUseCase
    private let memoMapper = MemoMapper()
    
    private let memoPublisher = ReplaySubject<[Memo]>.create(bufferSize: 1)
    
    init(schedulerProvider: SchedulerProvider, getAllMemosUseCase: GetAllMemosUseCase) {
        self.schedulerProvider = schedulerProvider
        self.getAllMemosUseCase = getAllMemosUseCase
    }
    
    func observeMemos() -> Observable<[Memo]> {
        return memoPublisher
    }
    
    func syncMemos() {
        SingleSupport.deferredJust(fun: { self.getAllMemosUseCase.execute() })
            .subscribeOn(schedulerProvider.io())
            .map { (memos) -> [Memo] in self.memoMapper.mapAll(objs: memos) }
            .observeOn(schedulerProvider.ui())
            .subscribe { event in
                switch event {
                case .success(let memos):
                    self.memoPublisher.onNext(memos)
                case .error(let error):
                    print("Error: ", error)
                }
            }
            .disposed(by: disposeBag)
    }
}
