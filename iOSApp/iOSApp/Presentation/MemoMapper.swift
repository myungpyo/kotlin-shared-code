import SharedCode

class MemoMapper : Mapper {
    
    func map(obj: MemoEntity) -> Memo {
        return Memo(id: obj.id, title: obj.title, content: obj.content, createdAt: obj.createdAt, lastModifiedAt: obj.lastModifiedAt)
    }
    
    
    func mapAll(objs: [MemoEntity]) -> [Memo] {
        return objs.map { map(obj: $0) }
    }
    
    func reverse(obj: Memo) -> MemoEntity {
        return MemoEntity(id: obj.id, title: obj.title, content: obj.content, createdAt: obj.createdAt, lastModifiedAt: obj.lastModifiedAt)
    }
    
    func reverseAll(objs: [Memo]) -> [MemoEntity] {
        return objs.map { reverse(obj: $0) }
    }
}
