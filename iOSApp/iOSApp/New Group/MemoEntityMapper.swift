import SharedCode

class MemoEntityMapper : Mapper {

    func map(obj: MemoModel) -> MemoEntity {
        return MemoEntity(id: obj.id, title: obj.title, content: obj.content, createdAt: obj.createdAt, lastModifiedAt: obj.lastModifiedAt)
    }
    
    func mapAll(objs: [MemoModel]) -> [MemoEntity] {
        return objs.map { map(obj: $0) }
    }
    
    func reverse(obj: MemoEntity) -> MemoModel {
        return MemoModel(id: obj.id, title: obj.title, content: obj.content, createdAt: obj.createdAt, lastModifiedAt: obj.lastModifiedAt)
    }
    
    func reverseAll(objs: [MemoEntity]) -> [MemoModel] {
        return objs.map { reverse(obj: $0) }
    }
}
