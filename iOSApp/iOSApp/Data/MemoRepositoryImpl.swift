import SharedCode

class MemoRepositoryImpl: NSObject, MemoRepository {
    
    let mapper = MemoEntityMapper()
    
    let dataSource: MemoDataSource
    
    init(dataSource: MemoDataSource) {
        self.dataSource = dataSource
    }
    
    func getAllMemos() -> [MemoEntity] {
        return mapper.mapAll(objs: dataSource.getAllMemos())
    }
    
    func getMemo(id: Int32) -> MemoEntity? {
        guard let memo = dataSource.getMemo(id: id) else {
            return nil
        }
        return mapper.map(obj: memo)
    }
}
