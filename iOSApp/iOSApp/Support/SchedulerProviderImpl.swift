
import RxSwift

class SchedulerProviderImpl: SchedulerProvider {
    func io() -> SchedulerType {
//        return ConcurrentDispatchQueueScheduler(qos: .background)
        return MainScheduler.instance
    }
    
    func computation() -> SchedulerType {
//        return ConcurrentDispatchQueueScheduler(qos: .background)
        return MainScheduler.instance
    }
    
    func ui() -> SchedulerType {
        return MainScheduler.instance
    }
}
