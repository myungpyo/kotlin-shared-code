
protocol Mapper {
    associatedtype From
    associatedtype To
    
    func map(obj: From) -> To
    func mapAll(objs: [From]) -> [To]
    
    func reverse(obj: To) -> From
    func reverseAll(objs: [To]) -> [From]
}
