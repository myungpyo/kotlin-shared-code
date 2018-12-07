import RxSwift

protocol SchedulerProvider {
    func io() -> SchedulerType
    
    func computation() -> SchedulerType
    
    func ui() -> SchedulerType
}
